package com.devmanuals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity  
@Table(name = "place_attribute_value")  
public class Attribute implements java.io.Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -2571080151909806822L;

	@ManyToOne  
	 @JoinColumn(name = "PLACEID")  
	 @Id
	 private Place place;
	
	 @Id
	 @Column(name = "ATTRIBUTENAME")
	 private String attributeName;
	 
	 @Column(name = "STRINGVALUE")
	 private String stringValue;
	 
	 @Column(name = "INTVALUE")
	 private String intValue;
	 
	 @Column(name = "DOUBLEVALUE")
	 private String doubleValue;
	 

	public Place getPlace() {
			return place;
		}

		public void setPlace(Place place) {
			this.place = place;
		}

		public String getAttributeName() {
			return attributeName;
		}

		public void setAttributeName(String attributeName) {
			this.attributeName = attributeName;
		}

		public String getStringValue() {
			return stringValue;
		}

		public void setStringValue(String stringValue) {
			this.stringValue = stringValue;
		}

		public String getIntValue() {
			return intValue;
		}

		public void setIntValue(String intValue) {
			this.intValue = intValue;
		}

		public String getDoubleValue() {
			return doubleValue;
		}

		public void setDoubleValue(String doubleValue) {
			this.doubleValue = doubleValue;
		}


	
}
