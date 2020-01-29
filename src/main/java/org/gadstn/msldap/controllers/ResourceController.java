/*

        @Author : Tejas07PSK (Palash Sarkar),
        @CreatedON : 26 Jan, 2020, 9:12 PM,
        @File-Name : ResourceController.java

 */

package org.gadstn.msldap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceController {

    @GetMapping( "/login" )
    public String returnLoginPage() { return ( "testlogin.html" ); }

    @GetMapping( "/" )
    public String returnHomePage() { return ( "home.html" ); }

}
