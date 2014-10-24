/**
 * 
 */
package com.getbestplace;

/**
 * @author VIRAJ
 *
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class CaptchaGenerator extends ActionSupport implements ServletRequestAware,SessionAware {


	static final Logger LOGGER = Logger.getLogger(CaptchaGenerator.class);
	
	
	Map<String, Object> sessionMap;
	@Override
	 public void setSession(Map session) {
	    this.sessionMap = session;
	  }
	
	static final long serialVersionUID=19720L;
	
	byte[] imageInByte = null;
	String imageId;
	String captchaValue;
	
 
	private HttpServletRequest servletRequest;
 
	public String getImageId() {
		return imageId;
	}
 
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
 
	public CaptchaGenerator() {
		System.out.println("CaptchaGeneratorAction");
	}
 
	public String execute() {
		return SUCCESS;
	}
 
	public byte[] getCustomImageInBytes() {
 
		System.out.println("imageId" + imageId);
 
		BufferedImage originalImage;
		try {
			
			
			int width = 150;
		    int height = 50;

		    char data[][] = {
		        { 'z', 'v', 'k', 'c', 'o', 'd', 'e' },
		        { 'l', 'i', 'a', 'u', 'x' },
		        { 'v', 'r', 'p', 'j', 'b', 's', 'd' },
		        { 'u', 'a', 'i', 'n', 't', 'u' },
		        { 'j', 'j', 'l' },
		        { 'b', 'm', 'o', 'p', 'o' },
		        { 'j', 'a', 'l', 'o', 'i' },
		        { 'a', 'q', 'y', 't' },
		        { 's', 'j', 'n', 'o' },
		        { 'j', 'j', 'l', '1' },
		        { 'q', 'c', 'l' , '9'},
		        { '8', '7', '8', 'h', 'u' },
		    };


		    BufferedImage bufferedImage = new BufferedImage(width, height, 
		                  BufferedImage.TYPE_INT_RGB);

		    Graphics2D g2d = bufferedImage.createGraphics();

		    Font font = new Font("Georgia", Font.BOLD, 18);
		    g2d.setFont(font);

		    RenderingHints rh = new RenderingHints(
		           RenderingHints.KEY_ANTIALIASING,
		           RenderingHints.VALUE_ANTIALIAS_ON);

		    rh.put(RenderingHints.KEY_RENDERING, 
		           RenderingHints.VALUE_RENDER_QUALITY);

		    g2d.setRenderingHints(rh);

		    GradientPaint gp = new GradientPaint(0, 0, 
		    Color.red, 0, height/2, Color.black, true);

		    g2d.setPaint(gp);
		    g2d.fillRect(0, 0, width, height);

		    g2d.setColor(new Color(255, 153, 0));

		    Random r = new Random();
		    int index = Math.abs(r.nextInt()) % data.length;

		    String captcha = String.copyValueOf(data[index]);
		    

		    int x = 0; 
		    int y = 0;
		    
		    
		    this.captchaValue=String.valueOf(data[index]);
		    LOGGER.info("captchaValue "+this.captchaValue);
			sessionMap.put("captchaValue", this.captchaValue);
			
		    
		    
		    for (int i=0; i<data[index].length; i++) {
		        x += 10 + (Math.abs(r.nextInt()) % 15);
		        y = 20 + Math.abs(r.nextInt()) % 20;
		        g2d.drawChars(data[index], i, 1, x, y);
		    }

		    g2d.dispose();

		    
		    //ImageIO.write(bufferedImage, "png", os);
		    
			
			
			
			
			originalImage = ImageIO.read(getImageFile(this.imageId));
			// convert BufferedImage to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "png", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		return imageInByte;
	}
 
	private File getImageFile(String imageId) {
		String filePath = servletRequest.getSession().getServletContext().getRealPath("/view/userview");
		System.out.println("*o*"+filePath);
		File file = new File(filePath, "captcha.png");//this and above path is suppose to go in prop file
		System.out.println(file.toString());
		return file;
	}
 
	public String getCustomContentType() {
		return "image/png";
	}
 
	public String getCustomContentDisposition() {
		return "anyname.png";
	}
 
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;
 
	}
 
}
