package org.squadra.atenea.base;

/**
 * Utility class useful when dealing with string objects. This class is a
 * collection of static functions, and the usage is:
 * 
 * StringUtil.method()
 * 
 * it is not allowed to create instances of this class
 */
public class StringUtil {

	/**
	 * Returns true if the given string is null or empty.
	 */
	public static boolean isNullOrEmpty(final String str) {
		if (str == null)
	      return true;
	    if (str.trim().equals(""))
	      return true;
	    return false;
	}
	
	public static String padLeft(String str, int positions, char filler){
		return String.format("%1$#" + positions + "s", str).replace(' ', filler);
	}
  
	public static String toPascalCase(String string) {
		return string.substring(0,1).toUpperCase() + string.substring(1);
	}
	
	public static String padRight(String str, int positions, char filler) {
		return String.format("%1$-" + positions + "s", str).replace(' ', filler);
	}
	

	public static String replaceAccents(String input) {
		
		String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = new String(input);
	    
	    for (int j = 0; j < original.length(); j++) {
	        output = output.replace(original.charAt(j), ascii.charAt(j));
	    }
	    
	    return output;
	}
	

}