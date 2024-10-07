package com.example.CRUDApplication.entity.specifications;

import com.example.CRUDApplication.entity.Author;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {
    public static Specification<Author> nameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), name);
    }

    public static Specification<Author> descriptionLike(String description) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("description"), description);
    }
}
