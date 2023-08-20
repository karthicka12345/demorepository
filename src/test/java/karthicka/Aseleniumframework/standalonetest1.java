package karthicka.Aseleniumframework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Checkout;
import pageobjects.Confirmationpage;
import pageobjects.Login;
import pageobjects.ProductsPage;
import pageobjects.shipment;

public class standalonetest1 extends BaseTest
{
@Test
public void maintest() throws IOException
	{
		
		
		
	     Login login=launchapplication();
		 ProductsPage productpage=new ProductsPage(driver);
		 List<WebElement> productslist= productpage.productlist();
		 WebElement prod=productpage.selectproduct("ZARA COAT 3");
		 productpage.addcart("ZARA COAT 3");
		 productpage.cart();
     		 
		 Checkout checkout=new Checkout(driver);
		 Boolean match=checkout.checkoutlist("ZARA COAT 3");
		 Assert.assertTrue(match);
		 checkout.checkoutbutton();
	     
		 Confirmationpage cp= new Confirmationpage(driver);
		 cp.selectcountry("india");
		 
		 shipment s=new shipment(driver);
		 String msg=s.confirmation();
		 Assert.assertEquals("THANKYOU FOR THE ORDER.", msg);
		
		
		
		 
		
		 
		   
	}

   
}
