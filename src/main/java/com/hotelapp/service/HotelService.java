package com.hotelapp.service;

import java.util.List;

import com.hotelapp.models.Hotel;

public interface HotelService {
	
	void addHotel(Hotel hotel);
	void updateHotel(Hotel hotel);
	Hotel getHotelById(int id);
	void deleteHotel(int id);
	
	List<Hotel> getHotelByCity(String city);
	List<Hotel> getHotelByMenu(String menuName);
	List<Hotel> getHotelByDelivery(String partnerName);
	List<Hotel> getHotelByLocation(String location);
	List<Hotel> getHotelByLocationAndMenu(String location, String menuName);

}