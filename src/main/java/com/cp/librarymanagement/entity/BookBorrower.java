package com.cp.librarymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book_borrower")
public class BookBorrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 80)
    private String name;
    @Column(nullable = false, length = 15)
    private String phone;
    @Column(nullable = true, length = 50)
    private String email;

    @ManyToMany
    @JoinTable(name = "borrow_detail", joinColumns = @JoinColumn(name = "borower_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Collection<Book> book;

}
