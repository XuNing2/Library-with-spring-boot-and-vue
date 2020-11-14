package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "borrowlist")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Borrowlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_id")
    private Book book;

    @Column(name = "u_id")
    private User user;

    @Column(name = "havereturn")
    private boolean havereturn;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isHavereturn() {
        return havereturn;
    }

    public void setHavereturn(boolean havereturn) {
        this.havereturn = havereturn;
    }

    
}