package SCEWebsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CommonMethods extends SuiteBaseSCE {
	
	//Properties prop = new Properties();
	//InputStream input = null;
	
	public String TimeStampCalc()
	{
		System.out.println("Inside TimeStampCalc Method");
		// Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy HH.mm.ss");
		 //get current date time with Date()
		 Date date = new Date();
		 // Now format the date
		 String date1= dateFormat.format(date);
		// Print the Date
		 System.out.println("End of TimeStampCalc Method");
		 return date1;
		
	}
	
	public String ScreenShotCapture(String TestCaseName) throws IOException
	{
		String date=TimeStampCalc();
		System.out.println("Taking ScreenShot");
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//copying file to the desired location 
			FileUtils.copyFile(src, new File("C:\\Users\\Veena_Mathew\\Desktop\\ScreenShotFromSelenium\\"+TestCaseName+" "+date+".png"));
			//Copying to the desired location
			System.out.println(" end of code for screen shot");
			return TestCaseName+" "+date+".png";
	}
	


}
