package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vishalmart")
public class VishalMart 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long martId;
	
	private String martName;
	
	private String managerName;
	
	private String address;
	
	private String city;
	
	private String state;

	public VishalMart(String martName, String managerName, String address, String city, String state) {
		super();
		this.martName = martName;
		this.managerName = managerName;
		this.address = address;
		this.city = city;
		this.state = state;
	}
	//this code is formated
	
	

}
