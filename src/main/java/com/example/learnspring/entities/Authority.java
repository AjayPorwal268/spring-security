package com.example.learnspring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="authorities")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Authority {

    @Id
    @GeneratedValue
    private int id;

    private String name;


    @ManyToMany(mappedBy="authorities")
    private List<User> users;

}
