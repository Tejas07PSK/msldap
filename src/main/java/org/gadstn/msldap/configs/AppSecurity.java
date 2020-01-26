/*

        @Author : Tejas07PSK (Palash Sarkar),
        @CreatedON : 26 Jan, 2020, 5:31 PM,
        @File-Name : AppSecurity.java

 */

package org.gadstn.msldap.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity( debug = true )
public class AppSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure ( HttpSecurity http ) throws Exception { http.authorizeRequests().anyRequest().permitAll(); http.csrf().disable(); }

}

/* ye class hai security ka, ise thik se configure karna hai for security, i.e., certs, csrf, https, ldaps etc */