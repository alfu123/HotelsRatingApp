package com.user.Service.Service.Impl;


import com.user.Service.Dao.UserDao;

import com.user.Service.Entites.Hotel;
import com.user.Service.Entites.Rating;
import com.user.Service.Entites.User;
import com.user.Service.Exceptions.ResourceNotFoundException;
import com.user.Service.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setUserId(uuid);
        return userDao.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> user=userDao.findAll();
        List<User> allUserRating=new ArrayList<>();
        for (User us:user){
            Rating[] ratingofUser=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+us.getUserId(),Rating[].class);
            List<Rating> ratings=Arrays.stream(ratingofUser).collect(Collectors.toList());
            List<Rating> ratedHotel=ratings.stream().map(rating ->{
                ResponseEntity<Hotel> hotelRating =restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
                Hotel hotel=hotelRating.getBody();
                rating.setHotel(hotel);
                return rating;
            } ).collect(Collectors.toList());
            us.setRatings(ratedHotel);

            allUserRating.add(us);
        }
        return allUserRating;
    }

//    http://localhost:8086/rating/users/19235e9d-39d2-437e-b12e-3a8b2480f241
//    http://localhost:8085/hotels/1a994a7b-238d-481a-880b-12bc7566ca7c
    @Override
    public User getUser(String userId) {
        User user=userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user with given id not found"+userId));
        Rating[] ratingofUser =restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(),Rating[].class);
        List<Rating> ratings=Arrays.stream(ratingofUser).collect(Collectors.toList());
        List<Rating> ratedHotel=ratings.stream().map(rating ->{
            ResponseEntity<Hotel> hotelRating =restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel=hotelRating.getBody();
            rating.setHotel(hotel);
            return rating;
        } ).collect(Collectors.toList());
        logger.info("{}",ratingofUser);
        user.setRatings(ratedHotel);
        return user;
    }
}
