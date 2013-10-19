package org.squadra.atenea.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import lombok.extern.log4j.Log4j;

@Log4j
public class TextFileUtils {
	
	/**
	 * Lee un archivo de texto y devuelve su contenido en una lista.
	 * @param filePath Ruta del archivo de texto
	 * @return Lista de lineas que contiene el archivo de texto.
	 */
	public static ArrayList<String> readTextFile(String filePath) {
		
		ArrayList<String> fileContent = new ArrayList<String>();
		
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
	        while ((line = br.readLine()) != null)   {
	            fileContent.add(line);
	        }
	        
	        fr.close();
	    } catch (Exception e) {
	    	log.error("Error al leer archivo: " + filePath);
	    }
		
		return fileContent;
	}
	
}


