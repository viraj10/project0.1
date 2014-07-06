package com.devmanuals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table
@Entity(name="highprorityplaces")
public class HighProrityPlaces {
	
	private static final long serialVersionUID = -123457984112L;
	
	@Id@GeneratedValue
	@Column(name="ID")
	long id;
	
	@Column(name="STATUS")
	long status;
	
	
	@OneToOne  
	@JoinColumn(name = "PLACE_ID") 
	Place place;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	

}
