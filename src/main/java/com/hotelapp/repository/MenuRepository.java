package com.hotelapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapp.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
	
//	Derived Queries
//	List<Menu> findByHotelHotelName(String hotelName);
	
//	@Query with JPQL
//	@Query("FROM Menu m INNER JOIN m.hotel h WHERE h.hotelName = ?1")
//	List<Menu> findByHotelName(String hotelName);
	
//	@Query with native SQL
	@Query(value = "SELECT * FROM menu m INNER JOIN hotel h ON m.hotel_id = h.hotel_id WHERE h.hotel_name = ?1",nativeQuery = true)
	List<Menu> getMenusByHotel(String hotelName);

}
