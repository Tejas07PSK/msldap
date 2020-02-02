/*

        @Author : Tejas07PSK (Palash Sarkar),
        @CreatedON : 26 Jan, 2020, 5:10 PM,
        @File-Name : ApiController.java

 */

package org.gadstn.msldap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.gadstn.msldap.services.UserService;
import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    private UserService userService;

    @RequestMapping( value = "/ldap/auth/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    synchronized public String auth( @RequestBody Map < String, String > req ) throws Exception {

        return userService.authenticate( req.get( "soeid" ), req.get( "pass" ) );

    }

}
