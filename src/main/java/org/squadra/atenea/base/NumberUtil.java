package org.squadra.atenea.base;

public class NumberUtil {

	public static boolean isValidNumber(Object ostr) {
		boolean result = false;
		
		if (ostr != null && !StringUtil.isNullOrEmpty(ostr.toString())) { 
			try {
				Integer.parseInt(ostr.toString());
				result = true;
			} catch (NumberFormatException e) { 
			}
		}
		
		return result;
	}
	
	public static Integer toInt(Object ostr) {
		return toInt(ostr, 0);
	}
	
	public static Integer toInt(Object ostr, Integer defaultValue) {
		Integer value;
		String str = null;
		
		if (ostr != null) {
			str = ostr.toString();
		}
		
		if (!StringUtil.isNullOrEmpty(str)) { 
			try {
				value = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				value = defaultValue;
			}
		} else {
			value = defaultValue;
		}
	
		return value;
	}
	
	public static Long toLong(Object ostr) {
		return toLong(ostr, 0L);
	}
	
	public static Long toLong(Object ostr, Long defaultValue) {
		Long value;
		String str = null;
		
		if (ostr != null) {
			str = ostr.toString();
		}
		
		if (!StringUtil.isNullOrEmpty(str)) { 
			try {
				value = Long.parseLong(str);
			} catch (NumberFormatException e) {
				value = defaultValue;
			}
		} else {
			value = defaultValue;
		}
	
		return value;
	}
	
}
