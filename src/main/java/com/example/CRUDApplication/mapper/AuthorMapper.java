package com.example.CRUDApplication.mapper;

import com.example.CRUDApplication.dto.AuthorDTO;
import com.example.CRUDApplication.entity.Author;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorMapper {

    private final ModelMapper modelmapper;

    public AuthorDTO toDto(Author author){
        return modelmapper.map(author,AuthorDTO.class);
    }
    public Author toEntity(AuthorDTO authorDTO){
        return modelmapper.map(authorDTO,Author.class);
    }

   public List<AuthorDTO> toDto(List<Author> authorList){
        return authorList.stream().map(this::toDto).toList();
    }
}
