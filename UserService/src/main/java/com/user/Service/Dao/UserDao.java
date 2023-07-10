package com.user.Service.Dao;

import com.user.Service.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,String> {

//    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.ratings")
//    List<User> findAllWithRatings();
}
