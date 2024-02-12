package com.books.service;

import com.books.model.Books;
import com.books.model.Coupons;

import java.util.List;

import com.books.model.User;

public interface Mybooks {

    public List<Books> getBooks();
    public List<Coupons> getCoupons();
    public List<User> getUsers();
    public Books getBookbyNo(int book_no);
    public Coupons getCouponbyNo(int coupon_no);
    public User getUserbyName(String username);
    public Coupons addCoupons(User user, Coupons coups);
    public Books addBooks(User user, Books books);
    public User addUser(User user);

}
