package com.books.repository;

import com.books.model.Output;
import com.books.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Oprepo extends JpaRepository<Output, Integer>  {
    @Query(value = "SELECT * FROM output where output.username=:user", nativeQuery = true)
    Output findUser(@Param("user") String username);

    @Query(value = "SELECT * FROM output where output.username=:user output.coupon_no=:couponno", nativeQuery = true)
    Output findUserCoup(@Param("user") String username, @Param("couponno") int coupon_no);
}
