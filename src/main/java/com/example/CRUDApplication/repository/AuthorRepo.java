package com.example.CRUDApplication.repository;

import com.example.CRUDApplication.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> , JpaSpecificationExecutor<Author> {
   Optional<Author> findFirstByName(String name);



//   List<Author> findByName(String name);
//   List<Author> findByDescriptionContains(String desc);
//
//   @Query(value = "select * from authors where description like %:desc%" , nativeQuery = true)
//   List<Author> getAllWhereDescriptionLike(String desc);


   @Query(value = "select * from authors where name=:name and description like %:desc%",nativeQuery = true)
   List<Author> getAuthorsByNameAndDescriptionLike(String name, String desc);



}
