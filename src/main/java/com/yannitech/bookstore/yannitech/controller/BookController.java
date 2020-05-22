package com.yannitech.bookstore.yannitech.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yannitech.bookstore.yannitech.exception.ResourceNotFoundException;
import com.yannitech.bookstore.yannitech.model.Book;
import com.yannitech.bookstore.yannitech.repository.BookCustomRepository;
import com.yannitech.bookstore.yannitech.repository.BookSearchRepository;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookCustomRepository bookRepository;
	
	@Autowired
	private BookSearchRepository bookSearchRepository;
	
	
	@RequestMapping("/hello")
	public @ResponseBody String greeting() {
		return "Hello, World";
	}
	
	// ***** List Book *****
    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
    
    
    // ***** Save Book *****
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.saveBook(book);
    }
    

    // ***** Find Book By ID *****
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        return ResponseEntity.ok().body(bookRepository.findById(id));
    }
    
    
    // ***** Edit Book *****
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId, @Validated @RequestBody Book bookDetails) throws ResourceNotFoundException {
        
    	Book book = bookRepository.findById(bookId);
    	
        book.setCategory(bookDetails.getCategory());
        book.setTitle(bookDetails.getTitle());
        book.setPrice(bookDetails.getPrice());
        book.setYear(bookDetails.getYear());
        
        final Book updatedEmployee = bookRepository.updateBook(book);
        return ResponseEntity.ok(updatedEmployee);
    }
    
    
    // ***** Delete Book *****
    @DeleteMapping("/books/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long bookId) throws ResourceNotFoundException {
        
    	Book book = bookRepository.findById(bookId);
    	
        bookRepository.delete(book);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    
    // ***** Search for a book *****
    @GetMapping("/findbook")
    public ResponseEntity<List<Book>> getAllTutorials(@RequestParam(required = false) String title) {
      try {
    	  System.out.println(title);
        List<Book> books = new ArrayList<Book>();

        if (title == null)
        	bookSearchRepository.findAll().forEach(books::add);
        else
        	bookSearchRepository.findByTitleContaining(title).forEach(books::add);

        if (books.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
    
}
