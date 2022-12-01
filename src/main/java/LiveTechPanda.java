import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LiveTechPanda {
	
 WebDriver driver;
	
  @BeforeTest
  public void openBrowser() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }
  
  @Test
  public void TC01_VerifyUrl(){
	  driver.get("http://live.techpanda.org/");
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
	  
	  driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	  Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
  }
  
  @AfterTest
  public void closeBrowser(){
	  driver.close();
  }
}
