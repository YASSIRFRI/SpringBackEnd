package com.yassir.demo.securityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.yassir.demo.repositories.UserRepository;



@Configuration
@EnableWebSecurity
public class WebSecurtiyConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserRepository userRepo;
@Override
protected void configure(HttpSecurity http) throws Exception {
http.csrf().disable();
http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(email -> userRepo.findByEmail(email).stream().findFirst()
.orElseThrow(() -> new RuntimeException("User not found")));
}

@Override @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
