package com.example.springbootbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootbackend.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	//Boolean existsById(Long bookId);

	Optional<Book> findById(Long bookId);

}