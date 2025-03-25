package ECommerce;

import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import ECommerce.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> prodList;
	
	@FindBy(css=".totalRow button")
	WebElement chkOutBtn;
	
	//List<WebElement> prodIncart = driver.findElements(By.cssSelector(".cartSection h3"));
	
	public List<WebElement> prodListCartPage(String prodname)
	{
		return prodList;
	}
	
	public Boolean verifyProdInCartPage(String prodname)
	{
		goToCartPage();
		boolean flag = false;
		//List<WebElement> prodInCart = prodListCartPage(prodname);
		System.out.println(prodList.size());
		for(int i=0;i<prodList.size();i++)
		{
			if(prodList.get(i).getText().contains(prodname))
			{
				flag = true;
				break;
			
			} 
			
		}
		return flag;
	}
	
	public CheckoutPage clkCheckoutBtn(String prodname)
	{
		Boolean match = verifyProdInCartPage(prodname);
		if(match==true)
		{
			chkOutBtn.click();
		}
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	
}
