/*

        @Author : Tejas07PSK (Palash Sarkar),
        @CreatedON : 28 Jan, 2020, 9:44 AM,
        @File-Name : LdapServiceImpl.java

 */

package org.gadstn.msldap.serviceimpl;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import org.gadstn.msldap.pojos.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LdapServiceImpl implements LdapService {

    @Autowired
    private BeanFactory beanFactory;

    private static final String [] schAttrs = { "cn", "uid", "mail", "sn" };
    private static final String ad_root = "DC=example,DC=com", user_suffix_dom = "@nsroot.net";

    private LdapContext ctx;
    private SearchControls filter;
    private NamingEnumeration res;
    private Attributes attrs;
    private Hashtable < String, String > prop;

    public LdapServiceImpl () {

        this.ctx = null;
        this.filter = null;
        this.res = null;
        this.attrs = null;
        this.prop = new Hashtable <> ();

        this.prop.put( Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory" );
        this.prop.put( Context.SECURITY_AUTHENTICATION, "Simple" );
        this.prop.put( Context.PROVIDER_URL, "ldap://ldap.forumsys.com:389/" );
        this.prop.put( Context.SECURITY_PRINCIPAL, "" );
        this.prop.put( Context.SECURITY_CREDENTIALS, "" );

    }

    @Override
    synchronized public User getUserDetailsFromLdap ( final String userid, final String userpass ) {

        User u = null;
        prop.replace( Context.SECURITY_PRINCIPAL, ( "uid=" + userid + ",dc=example,dc=com" ) );
        prop.replace( Context.SECURITY_CREDENTIALS, userpass );
        try {

            System.out.println( "Connecting to ldap server .... !!" );
            System.out.println( "Authenticating ...." );
            ctx = new InitialLdapContext( prop, null);
            System.out.println( "Connection/Auth Successful...." );
            System.out.println( "Getting required attributes ..." );
            filter = new SearchControls ();
            filter.setSearchScope( SearchControls.SUBTREE_SCOPE );
            filter.setReturningAttributes( schAttrs );
            res = ctx.search( ad_root, "uid=" + userid, filter );
            if ( res.hasMore() ) {

                attrs = ( (SearchResult) res.next() ).getAttributes();
                u = beanFactory.getBean( User.class, (String) attrs.get( "cn" ).get(), (String) attrs.get( "uid" ).get(), (String) attrs.get( "mail" ).get(), (String) attrs.get( "sn" ).get() );
                System.out.println( u.toString() );

            } else { u = new User (); }
            System.out.println( "Done !!" );
            ctx.close();

        } catch( NamingException ex ) { System.out.println( "LDAP Connection/Auth : FAILED" ); ex.printStackTrace(); }
        finally { ctx = null; filter = null; res = null; attrs = null; }
        return ( u );

    }

}
