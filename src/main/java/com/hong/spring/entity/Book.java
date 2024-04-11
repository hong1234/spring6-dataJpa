
package com.hong.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.Date;

// import java.time.LocalDateTime;

import jakarta.persistence.*;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.Lob;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import jakarta.persistence.Temporal;
// import jakarta.persistence.TemporalType;

// import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@Entity
@Table(name = "books2")
public class Book {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    
    @NotNull
    @Size(min = 3, max = 50, message = "must be minimum 3 characters, and maximum 50 characters long")
    @Column(name = "title", nullable = false, length = 150)
    private String title;

    // @Lob
    @NotNull
    @Size(min = 3, max = 500, message = "must be minimum 3 characters, and maximum 500 characters long")
    @Column(name = "content", nullable = false, columnDefinition="TEXT")
    private String content;

    @Column(name="created_on", columnDefinition = "TIMESTAMP")
    private Date createdOn; // = new Date();

    @Column(name="updated_on", columnDefinition = "TIMESTAMP")
    private Date updatedOn;
    
    // @OneToMany(mappedBy="book", cascade=CascadeType.ALL, fetch = FetchType.EAGER // default fetch = FetchType.LAZY) 
    @OneToMany(mappedBy="book", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
}
