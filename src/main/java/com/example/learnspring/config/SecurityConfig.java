package com.example.learnspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${secret.key}")
    private String key;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.httpBasic()
                .and()
                .authorizeRequests()
                .requestMatchers(HttpMethod.GET, "/test").hasAuthority("read")
                .anyRequest().authenticated()
                .and().csrf().disable()
               // .anyRequest().authenticated() //End Point Level Authorization
//                .anyRequest().permitAll()
//                .anyRequest().denyAll()
//                .anyRequest().hasAnyAuthority("admin")
//                .anyRequest().hasRole("admin")
//                .anyRequest().hasAnyRole("ADMIN, "VISITOR")
                .build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();

        var u1 = User.withUsername("bill")
                .password(passwordEncoder().encode("2345"))
                .authorities("read").build();

        var u2 = User.withUsername("john")
                .password(passwordEncoder().encode("2345"))
                .authorities("write").build();

        uds.createUser(u1);
        uds.createUser(u2);

        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

}
