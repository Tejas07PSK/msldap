/*

        @Author : Tejas07PSK (Palash Sarkar),
        @CreatedON : 26 Jan, 2020, 4:38 PM,
        @File-Name : UserService.java

 */

package org.gadstn.msldap.services;

import org.gadstn.msldap.pojos.User;
import org.gadstn.msldap.serviceimpl.LdapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class UserService {

    @Autowired
    private LdapService ldapService;

    public String authenticate ( final String soeid, final String password ) {

        User user = ldapService.getUserDetailsFromLdap( soeid, password );
        if ( user != null ) { return ( user.toString() ); }
        else { return ( "Auth failed!!" ); }

    }

    private String toSHA ( final String password ) {

        String base64;
        try {

            MessageDigest digest = MessageDigest.getInstance( "SHA" ); digest.update( password.getBytes() );
            base64 = Base64.getEncoder().encodeToString( digest.digest() );

        } catch ( NoSuchAlgorithmException e ) { throw new RuntimeException( e ); }
        return ( "{SHA}" + base64 );

    }

}
