package genericUtilities;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * This class consists of generic java tool
 */

public class JavaUtilities {

	
	/**
	 * This method will capture the current system date in required format
	 * and return to caller
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date(0);
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String dateinformat = f.format(d);
		return dateinformat;
				
	}

}


