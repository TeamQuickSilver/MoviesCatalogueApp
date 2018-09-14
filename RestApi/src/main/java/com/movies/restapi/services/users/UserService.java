package com.movies.restapi.services.users;

import com.movies.restapi.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    User register(String username, String password);

    UserDetails loadUserByUsername(String username);

}


