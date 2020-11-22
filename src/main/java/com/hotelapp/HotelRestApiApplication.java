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
import com.hotelapp.service.DeliveryService;
import com.hotelapp.service.HotelService;
import com.hotelapp.service.MenuService;

@SpringBootApplication
public class HotelRestApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HotelRestApiApplication.class, args);
	}

	@Autowired
	HotelService hotelService;

	@Autowired
	DeliveryService deliveryService;
	
	@Autowired
	MenuService menuService;

	@Override
	public void run(String... args) throws Exception {

//		First commit	

//		Address address = new Address("ABC nagar", "Banglore",567890,"KAR");
//		Menu menu1 = new Menu("Paratha",20);
//		Menu menu2 = new Menu("Pizza",120);
//		Set<Menu> menuList = new HashSet<>(Arrays.asList(menu1,menu2));
//		Delivery delivery1 = new Delivery("swiggy",120);
//		Delivery delivery2 = new Delivery("ubber",130);
//		Set<Delivery> deliveryList = new HashSet<>(Arrays.asList(delivery1,delivery2));
//		Hotel hotel = new Hotel("A2B",address,menuList,deliveryList);
//		hotelService.addHotel(hotel);

//		Second Commit

//		Address address = new Address("JP nagar", "Banglore",567890,"KAR");
//		Menu menu1 = new Menu("Cake",20);
//		Menu menu2 = new Menu("Dosa",20);
//		Set<Menu> menuList = new HashSet<>(Arrays.asList(menu1,menu2));
//		Delivery delivery1 = deliveryService.getDeliveryByPartnerName("uber");
//		Set<Delivery> deliveryList = new HashSet<>(Arrays.asList(delivery1));
//		Hotel hotel = new Hotel("The Santhos",address,menuList,deliveryList);
//		hotelService.addHotel(hotel);

//		Hotel hotel = hotelService.getHotelById(1);
//		System.out.println(hotel);
//		hotel.getAddress().setCity("Karwar");
//		hotelService.updateHotel(hotel);
//		Hotel hotel1 = hotelService.getHotelById(1);
//		System.out.println(hotel1);

//		hotelService.getHotelByCity("Banglore")
//			.stream()
//			.forEach(System.out::println);
//		System.out.println();
//		hotelService.getHotelByLocation("JP nagar")
//			.stream()
//			.forEach(System.out::println);

// 		Third commit

//		hotelService.getHotelByCity("Banglore")
//					.stream()
//					.forEach((h)->System.out.println(h.getHotelName()+h.getAddress().getCity()));
//		System.out.println();
//		hotelService.getHotelByLocation("JP nagar")
//					.stream()
//					.forEach((h)->System.out.println(h.getHotelName()+h.getMenuList()));
		
		
//		hotelService.getHotelByMenu("Idli")
//					.stream()
//					.forEach((h)->System.out.println(h.getHotelName()+" "+h.getAddress().getStreetName()));
//		System.out.println();
//		hotelService.getHotelByDelivery("swiggy")
//					.stream()
//					.forEach((h)->System.out.println(h.getHotelName()+" "+h.getAddress().getStreetName()));
		
//		hotelService.getHotelByLocationAndMenu("JP nagar", "Cake")
//					.forEach((h)->System.out.println(h.getHotelName()+" "+h.getAddress().getCity()+""+h.getMenuList()));
		
		menuService.getMenuByHotel("A2B")
					.forEach((m)->System.out.println(m.getMenuName()+" "+m.getPrice()));

	}

}
