package com.example.CRUDApplication.controller;

import com.example.CRUDApplication.dto.BookDTO;
import com.example.CRUDApplication.entity.Book;
import com.example.CRUDApplication.repository.BookRepo;
import com.example.CRUDApplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@RequestMapping("/book")
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getAllBook(@RequestParam String name, @RequestParam(name = "desc")String description){
      return ResponseEntity.ok(bookService.getAllBooks(name,description));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id){
    BookDTO bookData = bookService.getBookById(id);
    try {
        return ResponseEntity.status(HttpStatus.OK).body("kitap bar");
    }catch (NoSuchElementException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("kitap tabilmadi");
    }
//            bookRepo.findById(id);

//    if (bookData.isPresent()){
//        return new ResponseEntity<>(bookData.get(),HttpStatus.OK);
//    }
//    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookDTO));
//    Book obj = bookDTO.save(book);
//
//    return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBookById(@PathVariable int id, @RequestBody BookDTO bookDTO){

        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookService.updateBook(id,bookDTO));
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
//    Optional<Book> oldBookData = bookRepo.findById(id);
//
//    if (oldBookData.isPresent()){
//        Book updateBookData = oldBookData.get();
//        updateBookData.setTitle(newBookData.getTitle());
//       updateBookData.setAuthor(newBookData.getAuthor());
//
//       Book book = bookRepo.save(updateBookData);
//       return new ResponseEntity<>(book,HttpStatus.OK);
//
//    }
//    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable("id") int id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("book successfully deleted");
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
