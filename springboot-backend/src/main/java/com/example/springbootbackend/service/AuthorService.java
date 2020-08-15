package com.example.springbootbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootbackend.model.Author;
import com.example.springbootbackend.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}

	public void deleteAuthor(Author author) {
		authorRepository.delete(author);

	}

	public Author saveAuhtor(Author author, Long id) {
		return authorRepository.save(author);
	}

	public Integer updateAuthors(String lastName, Long id) {
		return authorRepository.save(lastName, id);

	}

}