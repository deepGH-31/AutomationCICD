package ECommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ECommerce.AbstractComponent.AbstractComponent;

public class Confirmationpage extends AbstractComponent {
	
	WebDriver driver;
	
	public Confirmationpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="h1")
	WebElement headerText;
	
	public String verifyConfMsg()
	{
		return headerText.getText();
	}

}
