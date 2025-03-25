package ECommerce.Tests;
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
import ECommerce.ProductCatalogue;
import ECommerce.TestComponent.BaseTest;
import ECommerce.TestComponent.Retry;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups= {"ErrorHandling"}/*, retryAnalyzer=Retry.class*/)
	public void loginPageErrorValidation() throws IOException {
		
		landingPage.loginUser("deepfw@gmail.com", "deepFW");
		Assert.assertEquals("Incorrect email or password.",landingPage.errorValidation());
		
		}
	
	@Test
	public void productPageErrorValidation() throws IOException {
		
		
		String prodName = "ADIDAS ORIGINAL";
		
		
		ProductCatalogue productCatalogue=landingPage.loginUser("deepfw@gmail.com", "deepFW@1");
		CartPage cartPage=productCatalogue.addProductToCart(prodName);
		Boolean match = cartPage.verifyProdInCartPage("NIKE");
		Assert.assertFalse(match);
		
		}


}
