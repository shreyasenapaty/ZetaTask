package com.books.service;

import com.books.model.Books;
import com.books.model.Buy;
import com.books.model.Output;



public interface Buying {
    public Buy ToBuy(Output op, Books book);
}
