package com.example.springbootbackend.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springbootbackend.model.Author;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author, Long> {

	Optional<Author> findById(Long authorId);

	@Modifying
	@Query("update Author set firstName=?1 where id=?2")
	Integer save(String lastName, Long id);

}