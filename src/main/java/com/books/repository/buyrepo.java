package com.books.repository;

import com.books.model.Buy;
import com.books.model.Coupons;
import com.books.model.Output;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface buyrepo extends JpaRepository<Buy, String>{
    @Query(value = "SELECT * FROM buy where buy.username=:user", nativeQuery=true)
    Buy findbuyer(@Param("user") String username);
}