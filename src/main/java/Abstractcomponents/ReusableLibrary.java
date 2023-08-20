package Abstractcomponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.Checkout;
import pageobjects.Orderhistorypage;

public class ReusableLibrary {
	
	WebDriver driver;
	WebDriverWait w;
	 
	
	
	 public ReusableLibrary(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
		 w=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	 @FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	 WebElement cartele;
	 
	 @FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	 WebElement myorders;
	 
	public void visibilityofele(By findBy)
	 {
		w=new WebDriverWait(driver,Duration.ofSeconds(10));
		 w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	 }
	
	public void invisibilityofele(By findBy)
	 {
		w=new WebDriverWait(driver,Duration.ofSeconds(10));
		 w.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	 }
	
	public void visibilityofwebele(WebElement ele)
	 {
		w=new WebDriverWait(driver,Duration.ofSeconds(10));
		 w.until(ExpectedConditions.visibilityOf(ele));
	 }
	
	
	public Checkout cart()
	{
		cartele.click();
		Checkout checkout=new Checkout(driver);
		return checkout;
	}
	
	
	public Orderhistorypage myorder()
	{
		myorders.click();
		Orderhistorypage histrypage=new Orderhistorypage(driver);
		return histrypage;
		
		
	}
	 
	 
	
	
}
