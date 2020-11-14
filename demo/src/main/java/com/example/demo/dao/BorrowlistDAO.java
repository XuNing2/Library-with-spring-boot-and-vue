package com.example.demo.dao;

import com.example.demo.pojo.Borrowlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowlistDAO extends JpaRepository<Borrowlist, Integer>{
    //通过bookid查询，即查询书的借阅历史
    List<Borrowlist> findByB_id(int b_id);

    //通过userid查询，即查询个人借阅历史
    List<Borrowlist> findByU_id(int u_id);

    //通过bookid删除书
    void deleteByB_id(int b_id);

    //通过userid删除书
    void deleteByU_id(int u_id);

    //通过userid和havereturn查询用户还了和没还的书
    List<Borrowlist> findByU_idAndHavereturn(int u_id, boolean havereturn);

    //通过bookid和havereturn查询书籍是否可借
    Borrowlist findByB_idAndHavereturn(int b_id, boolean havereturn);

    //通过userid和bookid查询用户是否借了特定的书B_id
    Borrowlist findByU_idAndB_id(int u_id, int b_id);
}