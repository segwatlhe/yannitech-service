package com.yannitech.bookstore.yannitech.repository;

import com.yannitech.bookstore.yannitech.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {
    Author findById(Long id);

    List<Author> findAllByBook_Id(Long id);

    @Modifying
    @Query("update Author a set a.authorName =?1 where a.book.id=?2")
    void editAuthor(String author, Long id);

    Author findByBook_Id(Long id);
}
