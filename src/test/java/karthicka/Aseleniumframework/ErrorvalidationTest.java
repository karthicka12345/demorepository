package karthicka.Aseleniumframework;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Checkout;
import pageobjects.Login;
import pageobjects.ProductsPage;

public class ErrorvalidationTest extends BaseTest {
	
	@Test(groups={"errorhandling"},retryAnalyzer=retry.class)
	public void incorrectlogin()
	{
		login.launch("karthickatest@gmail.com","July$");
		Assert.assertEquals("Incorrect email or password.", login.getmsg());
		
	
	}
	
	@Test
	public void productmismatch()
	{

		 ProductsPage productpage=login.launch("karthickatest@gmail.com","July$123");
		
		 List<WebElement> productslist= productpage.productlist();
		 WebElement prod=productpage.selectproduct("ZARA COAT 3");
		 productpage.addcart("ZARA COAT 3");
		 Checkout checkout=productpage.cart();
		 
		
		 Boolean match=checkout.checkoutlist("ZARA COAT 83");
		 Assert.assertFalse(match);
	}

}
