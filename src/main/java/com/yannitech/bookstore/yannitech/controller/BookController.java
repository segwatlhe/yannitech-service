package com.yannitech.bookstore.yannitech.controller;

import com.yannitech.bookstore.yannitech.exception.ResourceNotFoundException;
import com.yannitech.bookstore.yannitech.model.Book;
import com.yannitech.bookstore.yannitech.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BookController {

	private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // ***** List Book *****
    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }
    
    
    // ***** Save Book *****
    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
    

    // ***** Find Book By ID *****
    // with ResponseEntity<T> BodyBuilder.body(T body) we can set the HTTP response body
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }
    
    
    // ***** Edit Book *****
    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable(value = "id") Long id, @Validated @RequestBody Book book) throws ResourceNotFoundException {
    	bookService.updateBook(book, id);
    }
    
    
    // ***** Delete Book *****
    @DeleteMapping("/books/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long bookId) throws ResourceNotFoundException {
        
    	Book book = bookService.findById(bookId);

        bookService.delete(book);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted...." + book.getId(), Boolean.TRUE);
        return response;
    }
    
    
    // ***** Search for a book *****
    
}
