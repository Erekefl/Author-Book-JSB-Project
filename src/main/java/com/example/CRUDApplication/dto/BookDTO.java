package com.example.CRUDApplication.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

   private Integer id;
   private String name;
   @NotBlank(message = "title degen pole bos bolmaui kerek")
   private String title;
   private String description;

   private AuthorDTO authorDTO;
}
