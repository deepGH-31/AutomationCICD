package ECommerce.stepDefinitions;

import java.io.IOException;

import org.testng.AssertJUnit;

import ECommerce.CartPage;
import ECommerce.CheckoutPage;
import ECommerce.Confirmationpage;
import ECommerce.LandingPage;
import ECommerce.ProductCatalogue;
import ECommerce.TestComponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImp extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;
	public Confirmationpage confirmationPage;
	
	@Given("I landed on ECommerce Page")
	
	public void I_landed_on_ECommerce_Page() throws IOException
	{
		landingPage = launchApplication();
	}
	
	@Given("^Logged in with userName (.+) and Password (.+)$")
	
	public void Logged_in_userName_Password(String userName, String password)
	{
		productCatalogue =landingPage.loginUser(userName, password);
	}
	
	 @When("^I add product (.+) to cart$")
	 public void I_Add_product_To_Cart(String prodName)
	 {
		 cartPage = productCatalogue.addProductToCart(prodName);
	 }
	 
	 @When("^Checkout (.+) and submit the order$")
	 public void Checkout_and_Submit_the_order(String prodName)
	 {
		 checkoutPage = cartPage.clkCheckoutBtn(prodName);
			checkoutPage.selectcountry("Indonesia");
			 confirmationPage = checkoutPage.submitBtn();
	 }
	 
	 @Then("{string} message is displayed on the ConfirmationPage")
	 public void message_is_displayed_on_the_ConfirmationPage(String string)
	 {
		 String confMsg=confirmationPage.verifyConfMsg();
			
			AssertJUnit.assertTrue(confMsg.equalsIgnoreCase(string));
			
	 }

}
