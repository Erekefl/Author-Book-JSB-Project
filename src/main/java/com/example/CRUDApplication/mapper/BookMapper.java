package com.example.CRUDApplication.mapper;

import com.example.CRUDApplication.dto.BookDTO;
import com.example.CRUDApplication.entity.Book;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookMapper {

    private final ModelMapper modelMapper;

    public BookDTO toDto(Book book){
        return modelMapper.map(book,BookDTO.class);
    }

    public Book toEntity(BookDTO bookDTO){
        return modelMapper.map(bookDTO,Book.class);
    }

    public List<BookDTO> toDto(List<Book> bookList){
        return bookList.stream().map(this::toDto).toList();
    }
}
