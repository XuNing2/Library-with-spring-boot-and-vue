package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        Borrowlist borrowlist = new Borrowlist(uid, bid, false);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        borrowlist.setDate(df.format(new Date()));
        borrowlistDAO.save(borrowlist);

    }

    public void update(Borrowlist borrowlist){
        borrowlistDAO.save(borrowlist);
    }
    
}