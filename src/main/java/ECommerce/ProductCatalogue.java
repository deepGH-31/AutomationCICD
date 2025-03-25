package ECommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ECommerce.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".card-body b")
	List<WebElement> products;
	
	@FindBy(css=".card-body .fa-shopping-cart")
	List<WebElement> addToCartBtn;
	By prodBy = By.cssSelector(".mb-3");
	By toastMsg = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(prodBy);
		return products;
		
	}
	
	public WebElement getProductByName(String prodName)
	{
		List<WebElement> prodList =getProductList();
		for(int i=0;i<=prodList.size();i++)
		{
			
			if(prodList.get(i).getText().contains(prodName))
			{
				
				return addToCartBtn.get(i);
			
			}
		}
		return null;
	}
	
	public CartPage addProductToCart(String prodName)
	{
		WebElement addToCartBtnClk = getProductByName(prodName);
		addToCartBtnClk.click();
		waitForElementToDisappear(toastMsg);
		CartPage cartPage = new CartPage(driver);
		return cartPage;
		
	}
	
	
}
