package newpackage;
import static org.junit.Assert.assertEquals;

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
/*
 * JUnit testing for the Location tab located https://demo.snipeitapp.com/hardware/bulkcheckout
 */
public class JLocationTest {
	//Variables
	private static ChromeDriver driver;
	WebElement element;
	String checkElement;
	String success = "×\n" + 
			"Success: Asset checked out successfully.";
	String failure = "×\n" + 
			"Error: You must select at least one asset from the list";
	String assetCheckoutPage ="                 Checkout Assets\n" + 
			"";
	@BeforeClass
	public static void openBrowser()
	{
		//Initialize
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ilike\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://demo.snipeitapp.com/login");
		driver.findElement(By.className("form-control")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.className("box-footer")).click();
		
	
	}
	@Test
	public void successfulLocation()
	{
		//Successful run of Location Tab
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.xpath("//*[@id=\"assignto_selector\"]/div/div/label[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"assigned_location\"]/div[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_location_location_select-results\"]/li[2]/div/div[2]")).click();
		
		driver.findElement(By.id("checkout_at")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[3]/td[3]")).click();
		driver.findElement(By.id("expected_checkin")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[1]")).click();
		
		driver.findElement(By.id("note")).sendKeys("Can't wait for this sunday, Battle of Winterfell!!!!!!!!!!!!!!");
		driver.findElement(By.className("select2-search__field")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_assets_select-results\"]/li[41]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		 
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div[1]/div[2]/div")).getText();
		 
		    assertEquals(success,actual);
				
				
	}
	
	@Test
	public void failureNoAssetSelected()
	{
		//Failed run of Location Tab
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.xpath("//*[@id=\"assignto_selector\"]/div/div/label[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"assigned_location\"]/div[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_location_location_select-results\"]/li[2]/div/div[2]")).click();
		
		driver.findElement(By.id("checkout_at")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[3]/td[3]")).click();
		driver.findElement(By.id("expected_checkin")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[1]")).click();
		
		driver.findElement(By.id("note")).sendKeys("Can't wait for this sunday, Battle of Winterfell!!!!!!!!!!!!!!");
	
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		
		 String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div[1]/div[2]/div")).getText();
		 
		    assertEquals(failure,actual);
				
				
	}
	
	
	
	@Test
	public void onlyLocationNotesAssets()
	{
		//Location, Notes, and Assets are the only fields that are used.
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.xpath("//*[@id=\"assignto_selector\"]/div/div/label[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"assigned_location\"]/div[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_location_location_select-results\"]/li[2]/div/div[2]")).click();
		
		driver.findElement(By.id("note")).sendKeys("Can't wait for this sunday, Battle of Winterfell!!!!!!!!!!!!!!");
		driver.findElement(By.className("select2-search__field")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_assets_select-results\"]/li[41]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals(assetCheckoutPage,actual);
	    
	}
	
	@Test
	public void onlyLocationAndAssets()
	{
		//Location and Assets are the only fields that are used
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.xpath("//*[@id=\"assignto_selector\"]/div/div/label[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"assigned_location\"]/div[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_location_location_select-results\"]/li[2]/div/div[2]")).click();
		
		driver.findElement(By.className("select2-search__field")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_assets_select-results\"]/li[41]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();	
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
			 
	    assertEquals(assetCheckoutPage,actual);
	    

	}
	
	
	

	@Test
	public void onlyLocationNotUsed()
	{
		//Location is the only field not in use
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.xpath("//*[@id=\"assignto_selector\"]/div/div/label[3]")).click();
		driver.findElement(By.id("checkout_at")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[3]/td[3]")).click();
		driver.findElement(By.id("expected_checkin")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[1]")).click();
		
		driver.findElement(By.id("note")).sendKeys("Can't wait for this sunday, Battle of Winterfell!!!!!!!!!!!!!!");
		driver.findElement(By.className("select2-search__field")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_assets_select-results\"]/li[41]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals(assetCheckoutPage,actual);
	    
	 
	}
	
	@Test
	public void onlyLocation()
	{
		//Only the Location field is in use
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.xpath("//*[@id=\"assignto_selector\"]/div/div/label[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"assigned_location\"]/div[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_location_location_select-results\"]/li[2]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();

		
	    String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div[1]/div[2]/div")).getText();
		
	    assertEquals(failure,actual);
	}
	
	
	
	//Close Chromedriver after Test are complete
	@AfterClass
	 public static void closeBrowser(){
		 driver.quit();
	 }
	
}
