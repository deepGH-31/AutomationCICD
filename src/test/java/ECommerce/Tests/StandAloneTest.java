package ECommerce.Tests;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String prodName = "ADIDAS ORIGINAL";
		String countryName = "Indonesia";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("deepfw@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("deepFW@1");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> prodname =driver.findElements(By.xpath("//div[@class=\"card\"]//b"));
		for(int i=0;i<=prodname.size();i++)
		{
			
			if(prodname.get(i).getText().contains("ADIDAS ORIGINAL"))
			{
				driver.findElements(By.xpath("//button[@class=\"btn w-10 rounded\"]")).get(i).click();
				break;
			}
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-custom .fa-shopping-cart")));
		
		driver.findElement(By.cssSelector("[routerlink*='cart'")).click();
		
		List<WebElement> prodIncart = driver.findElements(By.cssSelector(".cartSection h3"));
		
		for(int i=0;i<=prodIncart.size();i++)
		{
			if(prodIncart.get(i).getText().contains(prodName))
			{
				Assert.assertTrue(true);
				driver.findElement(By.cssSelector(".totalRow button")).click();
				break;
			}
			
		}
		
		driver.findElement(By.cssSelector(".form-group .text-validated")).sendKeys("ind");
		Thread.sleep(5);
		List<WebElement> countryList = driver.findElements(By.cssSelector(".ta-results .ta-item"));
		System.out.println(countryList.size());
		
		for(int i=0;i<countryList.size();i++)
		{
			String name= countryList.get(i).getText();
			System.out.println(name);
			if(countryList.get(i).getText().equalsIgnoreCase(countryName))
			{
				
				driver.findElements(By.cssSelector(".ta-item span")).get(i).click();
				break;
			}
			
		}
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("h1")).getText().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
		

	}

}
