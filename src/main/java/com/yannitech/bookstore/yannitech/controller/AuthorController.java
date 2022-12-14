package com.yannitech.bookstore.yannitech.controller;

import com.yannitech.bookstore.yannitech.model.Author;
import com.yannitech.bookstore.yannitech.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PutMapping("author/add/{id}")
    public void save(@PathVariable Long id, @RequestBody Author author) {
        authorService.save(id, author);
    }

    @GetMapping("author/list/{id}")
    public List<Author> getAuthorByBookId(@PathVariable(value = "id") Long id) {
        return authorService.findAllByBook_Id(id);
    }

    @DeleteMapping("author/remove/{id}")
    public void remove(@PathVariable Long id) {
        authorService.remove(id);
    }

}
