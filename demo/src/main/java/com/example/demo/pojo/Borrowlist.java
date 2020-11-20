package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "borrowlist")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@IdClass(BorrowlistPK.class)
public class Borrowlist implements Comparable<Borrowlist>{

    @Id
    @Column(name = "b_id", nullable = false)
    private int book;

    @Id
    @Column(name = "u_id", nullable = false)
    private int user;

    @Id
    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "havereturn")
    private boolean havereturn;

    public Borrowlist(int uid, int bid, boolean havereturn){
        this.user = uid;
        this.book = bid;
        this.havereturn = havereturn;
    }

    public boolean getHavereturn() {
        return havereturn;
    }

    public void setHavereturn(boolean havereturn) {
        this.havereturn = havereturn;
    }

    @Override
    public int compareTo(Borrowlist o){
        return getDate().compareTo(o.getDate());
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}