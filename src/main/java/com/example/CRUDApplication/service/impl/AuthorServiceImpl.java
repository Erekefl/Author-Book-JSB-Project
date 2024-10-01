package com.example.CRUDApplication.service.impl;

import com.example.CRUDApplication.dto.AuthorDTO;
import com.example.CRUDApplication.entity.Author;
import com.example.CRUDApplication.mapper.AuthorMapper;
import com.example.CRUDApplication.repository.AuthorRepo;
import com.example.CRUDApplication.service.AuthorService;
import com.example.CRUDApplication.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepo authorRepo;
    private final AuthorMapper authorMapper;


    @Override
    public List<AuthorDTO> getAllAuthors(String name,String description) {
     List<Author> authors = new ArrayList<>();

     if (StringUtil.stringIsNullOrEmpty(name) && StringUtil.stringIsNullOrEmpty(description)){
         authors = authorRepo.findAll();
     }
     if (!StringUtil.stringIsNullOrEmpty(name) && StringUtil.stringIsNullOrEmpty(description)){
         authors = authorRepo.findByName(name);
     }
     if (StringUtil.stringIsNullOrEmpty(name) && !StringUtil.stringIsNullOrEmpty(description)){
         authors = authorRepo.getAllWhereDescriptionLike(description);
     }

     // орындалган тапсырма
     if (!StringUtil.stringIsNullOrEmpty(name) && !StringUtil.stringIsNullOrEmpty(description)){
         authors = authorRepo.getAuthorsByNameAndDescriptionLike(name,description);

     }
         return authorMapper.toDto(authors);
    }



    @Override
    public AuthorDTO getAuthorById(int id) {
       Optional<Author> author = authorRepo.findById(id);
        return author.map(authorMapper::toDto).orElse(null);

    }

    @Override
    public AuthorDTO getAuthorByName(String name) {
        Optional<Author> author = authorRepo.findFirstByName(name);
        return author.map(authorMapper::toDto).orElse(null);

    }

    @Override
    public List<AuthorDTO> getAuthorByNameAndDescriptionLike(String name, String description) {
        var resultEntities = authorRepo.getAuthorsByNameAndDescriptionLike(name,description);
        return authorMapper.toDto(resultEntities);
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author entity = authorMapper.toEntity(authorDTO);
        var resultEntity = authorRepo.save(entity);
        return authorMapper.toDto(resultEntity);

    }

    @Override
    public AuthorDTO updateAuthor(int authorId, AuthorDTO authorDTO) throws NoSuchElementException {
        var existingEntity = authorRepo.findById(authorId);
        if(existingEntity.isPresent()){
            var entity = existingEntity.get();
            entity.setName(authorDTO.getName());
            var resultEntity = authorRepo.save(entity);
            return authorMapper.toDto(resultEntity);
        }else {
            throw new NoSuchElementException("author not found");
        }

    }

    @Override
    public void deleteAuthor(int authorId) throws NoSuchElementException{
        var existingEntity = authorRepo.findById(authorId);
        if(existingEntity.isPresent()){
            authorRepo.delete(existingEntity.get());
        }else {
            throw new NoSuchElementException("author not found");

        }
    }
}
