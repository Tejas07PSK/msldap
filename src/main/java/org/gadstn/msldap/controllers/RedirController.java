/*

        @Author : Tejas07PSK (Palash Sarkar),
        @CreatedON : 26 Jan, 2020, 8:40 PM,
        @File-Name : Redircontroller.java

 */

package org.gadstn.msldap.controllers;

import org.gadstn.msldap.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RedirController {

    @Autowired
    private UserService userService;

    @RequestMapping( value = "/form/ldap/auth/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public String authenticate( @RequestParam Map< String, String > paramMap ) throws Exception {

        return userService.authenticate( paramMap.get( "soeid" ), paramMap.get( "pass" ) );

    }

}
