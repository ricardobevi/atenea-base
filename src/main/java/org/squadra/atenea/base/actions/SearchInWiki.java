package org.squadra.atenea.base.actions;

import java.awt.Desktop;
import java.net.URL;
import java.net.URLEncoder;

public class SearchInWiki extends PreloadAction {

	@Override
	public void execute() {
		
		try {
			String url = "http://es.wikipedia.org/w/index.php?search="
					+ URLEncoder.encode(param, "UTF-8");
			Desktop.getDesktop().browse(new URL(url).toURI());
		} catch (Exception e) {
		}
	}

}
