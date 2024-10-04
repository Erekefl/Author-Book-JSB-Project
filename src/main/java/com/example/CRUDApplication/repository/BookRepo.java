package com.example.CRUDApplication.repository;

import com.example.CRUDApplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepo extends JpaRepository<Book,Integer>, JpaSpecificationExecutor<Book> {
    Optional<Book> findFirstByName(String name);

    @Query(value = "select * from books where title like %:title%",nativeQuery = true)
    List<Book> findByTitle(String title);
    List<Book> findByName(String name);


    @Query(value = "select * from books where title=:tit and description like %:desc%",nativeQuery = true)
    List<Book> getByTitleAndDescriptionLike(@Param("tit") String title,@Param("desc") String description);

    @Query(value = "select * from books where description like %:desc%",nativeQuery = true)
    List<Book> getAllWhereDescriptionLike(String desc);
}
