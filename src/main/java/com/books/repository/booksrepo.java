package com.books.repository;

import com.books.model.Coupons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.books.model.Books;
@Repository
public interface booksrepo extends JpaRepository<Books,Integer> {
}
