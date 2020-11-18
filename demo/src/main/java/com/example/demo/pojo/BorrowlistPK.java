package com.example.demo.pojo;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BorrowlistPK implements Serializable{

    private int book;
    private int user;
    private String date;

    BorrowlistPK(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BorrowlistPK)) return false;

        BorrowlistPK borrowlistPK = (BorrowlistPK) o;

        if (book != (borrowlistPK.getBook())) return false;
        if (user != (borrowlistPK.getUser())) return false;
        return date != null? date.equals(borrowlistPK.date):borrowlistPK.date == null; 
    }

    @Override
    public int hashCode() {
        int result = book;
        result = 31 * result + user;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    
    @Override
    public String toString() {
        return "PeopleKey [book=" + book + ", user=" + user + ", date=" + date + "]";
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