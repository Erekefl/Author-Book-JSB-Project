package com.example.CRUDApplication.dto;


import com.example.CRUDApplication.entity.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class AuthorDTO {

    Integer id;
    String name;
    private String description;

    Set<BookDTO> bookSet = new HashSet<>();


}
