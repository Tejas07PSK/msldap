package org.gadstn.msldap;

import org.gadstn.msldap.MsladpApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure ( SpringApplicationBuilder application ) { return application.sources( MsladpApplication.class ); }

}
