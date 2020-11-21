package com.hotelapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelapp.models.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	//Derived Queries
	List<Hotel> findByAddressCity(String city);
	List<Hotel> findByAddressStreetName(String location);
	
}
