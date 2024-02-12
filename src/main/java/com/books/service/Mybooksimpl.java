package com.books.service;

import com.books.model.Books;
import com.books.model.Coupons;
import com.books.model.User;
import com.books.repository.couponsrepo;
import com.books.repository.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.repository.booksrepo;

import java.util.List;
@Service
public class Mybooksimpl implements Mybooks {
    @Autowired
    booksrepo rep;
    @Autowired
    couponsrepo crep;
    @Autowired
    userrepo urep;


    public List<Books> getBooks() {
        return rep.findAll();
    }

    @Override
    public List<Coupons> getCoupons() {
        return crep.findAll();
    }

    @Override
    public List<User> getUsers() {
        return urep.findAll();
    }

    @Override
    public Books getBookbyNo(int book_no) {
        return rep.getOne(book_no);
    }

    @Override
    public Coupons getCouponbyNo(int coupon_no) {
        return crep.getOne(coupon_no);
    }

    @Override
    public User getUserbyName(String username) {
        return urep.getOne(username);
    }


    public Coupons addCoupons(User user, Coupons coup) {
            return crep.save(coup);

    }

    public Books addBooks(User user, Books books) {
        return rep.save(books);
    }


    public User addUser(User user) {
        return urep.save(user);
    }


}
