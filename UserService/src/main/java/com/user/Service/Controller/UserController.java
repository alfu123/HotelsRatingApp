package com.user.Service.Controller;

import com.user.Service.Entites.User;
import com.user.Service.Service.Impl.UserServiceImpl;
import com.user.Service.Service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @PostMapping
    public ResponseEntity<User> CreateUser(@RequestBody User user){
        User user1=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }



    @GetMapping("/{userId}")
    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> GetSingleUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //fallback method for circuitbreaker
    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
        logger.info("Fallback is executed because service is down",ex.getMessage());
        User user=User.builder()
                .email("dummy@gmail.com")
                .name("dummy")
                .about("User is dummy bcz some services are down")
                .userId("14235").build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "allratingHotelFallback")
    @RateLimiter(name="userRateLimiter",fallbackMethod = "allratingHotelFallback")
    public ResponseEntity<List<User>> GetAllUser(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }


    //fallback method for circuitbreaker
    public ResponseEntity<List<User>> allratingHotelFallback(Exception ex){
        logger.info("Fallback is executed because service is down",ex.getMessage());
        List<User> users=new ArrayList<>();
        User user=User.builder()
                .email("dummy@gmail.com")
                .name("dummy")
                .about("User is dummy bcz some services are down")
                .userId("14235").build();
        users.add(user);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

}
