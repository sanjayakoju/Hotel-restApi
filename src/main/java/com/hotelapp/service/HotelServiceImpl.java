package com.hotelapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelapp.models.Hotel;
import com.hotelapp.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	@Override
	public void addHotel(Hotel hotel) {
		hotelRepository.save(hotel);
	}

	@Override
	public void updateHotel(Hotel hotel) {
		hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotelById(int id) {
		return hotelRepository.findById(id).get();
	}

	@Override
	public void deleteHotel(int id) {
		hotelRepository.deleteById(id);
	}

	@Override
	public List<Hotel> getHotelByCity(String city) {
		return hotelRepository.findByAddressCity(city);
	}

	@Override
	public List<Hotel> getHotelByMenu(String menuName) {
		return hotelRepository.findHotelsByMenu(menuName);
	}

	@Override
	public List<Hotel> getHotelByDelivery(String partnerName) {
		return hotelRepository.findHotelsByDelivery(partnerName);
	}

	@Override
	public List<Hotel> getHotelByLocation(String location) {
		return hotelRepository.findByAddressStreetName(location);
	}

	@Override
	public List<Hotel> getHotelByLocationAndMenu(String location, String menuName) {
		return hotelRepository.getHotelsByLocationAndMenu(location, menuName);
	}

}
