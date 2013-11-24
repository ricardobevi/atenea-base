package org.squadra.atenea.base.actions;

import java.awt.Desktop;
import java.net.URL;
import java.net.URLEncoder;

public class SearchInGoogle extends PreloadAction {

	@Override
	public void execute() {
		try {
			System.out.println("BUSQUEDA EN GOOGLE: " + param);
			String url = "http://www.google.com.ar/search?&q="
					+ URLEncoder.encode(param, "UTF-8");
			Desktop.getDesktop().browse(new URL(url).toURI());
		} catch (Exception e) {
		}
	}


}
