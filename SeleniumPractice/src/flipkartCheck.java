
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

public class flipkartCheck {
	protected static WebDriver driver=new FirefoxDriver();
	
	@BeforeClass
	public static void openBrowser() throws Exception {
		driver.get("http://sparshv2/Pages/Home.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
