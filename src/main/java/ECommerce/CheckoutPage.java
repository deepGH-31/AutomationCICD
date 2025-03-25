package ECommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ECommerce.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(css=".form-group .text-validated")
	WebElement countryName;
	
	@FindBy(css=".ta-results .ta-item")
	List<WebElement> countryList;
	
	@FindBy(css=".ta-item span")
	List<WebElement> chooseCountry;
	
	@FindBy(css=".action__submit")
	WebElement submitBtn;
	
	By results = By.cssSelector(".ta-results");
	public void selectcountry(String country)
	{
		countryName.sendKeys(country);
		waitForElementToAppear(results);
		for(int i=0;i<countryList.size();i++)
		{
			String name= countryList.get(i).getText();
			
			if(countryList.get(i).getText().equalsIgnoreCase(country))
			{
				
				chooseCountry.get(i).click();
				break;
			}
			
		}
	}
	
	public Confirmationpage submitBtn()
	{
		submitBtn.click();
		Confirmationpage confirmationPage = new Confirmationpage(driver);
		return confirmationPage;
	}

}
