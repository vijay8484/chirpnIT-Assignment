package com.example.springbootbackend.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springbootbackend.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	Optional<Author> findById(Long authorId);

}