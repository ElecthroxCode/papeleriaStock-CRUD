package stockPapeleria.util;

public class PropsOperations {
	
	public static boolean isNumericDouble(String s) {
		try {
			Double.parseDouble(s);
		}catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
		}catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static String CapitalizeString(String str) {
		String strLower = str.toLowerCase();
		String firstLetter = strLower.substring(0, 1).toUpperCase();
		String remainderStr = strLower.substring(1);
		String newStr = firstLetter + remainderStr;
		return newStr;
	}
}

