package com.example.springbootbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootbackend.model.Author;
import com.example.springbootbackend.model.Book;
import com.example.springbootbackend.service.AuthorService;
import com.example.springbootbackend.service.BookService;

@RestController
public class AuthorBookController {

	@Autowired
	AuthorService authorService;

	@Autowired
	BookService bookService;

	// Author Api
	@GetMapping(value = "/getAllAuthors")
	public List<Author> getAuthors() {
		return authorService.getAuthors();
	}

	@PutMapping("/authors/{id}")
	public ResponseEntity<?> saveAuthor(@RequestBody Author author, @PathVariable("id") Long id) {
		Author newAuthor = authorService.saveAuhtor(author, id);
		return new ResponseEntity<>(newAuthor, HttpStatus.OK);
	}

	@PatchMapping("/authors/{id}")
	public Integer updateAuthor(@RequestParam("lastName") String lastName, @PathVariable("id") Long id) {
		return authorService.updateAuthors(lastName, id);

	}

	@PostMapping(value = "/createAuthor", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Author createAuthor(@RequestBody Author author) {
		return authorService.createAuthor(author);
	}

	@PostMapping(value = "/deleteAuthor", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAuthor(@RequestBody Author author) {
		authorService.deleteAuthor(author);
	}

	// Book Api
	@GetMapping(value = "/getAllBooks")
	public List<Book> getBooks() {
		return bookService.getAllBooks();
	}

	@PostMapping(value = "/{authorId}/book", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book createBook(@PathVariable(value = "authorId") Long authorId, @RequestBody Book book) {
		return bookService.createBook(authorId, book);
	}

	@GetMapping(value = "/book/{bookId}")
	public Optional<Book> getBookById(@PathVariable(value = "bookId") Long bookId) {
		return bookService.getBookById(bookId);
	}

	@PostMapping(value = "/deleteBookById", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAuthor(@PathVariable(value = "bookId") Long bookId) {
		bookService.deleteBookById(bookId);

	}

}