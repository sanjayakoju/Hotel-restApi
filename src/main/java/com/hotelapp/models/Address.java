package com.hotelapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(generator = "address_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "address_id",sequenceName = "address_id")
	private Integer addressId;
	private String streetName;
	private String city;
	private long zipCode;
	private String state;
	public Address(String streetName, String city, long zipCode, String state) {
		super();
		this.streetName = streetName;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", city=" + city + ", zipCode=" + zipCode + ", state=" + state
				+ "]";
	}
	
	
	
	
	

}
