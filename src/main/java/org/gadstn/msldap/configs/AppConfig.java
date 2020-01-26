/*

        @Author : Tejas07PSK (Palash Sarkar),
        @CreatedON : 26 Jan, 2020, 1:21 PM,
        @File-Name : AppConfig.java

 */

package org.gadstn.msldap.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
@PropertySource( "classpath:application.properties" )
@ComponentScan( basePackages = { "org.gadstn.msldap.*", "org.gadstn.msldap.**" } )
@Profile( "embedded" )
@EnableLdapRepositories( basePackages = "org.gadstn.msldap.**" )
public class AppConfig {

    @Autowired
    private Environment env;

    /*@Bean
    LdapTemplate ldapTemplate(LdapContextSource contextSource) {
        return new LdapTemplate(contextSource);
    }*/

    /* Upar me jo commented method hai use thikse tab configure karna hai,
    * jab remote/corporate ldap use karenge tab. We'll look into that later. */
}
