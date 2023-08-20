package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.ReusableLibrary;

public class Orderhistorypage extends ReusableLibrary 
{
	
WebDriver driver;
	
	public Orderhistorypage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover ng-star-inserted']/tbody/tr/td[2]")
	List<WebElement> orderslist;
	
	//List<WebElement> orderslist=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover ng-star-inserted']/tbody/tr/td[2]"));
	// Boolean listmatch=orderslist.stream().anyMatch(orderlist->orderlist.getText().equalsIgnoreCase("ZARA COAT 3"));
	 
	 public Boolean orders(String ordername)
	 {
		 Boolean listmatch=orderslist.stream().anyMatch(orderlist->orderlist.getText().equalsIgnoreCase(ordername));
		return listmatch;
		 
	 }

}
