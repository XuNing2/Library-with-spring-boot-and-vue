package com.example.demo.service;

import com.example.demo.dao.BorrowlistDAO;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.Borrowlist;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BorrowlistService {
    @Autowired
    BorrowlistDAO borrowlistDAO;

    public List<Borrowlist> getAll() {
        List<Borrowlist> all = borrowlistDAO.findAll();
        return all;
    }

    public List<Borrowlist> getByU_id(int u_id) {
        return borrowlistDAO.findByU_id(u_id);
    }

    public List<Borrowlist> getByB_id(int b_id) {
        return borrowlistDAO.findByB_id(b_id);
    }

    public Borrowlist getCertainone(int u_id, int b_id) {
        return borrowlistDAO.findByU_idAndB_id(u_id, b_id);
    }

    public void add(Borrowlist borrowlist) {
        Borrowlist borrow = getCertainone(borrowlist.getUser().getId(), borrowlist.getBook().getId());
        if(borrow == null)
            borrowlistDAO.save(borrowlist);
        else
            System.out.print("已经存在该借书记录了");
    }

    public void update(Borrowlist borrowlist) {
        borrowlistDAO.save(borrowlist);
    }

    public void deleteByUser(User user) {
        borrowlistDAO.deleteByU_id(user.getId());
    }

    public void deleteByBook(Book book) {
        borrowlistDAO.deleteByB_id(book.getId());
    }

    public List<Borrowlist> gethavereturn(int u_id, boolean havereturn) {
        return borrowlistDAO.findByU_idAndHavereturn(u_id, havereturn);
    }

    public boolean canBorrow(int b_id) {
        Borrowlist borrowlist = borrowlistDAO.findByB_idAndHavereturn(b_id, true);
        return null != borrowlist;
    }
    
}