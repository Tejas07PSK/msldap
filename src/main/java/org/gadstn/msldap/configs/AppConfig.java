/*

        @Author : Tejas07PSK (Palash Sarkar),
        @CreatedON : 26 Jan, 2020, 1:21 PM,
        @File-Name : AppConfig.java

 */

package org.gadstn.msldap.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.gadstn.msldap.pojos.User;
import java.lang.String;

@Configuration
@PropertySource( "classpath:application.properties" )
@ComponentScan( basePackages = { "org.gadstn.msldap.*", "org.gadstn.msldap.**" } )
@Profile( "default" )
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    @Scope( "prototype" )
    public User user( String userfullname, String userid, String useremail, String userphone ) {

        return ( new User ( userfullname, userid, useremail, userphone ) );

    }

}
