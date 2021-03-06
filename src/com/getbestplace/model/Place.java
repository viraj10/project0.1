package com.getbestplace.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.search.annotations.*;

//
//import org.apache.solr.analysis.StandardTokenizerFactory;
//import org.apache.solr.analysis.LowerCaseFilterFactory;
//
//@AnalyzerDef(name = "customanalyzer",
//	tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
//	filters = {
//		@TokenFilterDef(factory = LowerCaseFilterFactory.class),
//		@TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = {
//			@Parameter(name = "language", value = "English")
//	})
//})

@Entity
@Table(name = "placedetails")
@Indexed
public class Place implements java.io.Serializable{
	
	private static final long serialVersionUID = -780784688393144934L;

	public Place(){}
	
	 @Id @GeneratedValue
	 @Column(name = "PLACE_ID")
	 private Long id;
	
	 @Column(name = "OWNERID")
	 private Long ownerId;
	 
	 @Column(name = "NAME")
	 @Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
	 private String name;
	 
	 @Column(name = "ADDRESS")
	 private String address;
	 
	 @Column(name = "LOCALITY")
	 @Field(index=Index.YES,analyze=Analyze.YES,store=Store.YES)
	 private String locality;
	 
	 @Column(name = "CITY")
	 @Field(index=Index.YES,analyze=Analyze.YES,store=Store.YES)
	 private String city;
	 
	 @Column(name = "POSTALCODE")
	 private Long postalCode;
	 
	 @Column(name = "PHONE")
	 private Long phone;

	 @OneToMany(mappedBy = "place")
	 @Cascade(CascadeType.SAVE_UPDATE)
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
	
	public String toString(){
		return this.name+"-"+this.locality;
	}
}

