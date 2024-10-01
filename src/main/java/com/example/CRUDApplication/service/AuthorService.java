package com.example.CRUDApplication.service;

import com.example.CRUDApplication.dto.AuthorDTO;

import java.util.List;
import java.util.NoSuchElementException;

public interface AuthorService {

    List<AuthorDTO> getAllAuthors(String name, String description);

    AuthorDTO getAuthorById(int id);

    AuthorDTO getAuthorByName(String name);

    List<AuthorDTO> getAuthorByNameAndDescriptionLike(String name,String description);

    AuthorDTO createAuthor(AuthorDTO authorDTO);

    AuthorDTO updateAuthor(int authorId,AuthorDTO authorDTO) throws NoSuchElementException;

    void deleteAuthor(int authorId) throws NoSuchElementException;



}
