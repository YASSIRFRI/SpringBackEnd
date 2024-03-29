
package com.yassir.demo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService{ 
    UserDetails loadUserByEmail(String Email) throws UsernameNotFoundException;
}