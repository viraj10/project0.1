package com.devmanuals.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "placedetails")
public class Place implements java.io.Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -780784688393144934L;

	public Place()
	{
		
	}
	
	 @Id @GeneratedValue
	 @Column(name = "PLACE_ID")
	 private Long id;
	
	 @Column(name = "OWNERID")
	 private Long ownerId;
	 
	 @Column(name = "ADDRESS")
	 private String address;
	 
	 @Column(name = "LOCALITY")
	 private String locality;
	 
	 @Column(name = "CITY")
	 private String city;
	 
	 @Column(name = "POSTALCODE")
	 private Long postalCode;

	 @OneToMany(mappedBy = "place")  
	 private Set<Attribute> attributes; 
	 
	 public Set<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<Attribute> attributes) {
		this.attributes = attributes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Long postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
