package com.hotelapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelapp.exception.HotelNotFoundException;
import com.hotelapp.exception.IdNotFoundException;
import com.hotelapp.models.Hotel;
import com.hotelapp.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public void updateHotel(Hotel hotel) {
		hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotelById(int id) {
		return hotelRepository.findById(id)
				.orElseThrow(()->new IdNotFoundException("Id not found !!!"));
	}

	@Override
	public void deleteHotel(int id) {
		hotelRepository.deleteById(id);
	}

	@Override
	public List<Hotel> getHotelByCity(String city) {
		List<Hotel> hotels= hotelRepository.findByAddressCity(city);
//		if(hotels.isEmpty())
//		{
//			throw new HotelNotFoundException("Hotel with city not found !!!");
//		}
		return hotels;
	}

	@Override
	public List<Hotel> getHotelByMenu(String menuName)  {
		List<Hotel> hotels = hotelRepository.findHotelsByMenu(menuName);
		if(hotels.isEmpty())
		{
			throw new HotelNotFoundException("Hotel with menu not found !");
		}
		return hotels;

	}

	@Override
	public List<Hotel> getHotelByDelivery(String partnerName) {
		List<Hotel> hotels = hotelRepository.findHotelsByDelivery(partnerName);
		if(hotels.isEmpty())
		{
			throw new HotelNotFoundException("Hotel with partner not found !");
		}
		return hotels;

	}

	@Override
	public List<Hotel> getHotelByLocation(String location) {
		List<Hotel> hotels = hotelRepository.findByAddressStreetName(location);
		if(hotels.isEmpty())
		{
			throw new HotelNotFoundException("Hotel with location not found");
		}
		return hotels;

	}

	@Override
	public List<Hotel> getHotelByLocationAndMenu(String location, String menuName) {
		List<Hotel> hotels = hotelRepository.getHotelsByLocationAndMenu(location, menuName);
		if(hotels.isEmpty())
		{
			throw new HotelNotFoundException("Hotel with location and menu not found");
		}
		return hotels;

	}

}
