package com.hotelapp.service;

import com.hotelapp.models.Delivery;

public interface DeliveryService {
	
	void addDelivery(Delivery delivery);
	void deleteDelivery(int deliveryId);
	Delivery getDeliveryById(int deliveryId);
	Delivery getDeliveryByPartnerName(String partnerName);

}
