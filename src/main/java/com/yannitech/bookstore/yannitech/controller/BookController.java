package com.yannitech.bookstore.yannitech.controller;

import com.yannitech.bookstore.yannitech.exception.ResourceNotFoundException;
import com.yannitech.bookstore.yannitech.model.Book;
import com.yannitech.bookstore.yannitech.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BookController {

	private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }
    
    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
    
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }
    
    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable(value = "id") Long id, @Validated @RequestBody Book book) throws ResourceNotFoundException {
    	bookService.updateBook(book, id);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable(value = "id") Long bookId) {
    	bookService.deleteById(bookId);
    }
    
    // ***** Search for a book *****
    
}
