package org.squadra.atenea.base.string;

import java.util.ArrayList;

public class StringUtils {
	
	public static ArrayList<Integer> findOcurrences(String baseString, String matchString){
		ArrayList<Integer> matches = new ArrayList<Integer>();
		
		Integer baseLength = baseString.length();
		Integer matchLengh = matchString.length();
		
		Integer i = 0;
		
		while( i < baseLength ){
			
			while( i < baseLength && baseString.charAt(i) != matchString.charAt(0) )
				i++;
			
			//Ya compare el primer caracter de la linea, lo salteo. 
			Integer j = 1;
			i = i + 1;
			
			while( i < baseLength && j < matchLengh && baseString.charAt(i) == matchString.charAt(j) ){
				i++;
				j++;
			}
			
			//Si termino el while anterior por haber recorrido toda la cadena que quiero machear, tengo una posicion.
			if (i < baseLength && j >= matchLengh ){
				matches.add(i - matchLengh);
				i++;
			}

			
		}
		
		return matches;
	}

}
