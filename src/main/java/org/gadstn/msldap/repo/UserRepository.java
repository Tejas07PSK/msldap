package org.gadstn.msldap.repo;

import org.gadstn.msldap.pojos.User;
import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends LdapRepository < User > {

    User findByUseridAndUserpass ( String userid, String userpass );

}
