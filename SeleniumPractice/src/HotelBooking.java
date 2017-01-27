import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class HotelBooking extends LoginPhP{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void Booking() {
		
		driver.findElement(By.xpath("//a[@href='http://phptravels.net/hotels']")).click();
		driver.findElement(By.xpath("//input[@class='form input-lg ng-pristine ng-valid ng-touched']")).sendKeys("marriot");
	}

}
