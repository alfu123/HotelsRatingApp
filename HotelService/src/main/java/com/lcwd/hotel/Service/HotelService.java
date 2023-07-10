package com.lcwd.hotel.Service;

import com.lcwd.hotel.Entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create (Hotel hotel);

    List<Hotel> getAllHotel();

    Hotel getHotel(String id);

}
