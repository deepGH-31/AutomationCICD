package ECommerce;

import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import ECommerce.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td")
	List<WebElement> orderList;
	
	
	
	public Boolean verifyOrders(String prodName)
	{
		Boolean flag = false;
		for(int i=0;i<orderList.size();i++)
		{
			if(orderList.get(i).getText().contains(prodName)) {
				flag = true;
				break;
				
			}
			
		}
		return flag;
	}
	
	
	
	
}
