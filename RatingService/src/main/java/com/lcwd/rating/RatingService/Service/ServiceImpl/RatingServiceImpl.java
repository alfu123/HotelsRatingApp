package com.lcwd.rating.RatingService.Service.ServiceImpl;


import com.lcwd.rating.RatingService.Entitiy.Rating;
import com.lcwd.rating.RatingService.Exception.ResourceNotFoundException;
import com.lcwd.rating.RatingService.Repositiory.RatingRepo;
import com.lcwd.rating.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    public RatingRepo ratingRepo;


    @Override
    public Rating create(Rating rating) {
        String uuid = UUID.randomUUID().toString();
        rating.setRatingId(uuid);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getAllByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
