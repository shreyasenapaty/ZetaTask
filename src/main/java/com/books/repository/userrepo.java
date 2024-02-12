package com.books.repository;

import com.books.model.Coupons;
import com.books.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userrepo extends JpaRepository<User,String>, CrudRepository<User,String> {
}