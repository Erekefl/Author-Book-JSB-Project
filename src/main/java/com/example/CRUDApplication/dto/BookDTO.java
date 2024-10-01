package com.example.CRUDApplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

   private Integer id;
   private String name;
   private String title;
   private String description;

    private AuthorDTO authorDTO;
}
