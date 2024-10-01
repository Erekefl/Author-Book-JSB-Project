package com.example.CRUDApplication.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String name;

    private String description;

    private  Integer quantity;

    @ManyToOne
    private Author author;




}
