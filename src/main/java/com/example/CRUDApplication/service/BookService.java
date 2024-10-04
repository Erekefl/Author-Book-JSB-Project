package com.example.CRUDApplication.service;

import com.example.CRUDApplication.dto.BookDTO;
import com.example.CRUDApplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface BookService{

    List<BookDTO> getAllBooks(String title, String description);

    BookDTO getBookById(int id);



    BookDTO getBookByName(String name);

    List<BookDTO> getBookByNameAndDescription(String name,String description);

    BookDTO createBook(BookDTO bookDTO);

    BookDTO updateBook(int id,BookDTO bookDTO) throws NoSuchElementException;

    void deleteBook(int bookId)throws NoSuchElementException;

}
