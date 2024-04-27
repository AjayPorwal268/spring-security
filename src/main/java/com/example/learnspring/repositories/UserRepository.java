package com.example.learnspring.repositories;

import com.example.learnspring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("""
        select u from User u where u.name = :name
    """)
    Optional<User> findUserByName(String name);
}
