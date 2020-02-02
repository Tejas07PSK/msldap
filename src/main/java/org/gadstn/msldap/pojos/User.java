/*

        @Author : Tejas07PSK (Palash Sarkar),
        @CreatedON : 26 Jan, 2020, 12:00 PM,
        @File-Name : User.java

 */

package org.gadstn.msldap.pojos;

public class User  {

    private String userfullname;

    private String userid;

    private String useremail;

    private String userphone;

    public User () { }

    public User ( String userfullname, String userid, String useremail, String userphone ) {

        this.userfullname = userfullname; this.userid = userid;
        this.useremail = useremail; this.userphone = userphone;

    }

    synchronized public String getUserfullname () { return ( userfullname ); }

    synchronized public void setUserfullname ( String userfullname ) { this.userfullname = userfullname; }

    synchronized public String getUserEmail () { return ( useremail ); }

    synchronized public void setUserEmail ( String useremail ) { this.useremail = useremail; }

    synchronized public String getUserPhone () { return ( userphone ); }

    synchronized public void setUserPhone ( String userphone ) { this.userphone = userphone; }

    synchronized public String getUserid () { return ( userid ); }

    synchronized public void setUserid ( String userid ) { this.userid = userid; }

    @Override
    synchronized public String toString () {

        return ( "{ \"Auth\": \'OK!!\', " + "\"soeid\": \'" + userid + "\', " + "\"fullname\": \'" + userfullname + "\', " + "\"email\": \'" + useremail + "\', " + "\"phone\": \'" + userphone + "\' " + "}" );

    }

}
