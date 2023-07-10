package com.lcwd.hotel.Service.Impl;

import com.lcwd.hotel.Entity.Hotel;
import com.lcwd.hotel.Exception.ResourceNotFoundException;
import com.lcwd.hotel.Repository.HotelRepo;
import com.lcwd.hotel.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    public HotelRepo hotelrepo;


    @Override
    public Hotel create(Hotel hotel) {
        String uuid = UUID.randomUUID().toString();
        hotel.setHotelid(uuid);
        return hotelrepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelrepo.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel is not listed with this id"));
    }
}
