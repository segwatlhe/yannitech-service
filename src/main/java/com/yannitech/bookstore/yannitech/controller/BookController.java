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
@RequestMapping("/api/")
public class BookController {

	private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("book/list")
    public List<Book> findAll() {
        return bookService.findAll();
    }
    
    @PostMapping("book/save")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
    
    @GetMapping("book/{id}")
    public ResponseEntity<Book> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }
    
    @PutMapping("book/edit/{id}")
    public void editBook(@PathVariable(value = "id") Long id, @Validated @RequestBody Book book) throws ResourceNotFoundException {
    	bookService.editBook(book, id);
    }

    @DeleteMapping("book/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
    	bookService.deleteById(id);
    }
    
    // ***** Search for a book *****
    
}
