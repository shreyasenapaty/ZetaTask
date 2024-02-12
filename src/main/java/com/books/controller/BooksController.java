package com.books.controller;

import com.books.model.Books;
import com.books.model.Coupons;
import com.books.model.User;
import com.books.repository.Oprepo;
import com.books.service.BooksCoup;
import com.books.service.Mybooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class  BooksController {
    @Autowired
    Mybooks books;
    @Autowired
    BooksCoup booksCoup;
    @Autowired
    Oprepo rep;

    @RequestMapping(value= "/books", method= RequestMethod.GET)
    public Object getbook (@RequestBody Books newbook, User newuser){
        return books.getBooks();

    }

    @RequestMapping(value= "/coupon/add", method= RequestMethod.POST)
    public Object addcoupon (@RequestBody Coupons newcoupon, User newuser) {
        if (newuser.getUsername()=="admin") {
            System.out.println(this.getClass().getSimpleName() + " - Creating new coupon.");
            booksCoup.add(newuser,newcoupon);
            return books.addCoupons(newuser, newcoupon);
        }
        else {
            return ("Only admins can add coupons");
        }
    }

    @RequestMapping(value= "/book/add", method= RequestMethod.POST)
    public Object addbook (@RequestBody Books newbook, User newuser) {
        if (newuser.getUsername()=="admin") {
            System.out.println(this.getClass().getSimpleName() + " - Adding new book.");
            return books.addBooks(newuser, newbook);
        }
        else {
            return ("Only admins can add books");
        }
    }

    @RequestMapping(value= "/user/add", method= RequestMethod.POST)
    public Object adduser (@RequestBody User newuser) {
        return books.addUser(newuser);
    }

    @RequestMapping(value= "/transfer", method= RequestMethod.POST)
    public Object transfer (@RequestBody String user, String newuser, int couponno) {
        com.books.model.Output op=rep.findUser(newuser);
        com.books.model.Output op1=rep.findUserCoup(user, couponno);
        if (op1==null){
            return ("User does not have this coupon");
        }
        else{
            return booksCoup.TransferCoupon(op,op1);
        }
    }

}
