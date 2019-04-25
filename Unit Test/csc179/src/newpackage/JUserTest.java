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
/*JUnit test cases for User method located on https://demo.snipeitapp.com/hardware/bulkcheckout
 * Note: Some test cases here are behave the same in all methods. Therefore they are
 * redundant and only need to be tested on once. User is the method 
 * that will test these rather than the other two, Asset and Location.  
 *
 * 
 * Redundant test cases are:
 * onlyExpectedCheckin()
 * onlyCheckOutDate()
 * onlyCheckout()
 * onlyCancel()
 * CheckInOutAssets()
 * onlyNotesEnterd()
 * onlyAssetsChoosen()
 * bothCheckInCheckOut()
 * 
 */
public class JUserTest {
	//variables
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
		//initialize
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ilike\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://demo.snipeitapp.com/login");
		driver.findElement(By.className("form-control")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.className("box-footer")).click();
	
	}
	@Test
	public void userCheckoutSuccess()
	{
		//sucessful run of user checking out
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.className("select2")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_user_select-results\"]/li[5]/div/div[2]")).click();

		driver.findElement(By.id("checkout_at")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[3]/td[3]")).click();
		driver.findElement(By.id("expected_checkin")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[1]")).click();
		
		driver.findElement(By.id("note")).sendKeys("Gonna use this laptop to mine some bitcoin. Probably only get .0000000000000000000001 bitcoin but ya");
		driver.findElement(By.className("select2-search__field")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_assets_select-results\"]/li[41]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
	    String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div[1]/div[2]/div")).getText();
			 
	    assertEquals(success,actual);
			
			
		
	}

	@Test
	public void userCheckoutFailed()
	{
		//run failure of user checking out
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.className("select2")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_user_select-results\"]/li[5]/div/div[2]")).click();

		driver.findElement(By.id("checkout_at")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[3]/td[3]")).click();
		driver.findElement(By.id("expected_checkin")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[1]")).click();
		
		driver.findElement(By.id("note")).sendKeys("Gonna use this laptop to mine some bitcoin. Probably only get .0000000000000000000001 bitcoin but ya");
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		

		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div[1]/div[2]/div")).getText();
		 
		 assertEquals(failure,actual);
	    
	}
	
	@Test
	public void onlyUserNotUsed()
	{
		//User not selected, rest of the fields are
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.id("checkout_at")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[3]/td[3]")).click();
		driver.findElement(By.id("expected_checkin")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[1]")).click();
		
		driver.findElement(By.id("note")).sendKeys("Gonna use this laptop to mine some bitcoin. Probably only get .0000000000000000000001 bitcoin but ya");
		driver.findElement(By.className("select2-search__field")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_assets_select-results\"]/li[41]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals(assetCheckoutPage,actual);
	    
	 
	}
	
	@Test
	public void onlyUser()
	{
		//User is the only element selected
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.className("select2")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_user_select-results\"]/li[5]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();

		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals("Checkout Assets",actual);
	}
	
	@Test
	public void onlyCheckoutDate()
	{
		//Only the checkout date box is selected
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.id("checkout_at")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[3]/td[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals(assetCheckoutPage,actual);
		    
	}
	
	@Test
	public void onlyCheckIn()
	{
		//Only the Expected Checkin date is selected
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.id("expected_checkin")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals(assetCheckoutPage,actual);
	}
	
	@Test
	public void onlyNotesEntered()
	{
		//Notes is the only field selected and entered
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.id("note")).sendKeys("Gonna use this laptop to mine some bitcoin. Probably only get .0000000000000000000001 bitcoin but ya");
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals(assetCheckoutPage,actual);
	}
	
	@Test
	public void onlyCheckInCheckOut()
	{
		//Only the Check in and Check out date fields are selected
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.id("checkout_at")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[3]/td[3]")).click();
		driver.findElement(By.id("expected_checkin")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals(assetCheckoutPage,actual);
	    
	}
	
	@Test
	public void onlyUserAndAssets()
	{
		//Only User and an Asset are selected
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.className("select2")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_user_select-results\"]/li[5]/div/div[2]")).click();
		driver.findElement(By.className("select2-search__field")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_assets_select-results\"]/li[41]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
			 
	    assertEquals(assetCheckoutPage,actual);
	    

	}
	
	@Test
	public void onlyCheckout()
	{
		//Nothing is selected, try to checkout
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals(assetCheckoutPage,actual);

	}
	
	@Test
	public void onlyCheckInCheckOutAssets()
	{
		//Both Check in, Check out, and Asset Fields are selected
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.id("checkout_at")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[3]/td[3]")).click();
		driver.findElement(By.id("expected_checkin")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[1]")).click();
		driver.findElement(By.className("select2-search__field")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_assets_select-results\"]/li[41]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals(assetCheckoutPage,actual);
	}
	
	@Test
	public void onlyCancel()
	{
		//Only the Cancel button will be selected
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/a")).click();
		  String actual = driver.getCurrentUrl();
			 
		    assertEquals("https://demo.snipeitapp.com/",actual);
		    
	}
	
	@Test
	public void onlyUserNotesAsset()
	{
		//Only Users, Notes, and Asset fields will be used
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.className("select2")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_user_select-results\"]/li[5]/div/div[2]")).click();
		driver.findElement(By.id("note")).sendKeys("Gonna use this laptop to mine some bitcoin. Probably only get .0000000000000000000001 bitcoin but ya");
		driver.findElement(By.className("select2-search__field")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_assets_select-results\"]/li[41]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals(assetCheckoutPage,actual);
	    
	}
	@Test 
	public void onlyAssetsChoosen()
	{
		//Only Asset field will be selected
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.className("select2-search__field")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_assets_select-results\"]/li[41]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals(assetCheckoutPage,actual);
	    
	}
	public void onlyUserNotes()
	{
		//User and Notes Field are selected only
		driver.get("https://demo.snipeitapp.com/");
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.className("select2")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_user_select-results\"]/li[5]/div/div[2]")).click();
		driver.findElement(By.id("note")).sendKeys("Gonna use this laptop to mine some bitcoin. Probably only get .0000000000000000000001 bitcoin but ya");
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[1]/h1")).getText();
		 
	    assertEquals(assetCheckoutPage,actual);
	
	}
	
	//Close Chromedriver after Test are complete
	@AfterClass
	 public static void closeBrowser(){
		 driver.quit();
	 }
	
	
	

	
	
}