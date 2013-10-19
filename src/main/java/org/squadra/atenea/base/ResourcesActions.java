package org.squadra.atenea.base;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * Hoja de recursos utilizados para la interfaz de usuario.
 * Contiene las rutas relativas de la imagenes, audios, etc.
 * @author Leandro Morrone
 *
 */
public class ResourcesActions {

	public static final String BASE_PATH = new String().getClass().getResource("/").getPath();

	public static class Actions {
			
		public static final String PATH = BASE_PATH ;
		
		public static final String actions_file = PATH + "actions.json";
		public static final String commands_file = PATH + "commands.txt";
		public static final String screenshot_file = PATH + "screenshot.jpg";
		public static final String result_file = PATH + "result2.jpg";
		public static final String output_command_file = PATH + "output_command.txt";
		public static final String ICONS_PATH = PATH ;
	}
	
}
