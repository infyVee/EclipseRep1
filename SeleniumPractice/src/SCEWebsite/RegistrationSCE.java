package SCEWebsite;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class RegistrationSCE extends SuiteBaseSCE {
	static ExcelOpsESCE FilePath = null;
	static ExcelOpsESCE FilePathOutputSheet=null;
	String TestCaseName = null;
	String Status,timestamp, ssname;
	public Object[][] dataFromExcel;
	int i=0,j=0;
	CommonMethods tmsp =new CommonMethods();
	

	@BeforeClass
	public static void openBrowser() throws IOException{
		System.out.println("Inside OpenBrowser() @BeforeClass");
		//Called init() function from SuiteBase class to Initialize .xls Files
		init();	
		System.out.println("Leaving OpenBrowser() @BeforeClass");
	}

	@AfterClass
	public static void closeBrowser() throws Exception {
		driver.close();
	}

	@Test
	public void RegisterFirstpageConfirmPwdMismatch() {
		System.out.println("Inside RegisterFirstpageConfirmPwdMismatch()");
		FilePath = RegisterCfmPwd;
		FilePathOutputSheet = TestExecutionSheet;
		SoftAssert s_assert = new SoftAssert();
		TestCaseName=new Object(){}.getClass().getEnclosingMethod().getName(); 
		try
		{
			System.out.println("Inside Try block inside RegisterFirstpageConfirmPwdMismatch()");
			dataFromExcel=FilePath.retrieveTestData("Sheet1");
			//driver.findElement(By.xpath(prop.getProperty("Register"))).click();
			
			/*Below reads from excel and types into the webpage . When using testNG, the below can be performed without loop 
			using Data Provider and @Test*/
			//for(i=0;i<=1;i++)
			//{
				
			//	driver.findElement(By.xpath(prop.getProperty("Email"))).sendKeys(dataFromExcel[i][0].toString());
			//	driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(dataFromExcel[i][1].toString());
			//	driver.findElement(By.xpath(prop.getProperty("confirmPassword"))).sendKeys(dataFromExcel[i][2].toString());
			//	driver.findElement(By.xpath(prop.getProperty("NextButton"))).click();
			//	System.out.println("Taking screen shot from reg");
				ssname=tmsp.ScreenShotCapture(TestCaseName);
				Status=new String("Pass");
				FilePathOutputSheet.WriteintoTestExecutionSheet("Sheet1",TestCaseName,Status,tmsp.TimeStampCalc(),ssname);
		//		driver.navigate().refresh();
		//	}
				
			System.out.println("Leaving Try block inside RegisterFirstpageConfirmPwdMismatch()");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Leaving RegisterFirstpageConfirmPwdMismatch()");	
	}

}
