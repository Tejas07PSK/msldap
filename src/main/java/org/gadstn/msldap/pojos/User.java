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

    public String getUserfullname () { return ( userfullname ); }

    public void setUserfullname ( String userfullname ) { this.userfullname = userfullname; }

    public String getUserEmail () { return ( useremail ); }

    public void setUserEmail ( String useremail ) { this.useremail = useremail; }

    public String getUserPhone () { return ( userphone ); }

    public void setUserPhone ( String userphone ) { this.userphone = userphone; }

    public String getUserid () { return ( userid ); }

    public void setUserid ( String userid ) { this.userid = userid; }

    @Override
    public String toString () {

        return ( "{ \"Auth\": \'OK!!\', " + "\"soeid\": \'" + userid + "\', " + "\"fullname\": \'" + userfullname + "\', " + "\"email\": \'" + useremail + "\', " + "\"phone\": \'" + userphone + "\' " + "}" );

    }

}
