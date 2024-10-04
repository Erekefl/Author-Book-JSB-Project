package com.example.CRUDApplication.controller;

import com.example.CRUDApplication.dto.AuthorDTO;
import com.example.CRUDApplication.service.AuthorService;
import com.example.CRUDApplication.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor

public class AuthorController {
    private final AuthorService authorService;


    @GetMapping("/all")
    public ResponseEntity<List<AuthorDTO>> getAllAuthor(@RequestParam(required=false) String name,
                                                        @RequestParam( required=false) String description ){
        return ResponseEntity.ok(authorService.getAllAuthors(name,description));
        //неге статус ок баскаларда статус
    }


    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable int id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PostMapping
    public ResponseEntity<?> createNewAuthor(@Validated @RequestBody AuthorDTO authorDTO){
//        if(StringUtil.stringIsNullOrEmpty(authorDTO.getName())){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("")
//        }

        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.createAuthor(authorDTO));
    }


    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable int id,@RequestBody AuthorDTO authorDTO){
        try{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(authorService.updateAuthor(id,authorDTO));
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable int id){
        try{
            authorService.deleteAuthor(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("author successfully deleted");
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
