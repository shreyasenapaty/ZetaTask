package com.books.service;

import com.books.model.Coupons;
import com.books.model.Output;
import com.books.model.User;

public interface BooksCoup {
    public Output add(User user, Coupons coups);
    public Output TransferCoupon(Output user, Output newuser);
}
