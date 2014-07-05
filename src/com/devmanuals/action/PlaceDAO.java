package com.devmanuals.action;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devmanuals.model.Attribute;
import com.devmanuals.model.Place;
import com.devmanuals.model.User;
import com.devmanuals.listener.HibernateListener;
import com.opensymphony.xwork2.ActionSupport;

public class PlaceDAO  extends ActionSupport  implements  SessionAware,ServletRequestAware{

	/**
	 * 
	 */
	static final Logger LOGGER = Logger.getLogger(PlaceDAO.class);
	
	Map<String, Object> sessionMap;
	private HttpServletRequest servletRequest;
	 
	@Override
	 public void setSession(Map session) {
	    this.sessionMap = session;
	  }
	
	@Override
	 public void setServletRequest(HttpServletRequest servletRequest) {
	  this.servletRequest = servletRequest;
	 }
	
	private static final long serialVersionUID = 6427837709720937902L;
	
	
//	private File regPlaceIndexImg;
	
		 
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
		placeBean.setName(regPlaceName);
		placeBean.setCity("pune");
		placeBean.setLocality(regPlaceLocality);
		placeBean.setPostalCode(regPlacePostcode);
		placeBean.setOwnerId(userObj.getUserId());
		
		Attribute attributeMap=getAttribute("map",regPlaceMap,placeBean);
		Attribute attributeVeg=getAttribute("vegetarian",regPlaceVegetarian,placeBean);
		Attribute attributeMinPrice=getAttribute("MinimumPrice",regPlaceMinPrice,placeBean);
		Attribute attributeMaxPrice=getAttribute("MaximumPrice",regPlaceMaxPrice,placeBean);
		Attribute attributeCapacity=getAttribute("Capacity",regPlaceCapacity,placeBean);
		Attribute attributeDinning=getAttribute("Dinning",regPlaceDinning,placeBean);
		Attribute attributeArea=getAttribute("Area",regPlaceArea,placeBean);
		Attribute attributeWater=getAttribute("Water",regPlaceWater,placeBean);
		Attribute attributeParking=getAttribute("Parking",regPlaceParking,placeBean);
		Attribute attributeRestRooms=getAttribute("RestRooms",regPlaceRestRooms,placeBean);
		Attribute attributeBathRooms=getAttribute("BathRooms",regPlaceBathrooms,placeBean);
		Attribute attributeMarriage=getAttribute("Marriage",regPlaceMarriage,placeBean);
		Attribute attributeConference=getAttribute("Conference",regPlaceConference,placeBean);
		Attribute attributeParty=getAttribute("Party",regPlacepartyHall,placeBean);
		Attribute attributeHotel=getAttribute("Hotel",regPlaceHotel,placeBean);
		Attribute attributeOpenHouse=getAttribute("OpenHouse",regPlaceOpenHouse,placeBean);
		Attribute attributeAC=getAttribute("AC",regPlaceAC,placeBean);
		Attribute attributePower=getAttribute("Power",regPlacePower,placeBean);
		Attribute attributeMusic=getAttribute("Music",regPlaceMusic,placeBean);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////
		String pathIndex="";
		/*try {
		      String filePath = servletRequest.getSession().getServletContext().getRealPath("/");
		      LOGGER.info("Server path: " + filePath);
		      filePath+="\\\\places\\\\"+placeBean.getCity()+"\\\\"+placeBean.getLocality()+"\\\\"+placeBean.getName();
		      new File(filePath).mkdirs();
		      LOGGER.info("sath to "+filePath);
		      File fileToCreate = new File(filePath, "index");
		      pathIndex=fileToCreate.getPath();
		      LOGGER.info("still ok to "+pathIndex);
		      FileUtils.copyFile(this.regPlaceIndexImg, fileToCreate);
		  } catch (Exception e) {
		      e.printStackTrace();
		      LOGGER.info("fail "+e.getMessage());
		      addActionError(e.getMessage());
		 
		      return "error";
		  }*/
////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//Attribute attributeIndexImage=getAttribute("indexImg",pathIndex,placeBean);
		LOGGER.info("done");
		session.beginTransaction();
		
		session.save(placeBean);
		
		session.save(attributeParking);
		//session.save(attributeIndexImage);
		session.save(attributeRestRooms);
		session.save(attributeBathRooms);
		
		session.save(attributeCapacity);
		session.save(attributeDinning);
		session.save(attributeArea);
		session.save(attributeWater);
		
		session.save(attributeMap);
		session.save(attributeVeg);
		session.save(attributeMinPrice);
		session.save(attributeMaxPrice);
		
		session.save(attributeMusic);
		session.save(attributePower);
		session.save(attributeAC);
		session.save(attributeOpenHouse);
		
		session.save(attributeHotel);
		session.save(attributeParty);
		session.save(attributeConference);
		session.save(attributeMarriage);
		
		
		session.getTransaction().commit();
//		
		return SUCCESS;
	}
	
	public Attribute getAttribute(String attrName, Object value,Place place){
		
		Attribute tempAttr=new Attribute();
		tempAttr.setAttributeName(attrName);
		if(value instanceof String){
			tempAttr.setStringValue((String)value);
		}
		else if(value instanceof Long){
			tempAttr.setIntValue((Long)value);
			
		}else if(value instanceof Double){
			tempAttr.setDoubleValue((Double)value);
		}
		tempAttr.setPlace(place);
		return tempAttr;
		
	}
	
	
	
	long  regPlacePhone ,regPlacePostcode ;

	long regPlaceMinPrice,regPlaceMaxPrice;
	long regPlaceCapacity ,regPlaceDinning ,regPlaceArea ,regPlaceWater ,regPlaceParking ,regPlaceRestRooms, regPlaceBathrooms; 
	String regPlaceMarriage,	regPlaceConference,	regPlacepartyHall,	regPlaceHotel,	regPlaceOpenHouse ,regPlaceAC;	
	String regPlacePower ,regPlaceMusic,regPlaceVegetarian;
	String regPlaceName , regPlaceAddress , regPlaceLocality, regPlacecity,regPlaceMap;
	

	public long getRegPlacePhone() {
		return regPlacePhone;
	}

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

	public void setRegPlacePhone(long regPlacePhone) {
		this.regPlacePhone = regPlacePhone;
	}

	public long getRegPlacePostcode() {
		return regPlacePostcode;
	}

	public void setRegPlacePostcode(long regPlacePostcode) {
		this.regPlacePostcode = regPlacePostcode;
	}

	public long getRegPlaceCapacity() {
		return regPlaceCapacity;
	}

	public void setRegPlaceCapacity(long regPlaceCapacity) {
		this.regPlaceCapacity = regPlaceCapacity;
	}

	public long getRegPlaceDinning() {
		return regPlaceDinning;
	}

	public void setRegPlaceDinning(long regPlaceDinning) {
		this.regPlaceDinning = regPlaceDinning;
	}

	public long getRegPlaceArea() {
		return regPlaceArea;
	}

	public void setRegPlaceArea(long regPlaceArea) {
		this.regPlaceArea = regPlaceArea;
	}

	public long getRegPlaceWater() {
		return regPlaceWater;
	}

	public void setRegPlaceWater(long regPlaceWater) {
		this.regPlaceWater = regPlaceWater;
	}

	public long getRegPlaceParking() {
		return regPlaceParking;
	}

	public void setRegPlaceParking(long regPlaceParking) {
		this.regPlaceParking = regPlaceParking;
	}

	public long getRegPlaceRestRooms() {
		return regPlaceRestRooms;
	}

	public void setRegPlaceRestRooms(long regPlaceRestRooms) {
		this.regPlaceRestRooms = regPlaceRestRooms;
	}

	public long getRegPlaceBathrooms() {
		return regPlaceBathrooms;
	}

	public void setRegPlaceBathrooms(long regPlaceBathrooms) {
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

//	public File getRegPlaceIndexImg() {
//		return regPlaceIndexImg;
//	}
//
//	public void setRegPlaceIndexImg(File regPlaceIndexImg) {
//		this.regPlaceIndexImg = regPlaceIndexImg;
//	}

	
}

