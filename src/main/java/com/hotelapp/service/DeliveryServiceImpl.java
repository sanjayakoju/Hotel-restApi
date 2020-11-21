package com.hotelapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotelapp.models.Delivery;
import com.hotelapp.repository.DeliveryRepositroy;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryRepositroy deliveryRepository;
	
	@Override
	public void addDelivery(Delivery delivery) {
		deliveryRepository.save(delivery);
	}

	@Override
	public void deleteDelivery(int deliveryId) {
		deliveryRepository.deleteById(deliveryId);
	}

	@Override
	public Delivery getDeliveryById(int deliveryId) {
		return deliveryRepository.findById(deliveryId).get();
	}

	@Override
	public Delivery getDeliveryByPartnerName(String partnerName) {
		return deliveryRepository.findByPartnerName(partnerName);
	}

}
