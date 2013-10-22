package org.squadra.atenea.base.actions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.squadra.atenea.base.ResourcesActions;

import javax.xml.bind.DatatypeConverter;

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
	
	public BufferedImage getImage()
	{
		BufferedImage ret = null;
		try {
			 ret = ImageIO.read(new File(pathOfIcon));
		} catch (IOException e) {
		}
		return ret;
	}
	
	public String serialize()
	{    
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    try {
			ImageIO.write(ImageIO.read(new File(pathOfIcon)), "jpg", baos);
		} catch (IOException e) {
		}
	    System.out.println(typeOfClick + "||" + DatatypeConverter.printBase64Binary(baos.toByteArray()));
		return typeOfClick + "||" + DatatypeConverter.printBase64Binary(baos.toByteArray()); 	
	}
	
	static public Click deserialize(String in)
	{
		String[] out = in.split("\\|\\|");
		String iconName  = ResourcesActions.Actions.ICONS_PATH + "_icon" + new java.util.Date().getTime() + ".jpg";
		ByteArrayInputStream bytes = new ByteArrayInputStream(DatatypeConverter.parseBase64Binary(out[1]));
		System.out.println(iconName +" "+ out[0]);
		try {
			ImageIO.write(ImageIO.read(bytes), "jpg", new FileOutputStream(iconName));			
		} catch (IOException e) {
		}
		return new Click(out[0], iconName);
	}
	
}
