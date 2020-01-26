/*

        @Author : Tejas07PSK (Palash Sarkar),
        @CreatedON : 26 Jan, 2020, 12:00 PM,
        @File-Name : User.java

 */

package org.gadstn.msldap.pojos;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry( base = "dc=nsroot,dc=net", objectClasses = { "top", "person", "organizationalPerson", "inetOrgPerson" } )
public class User  {

    @Id
    private Name id;

    private @Attribute( name = "cn" ) String userfullname;

    private @Attribute( name = "uid" ) String userid;

    private @Attribute( name = "userPassword" ) String userpass;

    private @Attribute( name = "email" ) String useremail;

    private @Attribute( name = "phone" ) String userphone;

    public User () { }

    public User ( String userfullname, String userPass, String userEmail, String userPhone ) {

        this.userfullname = userfullname; this.userpass = userPass;
        this.useremail = userEmail; this.userphone = userPhone;

    }

    public Name getId () { return ( id ); }

    public void setId ( Name id ) { this.id = id; }

    public String getUserfullname () { return ( userfullname ); }

    public void setUserfullname ( String userfullname ) { this.userfullname = userfullname; }

    public String getUserPass () { return ( userpass ); }

    public void setUserPass ( String userpass ) { this.userpass = userpass; }

    public String getUserEmail () { return ( useremail ); }

    public void setUserEmail ( String useremail ) { this.useremail = useremail; }

    public String getUserPhone () { return ( userphone ); }

    public void setUserPhone ( String userphone ) { this.userphone = userphone; }

    public String getUserid () { return ( userid ); }

    public void setUserid ( String userid ) { this.userid = userid; }

    @Override
    public String toString () {

        return ( "{ " + "\"soeid\": \'" + userid + "\', " + "\"fullname\": \'" + userfullname + "\', " + "\"email\": \'" + useremail + "\', " + "\"phone\": \'" + userphone + "\', " + "\"userdn\": \'" + id + "\' " + "}" );

    }

}
