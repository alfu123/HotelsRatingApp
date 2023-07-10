package com.lcwd.rating.RatingService.Service;

import com.lcwd.rating.RatingService.Entitiy.Rating;

import java.util.List;

public interface RatingService {

    Rating create (Rating rating);
    List<Rating> getAll();
    List<Rating> getAllByUserId(String userId);
    List<Rating> getAllByHotelId(String hotelId);


}
