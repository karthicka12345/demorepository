package pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.ReusableLibrary;

public class Checkout extends ReusableLibrary
{
	WebDriver driver;
	
	public Checkout(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> checkproducts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutbtn;
	
	 public Boolean checkoutlist(String prodname)
	 {
		 Boolean match=checkproducts.stream().anyMatch(c->c.getText().equals(prodname));
		 return match;
	 }
	 
	 public Confirmationpage checkoutbutton() 
	 {
		 
		 checkoutbtn.click();
		 Confirmationpage cp= new Confirmationpage(driver);
		 return cp;
		
	 }

}
