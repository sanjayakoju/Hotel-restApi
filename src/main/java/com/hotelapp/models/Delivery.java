package com.hotelapp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Delivery {
	
	@Id
	@GeneratedValue(generator = "delivery_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "delivery_id",sequenceName = "delivery_id")
	private Integer deliveryId;
	private String partnerName;
	private double charges;
	
	//the mappedBy value should be exact same as the value set for delivery in hotel model
	@ManyToMany(mappedBy = "delivery")
	private Set<Hotel> hotelList = new HashSet<>();
	
	public Delivery() {}
	
	
	public Delivery(String partnerName, double charges) {
		super();
		this.partnerName = partnerName;
		this.charges = charges;
	}



	@Override
	public String toString() {
		return "Delivery [partnerName=" + partnerName + ", charges=" + charges + "]";
	}
	
	

}
