package com.example.springbootbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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