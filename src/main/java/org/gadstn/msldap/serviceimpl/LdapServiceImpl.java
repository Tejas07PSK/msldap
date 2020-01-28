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
import org.springframework.stereotype.Component;

@Component
public class LdapServiceImpl implements LdapService {

    @Override
    public User getUserDetailsFromLdap ( String userid, String userpass ) {

        User u = null; LdapContext ctx = null;
        Hashtable prop = new Hashtable ();
        prop.put( Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory" );
        prop.put( Context.SECURITY_AUTHENTICATION, "Simple" );
        prop.put( Context.SECURITY_PRINCIPAL, "uid=" + userid + ",ou=people,dc=nsroot,dc=net" );
        prop.put( Context.SECURITY_CREDENTIALS, userpass );
        prop.put( Context.PROVIDER_URL, "ldap://localhost:10389" );
        String [] schAttrs = { "cn", "sn", "uid", "email", "phone" };
        SearchControls filter = null; NamingEnumeration res = null; Attributes attrs;
        try {

            System.out.println( "Connecting to ldap server .... !!" );
            System.out.println( "Authenticating ...." );
            ctx = new InitialLdapContext( prop, null);
            System.out.println( "Connection/Auth Successful...." );
            System.out.println( "Getting required attributes ..." );
            filter = new SearchControls ();
            filter.setSearchScope( SearchControls.SUBTREE_SCOPE );
            filter.setReturningAttributes( schAttrs );
            res = ctx.search( "DC=nsroot,DC=net", "sAMAccountName=" + userid + "@nsroot.net", filter );
            if ( res.hasMore() ) {

                attrs = ( (SearchResult) res.next() ).getAttributes();
                u = new User ( (String) attrs.get( "cn" ).get(), (String) attrs.get( "uid" ).get(), (String) attrs.get( "email" ).get(), (String) attrs.get( "phone" ).get() );
                System.out.println( u.toString() );

            }
            System.out.println( "Done !!" );

        } catch( NamingException ex ) { System.out.println( "LDAP Connection/Auth : FAILED" ); ex.printStackTrace(); }
        return ( u );

    }

}
