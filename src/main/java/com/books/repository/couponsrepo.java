package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.books.model.Coupons;
@Repository
public interface couponsrepo extends JpaRepository<Coupons,Integer>, CrudRepository<Coupons, Integer> {
}
