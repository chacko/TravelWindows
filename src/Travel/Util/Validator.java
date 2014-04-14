package Travel.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator 
{
	// Email Validator
	/**
	 * @param input
	 * @return true if input is valid email
	 */
	public static boolean isValidEmail(String input)
	{
		Pattern p = Pattern.compile("^[A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher m = p.matcher(input);
		
		return m.matches();
	}
	//check for double
	public static boolean isDouble(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}
