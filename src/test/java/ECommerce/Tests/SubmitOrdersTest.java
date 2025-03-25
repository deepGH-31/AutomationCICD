package ECommerce.Tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce.CartPage;
import ECommerce.CheckoutPage;
import ECommerce.Confirmationpage;
import ECommerce.LandingPage;
import ECommerce.OrderPage;
import ECommerce.ProductCatalogue;
import ECommerce.TestComponent.BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class SubmitOrdersTest extends BaseTest{
	
	String countryName = "Indonesia";
    
	//method2
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrders(HashMap<String,String> input) throws IOException {
		
		
		ProductCatalogue productCatalogue=landingPage.loginUser(input.get("email"), input.get("password"));
		CartPage cartPage=productCatalogue.addProductToCart(input.get("prodName"));
		CheckoutPage checkoutPage = cartPage.clkCheckoutBtn(input.get("prodName"));
		checkoutPage.selectcountry(countryName);
		Confirmationpage confirmationPage = checkoutPage.submitBtn();
		String confMsg=confirmationPage.verifyConfMsg();
		
		AssertJUnit.assertTrue(confMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		}
	@Test(dependsOnMethods= {"submitOrders"})
	
	public void orderHistoryTest()
	{
		String prodName = "ADIDAS ORIGINAL";
		ProductCatalogue productCatalogue=landingPage.loginUser("deepfw@gmail.com", "deepFW@1");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Boolean orderFound = orderPage.verifyOrders(prodName);
		Assert.assertTrue(orderFound);
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//ECommerce//Data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}

}
//method1
	/*@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrders(String email,String password,String prodName) throws IOException {
		
		
		
		
		ProductCatalogue productCatalogue=landingPage.loginUser(email,password);
		CartPage cartPage=productCatalogue.addProductToCart(prodName);
		CheckoutPage checkoutPage = cartPage.clkCheckoutBtn(prodName);
		checkoutPage.selectcountry(countryName);
		Confirmationpage confirmationPage = checkoutPage.submitBtn();
		String confMsg=confirmationPage.verifyConfMsg();
		
		AssertJUnit.assertTrue(confMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		}*/

//method1
	/*@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"deepfw@gmail.com","deepFW@1","ADIDAS ORIGINAL"}, {"deepfw4@gmail.com","deepFW@4","ZARA COAT 3"}};
	}*/
	
	//method2
	/*@DataProvider
	public Object[][] getData()
	{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "deepfw@gmail.com");
		map.put("password","deepFW@1");
		map.put("prodName", "ADIDAS ORIGINAL");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "deepfw4@gmail.com");
		map1.put("password", "deepFW@4");
		map1.put("prodName", "ZARA COAT 3");
		
		return new Object[][] {{map},{map1}};
	}*/
