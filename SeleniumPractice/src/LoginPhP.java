import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;



public class LoginPhP {

	protected static WebDriver driver=new FirefoxDriver();
	WebElement el_checkin,el_checkout;
	@BeforeClass
	public static void openBrowser() throws Exception {
		driver.get("http://phptravels.net/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	//@BeforeMethod

	//@Test
	//public void ValidLogin() {
	//	System.out.println("Method start : "+Thread.currentThread().getStackTrace()[1].getMethodName());
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.findElement(By.xpath("*//li[@class='pull-right width_change']")).click();
	//	driver.findElement(By.xpath("//a[text()='  Login']")).click();
	//	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user@phptravels.com");
	//	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demouser");
	//	driver.findElement(By.xpath("//button[@class='btn btn-action btn-block loginbtn']")).click();
	//	System.out.println("Method end : "+Thread.currentThread().getStackTrace()[1].getMethodName());
	//}
	
	@Test
	public void Booking() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String CheckinFile,CheckoutFile,Adults;
		String Hotel;
		String Room;
		int Colnum;
		int totalRows;
		String TypeOfUser;
		System.out.println("Method start : "+Thread.currentThread().getStackTrace()[1].getMethodName());
		//driver.findElement(By.xpath("*//a[contains(text(),'Hotels')]")).click();
		ExcelUtils.setExcelfile(ConstantDataDrivenTest.Path_TestData+ConstantDataDrivenTest.File_TestData_BookingInfo, "Sheet1");
		int rows=ExcelUtils.getRowsFromExcel();
		System.out.println("Rows= "+rows);
		//rows=rows-1;
		//totalRows=ExcelW
		for(int i=1;i<rows;i++)
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@href='http://phptravels.net/properties']")).click();
			Colnum=0;
			Colnum=ExcelUtils.getColumnsFromExcel(i);
			//for(int j=0;j<Colnum;j++)
			
				CheckinFile=ExcelUtils.readExcelFile(i, 0);
				CheckoutFile=ExcelUtils.readExcelFile(i, 1);
				Adults=ExcelUtils.readExcelFile(i, 2);
				Hotel=ExcelUtils.readExcelFile(i, 3);
				Room=ExcelUtils.readExcelFile(i, 4);
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//	new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://phptravels.net/hotels/singapore/singapore/Rendezvous-Hotels']")));
				//	driver.findElement(By.xpath("*//h4[@class='mtb0 RTL go-text-right']")).click();
				for(int k=1;k<9;k++)
				{
					System.out.println("The Hotel is "+driver.findElement(By.xpath("//div[contains(@class,'rightcontent')]//table[contains(@class,'table')]//tr[k]//div[contains(@class,'RTL')]/div[2]//h4/a")).getText());//div[contains(@class,'rightcontent')]//table[contains(@class,'table')]//tr[1]//div[contains(@class,'RTL')]/div[2]//h4/a

				}
				
				
		}
		
				
			
				//if(StringUtils.containsIgnoreCase(Room,"Superior Double"))
					
				
				try
				{
					System.out.println("Method end : "+Thread.currentThread().getStackTrace()[1].getMethodName());
				}
				catch(Exception e)
				{
					
				}
				//driver.findElement(By.xpath("//th[@class='switch' and contains(text(),'June 2017')]"))
				//driver.findElement(By.xpath("//input[@class='form input-lg ng-pristine ng-valid ng-touched']")).sendKeys("marriot");

		
	}
}
