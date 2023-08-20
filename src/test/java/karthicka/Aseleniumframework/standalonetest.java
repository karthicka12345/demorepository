package karthicka.Aseleniumframework;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.Checkout;
import pageobjects.Confirmationpage;
import pageobjects.Orderhistorypage;
import pageobjects.ProductsPage;
import pageobjects.shipment;

public class standalonetest extends BaseTest
{
	@Test(dataProvider="getdata",groups={"purchase"})
	public void maintest(HashMap<String,String> input) throws IOException
		{
	   
	
		 ProductsPage productpage=login.launch(input.get("email"),input.get("password"));
		
		 List<WebElement> productslist= productpage.productlist();
		 WebElement prod=productpage.selectproduct(input.get("product"));
		 productpage.addcart(input.get("product"));
		 Checkout checkout=productpage.cart();
		 
		
		 Boolean match=checkout.checkoutlist(input.get("product"));
		 Assert.assertTrue(match);
		 Confirmationpage cp=checkout.checkoutbutton();
	     
		
		 shipment s=cp.selectcountry("india");
		 
		
		 String msg=s.confirmation();
		 Assert.assertEquals("THANKYOU FOR THE ORDER.", msg);
		
		 }

	@Test(dependsOnMethods={"maintest()"})
   public void orderhistory()
   {
	 login.launch("karthickatest@gmail.com","July$123");
	 Orderhistorypage histrypage= login.myorder();
	 Boolean listmatch=histrypage.orders("ZARA COAT 3");
	 Assert.assertTrue(listmatch);
	
	
	 
   }
	
	/*@DataProvider
	public Object[][] getdata()
	{
		
		return new Object[][]{{"karthickatest@gmail.com","July$123","ZARA COAT 3"},{"sathieshtest@gmail.com","Aug$1234","ZARA COAT 3"}};
	}
	*/
	/*@DataProvider
	public Object[][] getdata()
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("email","karthickatest@gmail.com");
		map.put("password","July$123");
		map.put("product","ZARA COAT 3");
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email","sathieshtest@gmail.com");
		map1.put("password","Aug$1234");
		map1.put("product","ZARA COAT 3");
		return new Object[][] {{map},{map1}};
		
		
				
	}*/
	
	@DataProvider
	public Object[][] getdata() throws IOException
	{
		List<HashMap<String, String>> data=getjsondataTohashmap(System.getProperty("user.dir")+"//src//test//java//data//purchaseorder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
				
	}
	
	
}
