package com.sayan.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sm_authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String authorName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sm_author_book",joinColumns = {@JoinColumn(name = "author_id")},
    inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Set<Book> books;
    public Author(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
