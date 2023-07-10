package com.lcwd.hotel;

import com.lcwd.hotel.Entity.Hotel;
import com.lcwd.hotel.Repository.HotelRepo;
import com.lcwd.hotel.Service.HotelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class HotelServiceApplicationTests {

	@Autowired
	private HotelService hotelService;
	@MockBean
	private HotelRepo hotelRepo;

	@Test
	public void getHotelTest(){
		when(hotelRepo.findAll()).thenReturn(Stream.of(new Hotel("4","Balian","Ballia", "good")).collect(Collectors.toList()));
//		assertEquals(1,hotelService.getAllHotel().size());

	}

}
