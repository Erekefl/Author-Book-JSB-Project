package com.example.CRUDApplication.dto;


import com.example.CRUDApplication.entity.Book;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class AuthorDTO {

    Integer id;
    @NotBlank(message = "Name degen pole bos bolmaui kerek")
    String name;
    private String description;

    Set<BookDTO> bookSet = new HashSet<>();


}
