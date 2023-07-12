package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyUtility 
{

	public static Properties getPropertyData()
	{

		File file= new File(System.getProperty("user.dir")+"\\src\\main\\resources\\DataFiles\\data.properties");
		Properties p = new Properties();
		try 
		{
			FileInputStream fis= new FileInputStream(file);
			p.load(fis);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return p;
		
	}
}
