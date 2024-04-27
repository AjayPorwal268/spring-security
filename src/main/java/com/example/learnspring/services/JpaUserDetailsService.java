package com.example.learnspring.services;

import com.example.learnspring.httpbody.User;
import com.example.learnspring.repositories.UserRepository;
import com.example.learnspring.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    public List<User> getUserList() {

        List<com.example.learnspring.entities.User> userList =  userRepository.findAll();
        //System.out.println(userList);
        if(!userList.isEmpty()) {
            return  userList.stream().map((u) -> new User(u.getName(), u.getPassword())).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("in loadUserByUsernameloadUserByUsername");
        var u = userRepository.findUserByName(username);
        System.out.println(u);
        return u.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("UserName not found "+ username));
    }
}
