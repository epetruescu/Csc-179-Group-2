package newpackage;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JLoginTesting {
	private static ChromeDriver driver;
	WebElement element;
	WebElement actual;
	@BeforeClass
	public static void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ilike\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@Test
	public void valid_Credentials()
	{
		driver.get("https://demo.snipeitapp.com/login");
		driver.findElement(By.className("form-control")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.className("box-footer")).click();
	
		try {
		
			element = driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[8]/ul/li[7]/a"));
			driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[8]/a/span")).click();
			driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[8]/ul/li[7]/a")).click();
			
		}
		catch (Exception e)
		{
			Assert.assertNotNull(element);
		
			
		}
	
	}

	@Test
	public void invalid_Credentials()
	{
		driver.get("https://demo.snipeitapp.com/login");
		driver.findElement(By.className("form-control")).sendKeys("admi");
		driver.findElement(By.name("password")).sendKeys("pasword");
		driver.findElement(By.className("box-footer")).click();
	
		try {
			element = driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[8]/ul/li[7]/a"));
		}
		catch (Exception e)
		{
					
		}
	
	}
	
	
	@AfterClass
	 public static void closeBrowser(){
		 driver.quit();
	 }
}
