package newpackage;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class SnideTest {
	WebDriver driver;
	
	
	public static void main(String[] args) {
		//used to initialize 
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ilike\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://demo.snipeitapp.com/login");
		driver.findElement(By.className("form-control")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.className("box-footer")).click();
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		Select select;
		
		//test 1 to check the user
		//driver.findElement(By.className("dropdown-wrapper needsclick")).click();
		//driver.findElement(By.xpath("//*[@id=\"assigned_user\"]/div[1]/span/span[1]/span/span[2]"));
		//Select select = new Select(element)));
		//select.selectByValue("9");
		//select.selectByValue("9");
		//driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Nikolau");
		//driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).click();
		//driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).submit();
		//WebElement el = driver.findElement(By.id("assigned_user_select"));
	    // Select dropdown = new Select(el);
		//dropdown.selectByVisibleText("Altenwerth, Antonette (fahey.milford) - #28874");
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//WebElement element = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-text\"]")));
		//driver.findElement(By.xpath("(//input[@id='search-text'])[2]")).sendKeys("FAA");
		
		
		
		//User
		//Used to select from dropdown list
		/*driver.findElement(By.className("select2")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_user_select-results\"]/li[5]/div/div[2]")).click();

		driver.findElement(By.id("checkout_at")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[3]/td[3]")).click();
		driver.findElement(By.id("expected_checkin")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[1]")).click();
		
		driver.findElement(By.id("note")).sendKeys("Gonna use this laptop to mine some bitcoin. Probably only get .0000000000000000000001 bitcoin but ya");
		driver.findElement(By.className("select2-search__field")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_assets_select-results\"]/li[41]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		*/
		//asset
		/*driver.findElement(By.xpath("//*[@id=\"assignto_selector\"]/div/div/label[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"assigned_asset\"]/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_asset_select-results\"]/li[26]/div/div[2]")).click();
		
		driver.findElement(By.id("checkout_at")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[3]/td[3]")).click();
		driver.findElement(By.id("expected_checkin")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[5]/td[1]")).click();
		
		driver.findElement(By.id("note")).sendKeys("My bitcoin endeavor didn't work.............");
		driver.findElement(By.className("select2-search__field")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-assigned_assets_select-results\"]/li[41]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/button")).click();
		
		
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
		*/
		
		
		driver.get("https://demo.snipeitapp.com/hardware/bulkcheckout");
		driver.findElement(By.xpath("//*[@id=\"webui\"]/div/div[1]/div/div[3]/a")).click();
		
		
		
		
		
		
	}
	
	
   }


