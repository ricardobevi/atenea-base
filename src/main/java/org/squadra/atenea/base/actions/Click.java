package org.squadra.atenea.base.actions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.squadra.atenea.base.ResourcesActions;

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
	    
	    
		return typeOfClick + "||" + baos.toByteArray().toString(); 	
	}
	
	static public Click deserialize(String in)
	{
		String[] out = in.split("||");
		String iconName  = ResourcesActions.Actions.ICONS_PATH + "icon" + new java.util.Date().getTime() + ".jpg";
		
		ByteArrayInputStream bytes = new ByteArrayInputStream(out[1].getBytes());
		try {
			BufferedImage image = ImageIO.read(bytes);
			FileOutputStream file = new FileOutputStream(iconName);
			ImageIO.write(image, "jpg", file);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Click(out[0], iconName);
	}
	
}
