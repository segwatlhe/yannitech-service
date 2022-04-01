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
    @Query("update Author a set a.author =?1 where a.id=?2")
    void updateAuthor(String author, Long id);
}
