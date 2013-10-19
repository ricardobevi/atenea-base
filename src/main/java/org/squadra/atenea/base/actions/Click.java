package org.squadra.atenea.base.actions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Click{

	private String typeOfClick;
	private String pathOfIcon;
	
	
	public Click(String typeOfClick, String pathOfIcon) {
		super();
		this.typeOfClick = typeOfClick;
		this.pathOfIcon = pathOfIcon;
	}
	
	
	public String getTypeOfClick() {
		return typeOfClick;
	}
	public void setTypeOfClick(String typeOfClick) {
		this.typeOfClick = typeOfClick;
	}
	public String getPathOfIcon() {
		return pathOfIcon;
	}
	public void setPathOfIcon(String pathOfIcon) {
		this.pathOfIcon = pathOfIcon;
	}
	
	public String serialize()
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedImage image;
	    try {
	    	image = ImageIO.read(new File(pathOfIcon));
			ImageIO.write(image, "jpg", baos);
		} catch (IOException e) {
		}
	    
	    
		return typeOfClick + "||" + pathOfIcon + "||" + baos.toByteArray().toString(); 	
	}
	
	static public Click deserialize(String in)
	{
		String[] out = in.split("||");

		ByteArrayInputStream bytes = new ByteArrayInputStream(out[2].getBytes());
		try {
			BufferedImage image = ImageIO.read(bytes);
			FileOutputStream file = new FileOutputStream(out[1]);
			ImageIO.write(image, "jpg", file);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Click(out[0], out[1]);
	}
	
}
