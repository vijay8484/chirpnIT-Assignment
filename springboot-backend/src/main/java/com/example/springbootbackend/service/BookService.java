package com.example.springbootbackend.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Author;
import com.example.springbootbackend.model.Book;
import com.example.springbootbackend.repository.AuthorRepository;
import com.example.springbootbackend.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorRepository authorRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Optional<Book> getBookById(Long bookId) {
		if (!bookRepository.exists(bookId)) {
			throw new ResourceNotFoundException("Book with id " + bookId + " not found");
		}
		return bookRepository.findById(bookId);
	}
	
	public void deleteBookById(Long bookId) {
		if (!bookRepository.exists(bookId)) {
			throw new ResourceNotFoundException("Book with id " + bookId + " not found");
		}
            bookRepository.delete(bookId);
	}

	public Book createBook(Long authorId, Book book) {
		Set<Book> books = new HashSet<>();
		Author author1 = new Author();

		Optional<Author> byId = authorRepository.findById(authorId);
		if (!byId.isPresent()) {
			throw new ResourceNotFoundException("Author with id " + authorId + " does not exist");
		}
		Author author = byId.get();

		// tie Author to Book
		book.setAuthor(author);

		Book book1 = bookRepository.save(book);
		// tie Book to Author
		books.add(book1);
		author1.setBooks(books);

		return book1;

	}

}