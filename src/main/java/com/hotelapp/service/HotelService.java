package com.hotelapp.service;

import java.util.List;

import com.hotelapp.exception.HotelNotFoundException;
import com.hotelapp.exception.IdNotFoundException;
import com.hotelapp.models.Hotel;

public interface HotelService {
	
	Hotel addHotel(Hotel hotel);
	void updateHotel(Hotel hotel);
	Hotel getHotelById(int id) throws IdNotFoundException;
	void deleteHotel(int id) throws IdNotFoundException;
	
	List<Hotel> getHotelByCity(String city);
	List<Hotel> getHotelByMenu(String menuName) throws HotelNotFoundException;
	List<Hotel> getHotelByDelivery(String partnerName) throws HotelNotFoundException;
	List<Hotel> getHotelByLocation(String location) throws HotelNotFoundException;
	List<Hotel> getHotelByLocationAndMenu(String location, String menuName) throws HotelNotFoundException;

}
