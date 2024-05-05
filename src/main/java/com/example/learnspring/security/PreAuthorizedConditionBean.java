package com.example.learnspring.security;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class PreAuthorizedConditionBean {

    public boolean computeCondition(String name) {
        //Business logic here
        String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        if(loggedInUser.equals(name)) {
            return true;
        }
        return false;
    }
}
