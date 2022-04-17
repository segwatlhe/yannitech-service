package com.yannitech.bookstore.yannitech.repository;

import com.yannitech.bookstore.yannitech.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    Book findById(Long id);

    @Modifying
    @Query("update Book b set b.category =?1, b.price = ?2, b.title = ?3, b.year = ?4 where b.id=?5")
    void editBook(String category, Double price, String title, String year, Long id);
}
