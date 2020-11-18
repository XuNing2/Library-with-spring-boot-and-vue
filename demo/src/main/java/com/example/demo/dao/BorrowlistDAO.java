package com.example.demo.dao;

import java.util.List;

import com.example.demo.pojo.Borrowlist;
import com.example.demo.pojo.BorrowlistPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BorrowlistDAO extends JpaRepository<Borrowlist, BorrowlistPK>{
    public List<Borrowlist> findByUser(int userid);
    public List<Borrowlist> findByBook(int bookid);
    public List<Borrowlist> findByUserAndHavereturn(int userid, boolean havereturn);
    public List<Borrowlist> findByBookAndHavereturn(int bookid, boolean havereturn);
    public List<Borrowlist> findByUserAndBook(int userid, int bookid);
    @Transactional
    public void deleteByUser(int userid);
    @Transactional
    public void deleteByBook(int bookid);
}