package org.squadra.atenea.base.actions;

import java.awt.Desktop;
import java.net.URL;

public class OpenFacebook extends PreloadAction {

	@Override
	public void execute() {
		try {
			Desktop.getDesktop().browse(new URL("http://www.facebook.com").toURI());
		} catch (Exception e) {
		}
	}


}
