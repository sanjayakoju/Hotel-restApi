package com.hotelapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotelapp.models.Address;
import com.hotelapp.models.Delivery;
import com.hotelapp.models.Hotel;
import com.hotelapp.models.Menu;
import com.hotelapp.service.HotelService;

@SpringBootApplication
public class HotelRestApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HotelRestApiApplication.class, args);
	}

	
	@Autowired
	HotelService hotelService;
	
	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("ABC nagar", "Banglore",567890,"KAR");
		Menu menu1 = new Menu("Paratha",20);
		Menu menu2 = new Menu("Pizza",120);
		Set<Menu> menuList = new HashSet<>(Arrays.asList(menu1,menu2));
		Delivery delivery1 = new Delivery("swiggy",120);
		Delivery delivery2 = new Delivery("ubber",130);
		Set<Delivery> deliveryList = new HashSet<>(Arrays.asList(delivery1,delivery2));
		Hotel hotel = new Hotel("A2B",address,menuList,deliveryList);
		hotelService.addHotel(hotel);
	}

}
