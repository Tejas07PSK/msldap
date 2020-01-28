/*

        @Author : Tejas07PSK (Palash Sarkar),
        @CreatedON : 26 Jan, 2020, 1:21 PM,
        @File-Name : AppConfig.java

 */

package org.gadstn.msldap.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource( "classpath:application.properties" )
@ComponentScan( basePackages = { "org.gadstn.msldap.*", "org.gadstn.msldap.**" } )
@Profile( "default" )
public class AppConfig {

    @Autowired
    private Environment env;

}
