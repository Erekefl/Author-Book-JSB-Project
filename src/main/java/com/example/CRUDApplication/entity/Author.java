package com.example.CRUDApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;


//    @OneToMany
//    private HashSet<Book> books;
}
