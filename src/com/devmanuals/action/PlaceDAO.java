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

import java.io.File;
import java.io.IOException;
 
import java.nio.file.Files;

import javax.servlet.ServletContext;
 

import org.apache.struts2.util.ServletContextAware;
 

import com.devmanuals.util.FilesUtil;

public class PlaceDAO  extends ActionSupport  implements  SessionAware,ServletRequestAware,ServletContextAware{

	/**
	 * 
	 */
	static final Logger LOGGER = Logger.getLogger(PlaceDAO.class);
	
	
	
	private File indexFile;
    private String indexFileContentType;
    private String indexFileFileName;
    private String filesPath;
    
    private File add1File;
    private String add1FileContentType;
    private String add1FileFileName;
    
    private File add2File;
    private String add2FileContentType;
    private String add2FileFileName;
    
    private File add3File;
    private String add3FileContentType;
    private String add3FileFileName;
    
    private File add4File;
    private String add4FileContentType;
    private String add4FileFileName;
    
    private File packageFile;
    private String packageFileContentType;
    private String packageFileFileName;
    
    private ServletContext context;
 
    public File getIndexFile() {
        return indexFile;
    }
 
    public void setIndexFile(File indexFile) {
        this.indexFile = indexFile;
    }
 
    public String getIndexFileContentType() {
        return indexFileContentType;
    }
 
    public void setIndexFileContentType(String indexFileContentType) {
        this.indexFileContentType = indexFileContentType;
    }
 
    public String getIndexFileFileName() {
        return indexFileFileName;
    }
 
    public void setIndexFileFileName(String indexFileFileName) {
        this.indexFileFileName = indexFileFileName;
    }
 
    public void setFilesPath(String filesPath) {
        this.filesPath = filesPath;
    }
 
    public File getAdd1File() {
		return add1File;
	}

	public void setAdd1File(File add1File) {
		this.add1File = add1File;
	}

	public String getAdd1FileContentType() {
		return add1FileContentType;
	}

	public void setAdd1FileContentType(String add1FileContentType) {
		this.add1FileContentType = add1FileContentType;
	}

	public String getAdd1FileFileName() {
		return add1FileFileName;
	}

	public void setAdd1FileFileName(String add1FileFileName) {
		this.add1FileFileName = add1FileFileName;
	}

	public File getAdd2File() {
		return add2File;
	}

	public void setAdd2File(File add2File) {
		this.add2File = add2File;
	}

	public String getAdd2FileContentType() {
		return add2FileContentType;
	}

	public void setAdd2FileContentType(String add2FileContentType) {
		this.add2FileContentType = add2FileContentType;
	}

	public String getAdd2FileFileName() {
		return add2FileFileName;
	}

	public void setAdd2FileFileName(String add2FileFileName) {
		this.add2FileFileName = add2FileFileName;
	}

	public File getAdd3File() {
		return add3File;
	}

	public void setAdd3File(File add3File) {
		this.add3File = add3File;
	}

	public String getAdd3FileContentType() {
		return add3FileContentType;
	}

	public void setAdd3FileContentType(String add3FileContentType) {
		this.add3FileContentType = add3FileContentType;
	}

	public String getAdd3FileFileName() {
		return add3FileFileName;
	}

	public void setAdd3FileFileName(String add3FileFileName) {
		this.add3FileFileName = add3FileFileName;
	}

	public File getAdd4File() {
		return add4File;
	}

	public void setAdd4File(File add4File) {
		this.add4File = add4File;
	}

	public String getAdd4FileContentType() {
		return add4FileContentType;
	}

	public void setAdd4FileContentType(String add4FileContentType) {
		this.add4FileContentType = add4FileContentType;
	}

	public String getAdd4FileFileName() {
		return add4FileFileName;
	}

	public void setAdd4FileFileName(String add4FileFileName) {
		this.add4FileFileName = add4FileFileName;
	}

	
    public File getPackageFile() {
		return packageFile;
	}

	public void setPackageFile(File packageFile) {
		this.packageFile = packageFile;
	}

	public String getPackageFileContentType() {
		return packageFileContentType;
	}

	public void setPackageFileContentType(String packageFileContentType) {
		this.packageFileContentType = packageFileContentType;
	}

	public String getPackageFileFileName() {
		return packageFileFileName;
	}

	public void setPackageFileFileName(String packageFileFileName) {
		this.packageFileFileName = packageFileFileName;
	}

	
    @Override
    public void setServletContext(ServletContext ctx) {
        this.context=ctx;
    }
	
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
	
		 
	public String addPlace() throws Exception{
		
		/*check files format and return input if they dont match*/
		
		User userObj;
		userObj=(User)this.sessionMap.get("currentUser");
		
		if(userObj==null || userObj.getUserId()<1)
		{
			return "login";
		}
		LOGGER.info("This is a userObj id"+userObj.getUserId());
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		Session session=sessionFactory.openSession();
		
		Place placeBean =new Place();
		placeBean.setAddress(regPlaceAddress);
		placeBean.setName(regPlaceName);
		placeBean.setCity("pune");
		placeBean.setLocality(regPlaceLocality);
		placeBean.setPostalCode(regPlacePostcode);
		placeBean.setOwnerId(userObj.getUserId());
		placeBean.setPhone(regPlacePhone);
		
		
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
		
		String completeFilePath="";
		LOGGER.info("File Name is:"+getIndexFileFileName());
		LOGGER.info("File ContentType is:"+getIndexFileContentType());
		LOGGER.info("add 1 Name is:"+getAdd1FileFileName());
		LOGGER.info("add 1 ContentType is:"+getAdd1FileFileName());
		LOGGER.info("add 2 Name is:"+getAdd2FileFileName());
		LOGGER.info("add 2 ContentType is:"+getAdd2FileFileName());
		LOGGER.info("add 3 Name is:"+getAdd3FileFileName());
		LOGGER.info("add 3 ContentType is:"+getAdd3FileFileName());
		LOGGER.info("add 4 Name is:"+getAdd4FileFileName());
		LOGGER.info("add 4 ContentType is:"+getAdd4FileFileName());
		LOGGER.info("package Name is:"+getPackageFileFileName());
		LOGGER.info("package ContentType is:"+getPackageFileContentType());
		LOGGER.info("Files Directory is:"+servletRequest.getContextPath());
        try {
        	/*avoid spacing by using .replaceAll("\\s","")*/
        	
            String additionalFilePath=File.separator +placeBean.getCity().replaceAll("\\s","")+File.separator+placeBean.getLocality().replaceAll("\\s","")+File.separator+placeBean.getName().replaceAll("\\s","")+File.separator;
            completeFilePath=filesPath+additionalFilePath;
            FilesUtil.saveFile(getIndexFile(), getIndexFileFileName(), context.getRealPath("") + File.separator + completeFilePath);
            LOGGER.info("file name "+getAdd1FileFileName());
            if(getAdd1FileFileName()!=null)
            	FilesUtil.saveFile(getAdd1File(), getAdd1FileFileName(), context.getRealPath("") + File.separator + completeFilePath);
            
            if(getAdd2FileFileName()!=null)
            	FilesUtil.saveFile(getAdd2File(), getAdd2FileFileName(), context.getRealPath("") + File.separator + completeFilePath);
            
            if(getAdd3FileFileName()!=null)
            	FilesUtil.saveFile(getAdd3File(), getAdd3FileFileName(), context.getRealPath("") + File.separator + completeFilePath);
            
            if(getAdd4FileFileName()!=null)
            	FilesUtil.saveFile(getAdd4File(), getAdd4FileFileName(), context.getRealPath("") + File.separator + completeFilePath);
            
            if(getPackageFileFileName()!=null)
            	FilesUtil.saveFile(getPackageFile(), getPackageFileFileName(), context.getRealPath("") + File.separator + completeFilePath);
        
        } catch (IOException e) {
            e.printStackTrace();
            return INPUT;
        }
        Attribute attributeIndexFileLoc=getAttribute("Index",(completeFilePath.replace("\\", "/")+getIndexFileFileName()),placeBean);
		LOGGER.info("done");
		session.beginTransaction();
		
		session.save(placeBean);
		
		session.save(attributeParking);
		session.save(attributeIndexFileLoc);
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
		session.close();
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

}

