package com.yannitech.bookstore.yannitech.controller;

import com.yannitech.bookstore.yannitech.exception.ResourceNotFoundException;
import com.yannitech.bookstore.yannitech.model.Author;
import com.yannitech.bookstore.yannitech.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class AuthorController {
	
	private final AuthorService authorService;
//
//	@Autowired
//	private AuthorCustomRepository authorCustomRepository;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}


	// ***** Add Author *****
	@PutMapping("/book")
    public void updateAuthor(@RequestBody Author author) throws ResourceNotFoundException {
		authorService.updateAuthor(author);
    }
	
	
	// ***** List Authors By BookID*****
    @GetMapping("/book/{id}/authors")
    public List <Author> getAuthorByBookId(@PathVariable(value = "id") Long id) {
    	return authorService.findAllByBook_Id(id);
    }
    
    
    // ***** Remove Author *****
    
}
