package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.BorrowlistDAO;
import com.example.demo.pojo.Borrowlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowlistService {
    @Autowired
    private BorrowlistDAO borrowlistDAO;

    public List<Borrowlist> getAll(){
        return borrowlistDAO.findAll();
    }

    public List<Borrowlist> getByUser(int userid){
        return borrowlistDAO.findByUser(userid);
    }

    public List<Borrowlist> getByBook(int bookid){
        return borrowlistDAO.findByBook(bookid);
    }

    public void deleteByUser(int userid){
        borrowlistDAO.deleteByUser(userid);
    }

    public void deleteByBook(int bookid){
        borrowlistDAO.deleteByBook(bookid);
    }

    public List<Borrowlist> getCertainOne(int userid, int bookid){
        return borrowlistDAO.findByUserAndBook(userid, bookid);
    }

    public List<Borrowlist> gethavereturn(int userid, boolean havereturn){
        return borrowlistDAO.findByUserAndHavereturn(userid, havereturn);
    }

    public boolean canBorrow(int bookid){
        List<Borrowlist> borrowlists = borrowlistDAO.findByBookAndHavereturn(bookid, true);
        return borrowlists == null;
    }

    public void add(int uid, int bid){
        if(canBorrow(bid)){
            Borrowlist borrowlist = new Borrowlist();
            borrowlistDAO.save(borrowlist);
        }
        else{
            System.out.println("该书已经被借阅了！");
        }
    }

    public void update(Borrowlist borrowlist){
        borrowlistDAO.save(borrowlist);
    }
    
}