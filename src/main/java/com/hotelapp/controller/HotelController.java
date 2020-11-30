package com.hotelapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelapp.models.Hotel;
import com.hotelapp.service.HotelService;

@RestController
@RequestMapping("/hotel-restapi")
public class HotelController {
	
	@Autowired
	HotelService hotelService;

	@PostMapping("/hotel/add")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel)
	{
		Hotel newHotel = hotelService.addHotel(hotel);
		HttpHeaders header = new HttpHeaders();
		header.add("description", "One hotel addded");
		return ResponseEntity.ok().headers(header).body(newHotel);
	}
	
	@PutMapping("/hotel/update")
	public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel) 
	{
		hotelService.updateHotel(hotel);
		//both return same response
		//return ResponseEntity.ok().body("Hotel updated");
		return ResponseEntity.ok("Hotel Updated");
	}
	
	@GetMapping("/hotel/getById/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable int id)
	{
		Hotel newHotel = hotelService.getHotelById(id);
		HttpHeaders header = new HttpHeaders();
		header.add("description", "getting one hotel instance ");
		return ResponseEntity.ok().headers(header).body(newHotel);
	}
	
	@DeleteMapping("/hotel/deleteById/{id}")
	public ResponseEntity<Void> deleteHotel(@PathVariable int id)
	{
		hotelService.deleteHotel(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/hotel/getByCityName/{cityName}")
	public ResponseEntity<List<Hotel>> getHotelByCity(@PathVariable("cityName") String city)
	{
		List<Hotel> hotelList = hotelService.getHotelByCity(city);
		return ResponseEntity.ok().body(hotelList);
	}
	
	@GetMapping("hotel/getByMenuName/{menuName}")
	public ResponseEntity<List<Hotel>> getHotelByMenu(@PathVariable String menuName)
	{
		List<Hotel> listHotel = hotelService.getHotelByMenu(menuName);
		return ResponseEntity.ok().body(listHotel);
	}
	
	@GetMapping("hotel/getByPartnerName/{partnerName}")
	public ResponseEntity<List<Hotel>> getHotelByDelivery(@PathVariable String partnerName)
	{
		List<Hotel> listHotel = hotelService.getHotelByDelivery(partnerName);
		return ResponseEntity.ok().body(listHotel);
	}
	
	@GetMapping("hotel/getByLocationName/{locationName}")
	public ResponseEntity<List<Hotel>> getHotelByLocation(@PathVariable("locationName") String location)
	{
		List<Hotel> listHotel = hotelService.getHotelByLocation(location);
		return ResponseEntity.ok().body(listHotel);
	}
	
	@GetMapping("hotel/getByLocationNameAndMenuName/{locationName}/{menuName}")
	public ResponseEntity<List<Hotel>> getHotelByLocationAndMenu(@PathVariable("locationName") String location,@PathVariable String menuName)
	{
		List<Hotel> listHotel = hotelService.getHotelByLocationAndMenu(location, menuName);
		return ResponseEntity.ok().body(listHotel);
	}
}
