package com.devmanuals.action;


import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devmanuals.model.Attribute;
import com.devmanuals.model.Place;
import com.devmanuals.model.User;
import com.devmanuals.listener.HibernateListener;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PlaceDAO  extends ActionSupport  implements  SessionAware{

	/**
	 * 
	 */
	static final Logger LOGGER = Logger.getLogger(PlaceDAO.class);
	
	Map<String, Object> sessionMap;
	@Override
	 public void setSession(Map session) {
	    this.sessionMap = session;
	  }
	
	private static final long serialVersionUID = 6427837709720937902L;
//	Place placeBean= new Place();
//
//	public Place getPlaceBean() {
//		return placeBean;
//	}
//
//	public void setPlaceBean(Place placeBean) {
//		this.placeBean = placeBean;
//	}
//
//	public Place getModel() {
//		return placeBean;
//	}
	
	
	public String addPlace() throws Exception{
		
		User userObj;
		userObj=(User)this.sessionMap.get("currentUser");
		
		if(userObj==null || userObj.getUserId()<1)
		{
			return "login";
		}
		LOGGER.info("This is a userObj id"+userObj.getUserId());
//		LOGGER.info("This is a long values "+regPlaceMinPrice +" "+regPlaceMaxPrice +" "+regPlacePhone +" "+regPlacePostcode);
//		LOGGER.info("STRING VALUES "+regPlaceName +" "+ regPlaceAddress +" "+ regPlaceLocality+" "+ regPlacecity+" "+regPlaceMap);
//		LOGGER.info("boolean values "+regPlacePower  +" "+ regPlaceMusic +" "+ regPlaceVegetarian);
//		LOGGER.info("boolean values "+regPlaceMarriage+" "+	regPlaceConference+" "+	regPlacepartyHall+" "+	regPlaceHotel+" "+	regPlaceOpenHouse +" "+regPlaceAC);
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		Session session=sessionFactory.openSession();
		
		Place placeBean =new Place();
		placeBean.setAddress(regPlaceAddress);
		placeBean.setCity("pune");
		placeBean.setLocality(regPlaceLocality);
		placeBean.setPostalCode(regPlacePostcode);
		placeBean.setOwnerId(userObj.getUserId());
		
		Attribute attributeMap=new Attribute();
		attributeMap.setAttributeName("map");
		attributeMap.setStringValue(regPlaceMap);
		
		Attribute attributeVeg=new Attribute();
		attributeVeg.setAttributeName("vegetarian");
		attributeVeg.setStringValue(regPlaceVegetarian);
		
		attributeMap.setPlace(placeBean);
		attributeVeg.setPlace(placeBean);
		session.beginTransaction();
		session.save(placeBean);
		session.save(attributeMap);
		session.save(attributeVeg);
		
		session.getTransaction().commit();
//		
		return SUCCESS;
	}
	
	long regPlaceMinPrice ,regPlaceMaxPrice ,regPlacePhone ,regPlacePostcode ;


	int regPlaceCapacity ,regPlaceDinning ,regPlaceArea ,regPlaceWater ,regPlaceParking ,regPlaceRestRooms, regPlaceBathrooms; 
	String regPlaceMarriage,	regPlaceConference,	regPlacepartyHall,	regPlaceHotel,	regPlaceOpenHouse ,regPlaceAC;	
	String regPlacePower ,regPlaceMusic,regPlaceVegetarian;
	String regPlaceName , regPlaceAddress , regPlaceLocality, regPlacecity,regPlaceMap;
	
	public long getRegPlaceMinPrice() {
		return regPlaceMinPrice;
	}

	public void setRegPlaceMinPrice(long regPlaceMinPrice) {
		this.regPlaceMinPrice = regPlaceMinPrice;
	}

	public long getRegPlaceMaxPrice() {
		return regPlaceMaxPrice;
	}

	public void setRegPlaceMaxPrice(long regPlaceMaxPrice) {
		this.regPlaceMaxPrice = regPlaceMaxPrice;
	}

	public long getRegPlacePhone() {
		return regPlacePhone;
	}

	public void setRegPlacePhone(long regPlacePhone) {
		this.regPlacePhone = regPlacePhone;
	}

	public long getRegPlacePostcode() {
		return regPlacePostcode;
	}

	public void setRegPlacePostcode(long regPlacePostcode) {
		this.regPlacePostcode = regPlacePostcode;
	}

	public int getRegPlaceCapacity() {
		return regPlaceCapacity;
	}

	public void setRegPlaceCapacity(int regPlaceCapacity) {
		this.regPlaceCapacity = regPlaceCapacity;
	}

	public int getRegPlaceDinning() {
		return regPlaceDinning;
	}

	public void setRegPlaceDinning(int regPlaceDinning) {
		this.regPlaceDinning = regPlaceDinning;
	}

	public int getRegPlaceArea() {
		return regPlaceArea;
	}

	public void setRegPlaceArea(int regPlaceArea) {
		this.regPlaceArea = regPlaceArea;
	}

	public int getRegPlaceWater() {
		return regPlaceWater;
	}

	public void setRegPlaceWater(int regPlaceWater) {
		this.regPlaceWater = regPlaceWater;
	}

	public int getRegPlaceParking() {
		return regPlaceParking;
	}

	public void setRegPlaceParking(int regPlaceParking) {
		this.regPlaceParking = regPlaceParking;
	}

	public int getRegPlaceRestRooms() {
		return regPlaceRestRooms;
	}

	public void setRegPlaceRestRooms(int regPlaceRestRooms) {
		this.regPlaceRestRooms = regPlaceRestRooms;
	}

	public int getRegPlaceBathrooms() {
		return regPlaceBathrooms;
	}

	public void setRegPlaceBathrooms(int regPlaceBathrooms) {
		this.regPlaceBathrooms = regPlaceBathrooms;
	}



	public String getRegPlaceName() {
		return regPlaceName;
	}

	public void setRegPlaceName(String regPlaceName) {
		this.regPlaceName = regPlaceName;
	}

	public String getRegPlaceAddress() {
		return regPlaceAddress;
	}

	public void setRegPlaceAddress(String regPlaceAddress) {
		this.regPlaceAddress = regPlaceAddress;
	}

	public String getRegPlaceLocality() {
		return regPlaceLocality;
	}

	public void setRegPlaceLocality(String regPlaceLocality) {
		this.regPlaceLocality = regPlaceLocality;
	}

	public String getRegPlacecity() {
		return regPlacecity;
	}

	public void setRegPlacecity(String regPlacecity) {
		this.regPlacecity = regPlacecity;
	}

	public String getRegPlaceMap() {
		return regPlaceMap;
	}

	public void setRegPlaceMap(String regPlaceMap) {
		this.regPlaceMap = regPlaceMap;
	}
	
	public String getRegPlaceMarriage() {
		return regPlaceMarriage;
	}

	public void setRegPlaceMarriage(String regPlaceMarriage) {
		this.regPlaceMarriage = regPlaceMarriage;
	}

	public String getRegPlaceConference() {
		return regPlaceConference;
	}

	public void setRegPlaceConference(String regPlaceConference) {
		this.regPlaceConference = regPlaceConference;
	}

	public String getRegPlacepartyHall() {
		return regPlacepartyHall;
	}

	public void setRegPlacepartyHall(String regPlacepartyHall) {
		this.regPlacepartyHall = regPlacepartyHall;
	}

	public String getRegPlaceHotel() {
		return regPlaceHotel;
	}

	public void setRegPlaceHotel(String regPlaceHotel) {
		this.regPlaceHotel = regPlaceHotel;
	}

	public String getRegPlaceOpenHouse() {
		return regPlaceOpenHouse;
	}

	public void setRegPlaceOpenHouse(String regPlaceOpenHouse) {
		this.regPlaceOpenHouse = regPlaceOpenHouse;
	}

	public String getRegPlaceAC() {
		return regPlaceAC;
	}

	public void setRegPlaceAC(String regPlaceAC) {
		this.regPlaceAC = regPlaceAC;
	}

	public String getRegPlacePower() {
		return regPlacePower;
	}

	public void setRegPlacePower(String regPlacePower) {
		this.regPlacePower = regPlacePower;
	}

	public String getRegPlaceMusic() {
		return regPlaceMusic;
	}

	public void setRegPlaceMusic(String regPlaceMusic) {
		this.regPlaceMusic = regPlaceMusic;
	}

	public String getRegPlaceVegetarian() {
		return regPlaceVegetarian;
	}

	public void setRegPlaceVegetarian(String regPlaceVegetarian) {
		this.regPlaceVegetarian = regPlaceVegetarian;
	}

	
}

