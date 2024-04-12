package com.hong.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;
//import java.util.Optional;

import com.hong.spring.entity.Book;
import com.hong.spring.entity.Review;
import com.hong.spring.entity.LikeStatus;

import com.hong.spring.repo.BookRepository;
import com.hong.spring.repo.ReviewRepository;

import com.hong.spring.exceptions.ErrorDetails;
import com.hong.spring.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final ReviewRepository reviewRepository;

    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Integer bookId){ //throws Exception
        return bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book with Id="+bookId+" not found"));
    }

    public Iterable<Book> searchBooksByTitle(String title){
        return bookRepository.searchByTitle(title);
    }

    public List<Review> getBookReviews(Integer bookId){
        return reviewRepository.getReviewsOfBook(bookId);
    }

    public Book storeBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Integer bookId, Book book){
        Book storedBook = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book with Id="+bookId+" not found"));
        storedBook.setTitle(book.getTitle());
        storedBook.setContent(book.getContent());
        storedBook.setUpdatedOn(new Date());
        return bookRepository.save(storedBook);
    }

    public Review addReviewToBook(Integer bookId, Review review){
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book with Id="+bookId+" not found"));
        review.setBook(book);
        // book.getReviews().add(review);
        return reviewRepository.save(review);
    }

    // public ErrorDetails deleteBook(Integer bookId){
    //     Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book with Id="+bookId+" not found"));
    //     bookRepository.deleteById(bookId);
    //     ErrorDetails errorDetails = new ErrorDetails();
    //     // errorDetails.setStatus(HttpStatus.OK);
    //     errorDetails.setMessage("Book Id="+bookId+" deleted");
    //     return errorDetails;
    // }

    // public ErrorDetails deleteReview(Integer reviewId){
    //     Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ResourceNotFoundException("Review with Id="+reviewId+" not found"));
    //     reviewRepository.deleteById(reviewId);
    //     ErrorDetails errorDetails = new ErrorDetails();
    //     // errorDetails.setStatus(HttpStatus.OK);
    //     errorDetails.setMessage("Review Id="+reviewId+"  deleted");
    //     return errorDetails;
    // }

    public void test() {

		// Save a new book
		Book book = new Book();
		book.setTitle("Spring in Action");
		book.setContent("news in Spring 6");
		book.setCreatedOn(new Date());
		storeBook(book);

        Review review = new Review();
        review.setName("hongle1");
        review.setEmail("hongle1@yahoo.de");
        review.setContent("GOOD bla bla");
        review.setLikeStatus(LikeStatus.Medium);
        review.setCreatedOn(new Date());
        addReviewToBook(1, review);
		
		// Find a customer by ID
		// Optional<Customer> result = repository.findById(1L);
		// result.ifPresent(customer -> System.out.println(customer));
		
		// Find customers by last name
		// List<Customer> customers = repository.findByLastName("Smith");
		// customers.forEach(customer -> System.out.println(customer));
		
		// List all customers
		// Iterable<Customer> iterator = repository.findAll();
		// iterator.forEach(customer -> System.out.println(customer));

		// List<Customer> iterator = repository2.getAll();
		// iterator.forEach(customer -> System.out.println(customer));
		
		// Count number of customer
		// long count = repository.count();
		// System.out.println("Number of customers: " + count);

	}

}
