package com.books.service;

import com.books.model.*;
import com.books.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class Buyimpl implements BooksCoup, Buying {
    @Autowired
    booksrepo rep;
    @Autowired
    couponsrepo crep;
    @Autowired
    userrepo urep;
    @Autowired
    Oprepo orep;
    @Autowired
    buyrepo brep;

    public Output add(User user, Coupons coups) {
        com.books.model.Output b1=new com.books.model.Output();
        b1.setUsername(user.getUsername());
        b1.setType(user.getType());
        b1.setCoupon_no(coups.getCoupon_no());
        b1.setCost(coups.getCost());
        b1.setExpiry_time(coups.getExpiry_time());
        return orep.save(b1);

    }


    public Output TransferCoupon(Output user, Output newuser) {
        newuser.setCoupon_no(user.getCoupon_no());
        newuser.setCost(user.getCost());
        newuser.setExpiry_time(user.getExpiry_time());
        user.setExpiry_time(null);
        user.setCost(0);
        user.setCoupon_no(0);
        orep.save(user);
        return orep.save(newuser);

    }



    public Buy ToBuy(Output op, Books book) {
        Buy buyer= brep.findbuyer(op.getUsername());
        String newbook= book.getBook_name();
        String exbook=buyer.getBook_name();
        String finalbook=newbook+exbook;
        buyer.setBook_name(finalbook);
        return brep.save(buyer);
    }
}
