package com.yannitech.bookstore.yannitech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yannitech.bookstore.yannitech.exception.ResourceNotFoundException;
import com.yannitech.bookstore.yannitech.model.Author;
import com.yannitech.bookstore.yannitech.model.Book;
import com.yannitech.bookstore.yannitech.repository.AuthorCustomRepository;
import com.yannitech.bookstore.yannitech.repository.BookCustomRepository;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class AuthorController {
	
	@Autowired
	private BookCustomRepository bookCustomRepository;
	
	@Autowired
	private AuthorCustomRepository authorCustomRepository;
	
	
	// ***** Add Author *****
	@PutMapping("/book")
    public void updateAuthor(@RequestBody Author author) throws ResourceNotFoundException {

		long bookId = author.getId();
    	Book book = bookCustomRepository.findBookById(bookId);
    	    	
    	author.setAuthor(author.getAuthor());
    	author.setBook(book);
    	
		authorCustomRepository.updateAuthor(author);

    }
	
	
	// ***** List Authors By BookID*****
    @GetMapping("/book/{id}/authors")
    public List <Author> getAuthorByBookId(@PathVariable(value = "id") Long id) {
    	return authorCustomRepository.findAuthorsByBookId(id);
    }
    
    // ***** Remove Author *****
    @DeleteMapping("/book/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long authorId) throws ResourceNotFoundException {
        Author author = authorCustomRepository.findAuthorById(authorId);
        authorCustomRepository.removeAuthor(author);
       
    }
    
    
    
}
