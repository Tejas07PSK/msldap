package org.gadstn.msldap.serviceimpl;

import org.gadstn.msldap.pojos.User;

public interface LdapService {

    User getUserDetailsFromLdap ( String userid, String userpass );

}
