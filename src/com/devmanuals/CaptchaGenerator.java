/**
 * 
 */
package com.devmanuals;

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

import java.util.Random;
import javax.imageio.ImageIO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;


public class CaptchaGenerator extends ActionSupport implements ServletRequestAware {

	static final long serialVersionUID=1L;
	
	byte[] imageInByte = null;
	String imageId;
 
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
		        { 'j', 'j', 'l' }
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
		    int index = Math.abs(r.nextInt()) % 5;

		    String captcha = String.copyValueOf(data[index]);
		    

		    int x = 0; 
		    int y = 0;

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
		String filePath = servletRequest.getSession().getServletContext().getRealPath("/");
		File file = new File(filePath + "/Image/", imageId);
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
