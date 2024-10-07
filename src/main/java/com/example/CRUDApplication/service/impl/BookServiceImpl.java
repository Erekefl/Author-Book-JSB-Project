package com.example.CRUDApplication.service.impl;

import com.example.CRUDApplication.dto.BookDTO;
import com.example.CRUDApplication.entity.Book;
import com.example.CRUDApplication.mapper.BookMapper;
import com.example.CRUDApplication.repository.BookRepo;
import com.example.CRUDApplication.service.BookService;
import com.example.CRUDApplication.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final BookMapper bookMapper;


    @Override
    public List<BookDTO> getAllBooks(String title,String description) {
        List<Book> books = new ArrayList<>();

        Specification<Book> spec = Specification.where(null);


//        if(StringUtil.stringIsNullOrEmpty(title) && StringUtil.stringIsNullOrEmpty(description)){
//            books = bookRepo.findAll();
//        }


//        if ((!StringUtil.stringIsNullOrEmpty(title) && StringUtil.stringIsNullOrEmpty(description))){
//            books = bookRepo.findByTitle(title);
//        }
//        if (StringUtil.stringIsNullOrEmpty(title) && !StringUtil.stringIsNullOrEmpty(description)){
//            books = bookRepo.getAllWhereDescriptionLike(description);
//        }
//        if (!StringUtil.stringIsNullOrEmpty(title) && !StringUtil.stringIsNullOrEmpty(description)){
//            books = bookRepo.getByTitleAndDescriptionLike(title, description);
//        }

        books = bookRepo.findAll(spec);
        return bookMapper.toDto(books);
    }

    @Override
    public BookDTO getBookById(int id) {
        Optional<Book> book = bookRepo.findById(id);
        return book.map(bookMapper::toDto).orElse(null);
    }

    @Override
    public BookDTO getBookByName(String name) {
        Optional<Book> book = bookRepo.findFirstByName(name);
        return book.map(bookMapper::toDto).orElse(null);
    }

    @Override
    public List<BookDTO> getBookByNameAndDescription(String title, String description) {
    var resultEntities = bookRepo.getByTitleAndDescriptionLike(title,description);
        return bookMapper.toDto(resultEntities);
    }
//    @Override
//    public List<AuthorDto> getAuthorByNameAndDescriptionLike(String name, String desc) {
//        var resultEntities = authorRepository.getAuthorsByNameAndDescriptionLike(name,desc);
//        return authorMapper.toDto(resultEntities);
//
//    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
    Book entity = bookMapper.toEntity(bookDTO);
    var resultEntity = bookRepo.save(entity);
        return bookMapper.toDto(resultEntity);
    }

    @Override
    public BookDTO updateBook(int id, BookDTO bookDTO)throws NoSuchElementException {
        var existingEntity = bookRepo.findById(id);
        if(existingEntity.isPresent()){
            var entity = existingEntity.get();
            entity.setName(bookDTO.getName());
            entity.setTitle(bookDTO.getTitle());
            entity.setDescription(bookDTO.getDescription());
            return bookMapper.toDto(entity);
        }else {
           throw new NoSuchElementException("book not found");
        }


    }

    @Override
    public void deleteBook(int bookId)throws NoSuchElementException {
    var existingEntity = bookRepo.findById(bookId);
    if (existingEntity.isPresent()){
        bookRepo.deleteById(bookId);
    }else {
        throw new NoSuchElementException("book not found");
    }

    }

}
