package com.example.CRUDApplication.entity.specifications;

import com.example.CRUDApplication.entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {
    public static Specification<Book>  titleLike(String title){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"),title);
    }

    public static Specification<Book> descriptionLike(String description){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("description"),description);
    }
}
