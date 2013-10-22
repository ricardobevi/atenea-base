package org.squadra.atenea.base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Hoja de recursos utilizados para la interfaz de usuario.
 * Contiene las rutas relativas de la imagenes, audios, etc.
 * @author Leandro Morrone
 *
 */
public class ResourcesActions {

	public static final String BASE_PATH = ("./");

	public static class Actions {

		public static final String PATH = BASE_PATH + "actions/";

		public static final String actions_file = PATH + "actions.json";
		public static final String commands_file = PATH + "commands.txt";
		public static final String screenshot_file = PATH + "screenshot.jpg";
		public static final String result_file = PATH + "result2.jpg";
		public static final String output_command_file = PATH + "output_command.txt";
		public static final String ICONS_PATH = PATH + "images/";
	}

	public static final void buildPaths()
	{
		File dir = new File(BASE_PATH);
		if (!dir.exists())
			dir.mkdir();

		dir = new File(Actions.PATH);
		if (!dir.exists())
			dir.mkdir();

		dir = new File(Actions.ICONS_PATH);
		if (!dir.exists())
			dir.mkdir();

		File archivo = new File(Actions.actions_file);
		if (!archivo.exists())
			try {
				archivo.createNewFile();
			} catch (IOException e) {	}

		File archivoCommands = new File(Actions.commands_file);
		if (!archivoCommands.exists())
			try {
				archivoCommands.createNewFile();
				FileWriter writer = new FileWriter(Actions.commands_file);
				writer.write("abrir bloc de notas,notepad.exe\n");
				writer.write("cerrar bloc de notas,taskkill /IM notepad.exe\n");
				writer.write("abrir panel de control,control\n");
				writer.write("abrir administrador de tareas,taskmgr\n");
				writer.close();
			} catch (Exception e) {}


	}
}
