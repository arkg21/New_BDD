package utilities;

import java.util.Date;

public class DateUtility 
{

	public static String getEmailStamp() 
	{
		Date date=new Date();
		return "itachi"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}

}
