package com.devmanuals.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locality")
public class Locality implements Serializable{

	private static final long serialVersionUID = -12345795672L;
	
	@Id@GeneratedValue
	@Column(name="id")
	long id;
	@Column(name="city")
	String city;
	@Column(name="locality")
	String locality;
	
	
	public Locality(){
		
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	
}
