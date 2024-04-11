package com.hong.spring.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.hong.spring.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
    
    @Query("from Book b where b.title like %?1%")
    List<Book> searchByTitle(String title);

    // @Query("SELECT b FROM Book b JOIN FETCH b.reviews WHERE b.id = :bookId")
    // Book findBookAndReviewsByBookId(@Param("bookId") Int bookId);

    @Query("SELECT b FROM Book b JOIN FETCH b.reviews WHERE b.id = ?1")
    Book findBookAndReviewsByBookId(Integer bookId);
}
