package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.ReusableLibrary;

public class Confirmationpage extends ReusableLibrary  {
	
WebDriver driver;
	
	public Confirmationpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement Countryele;
	
	By dropdown= By.cssSelector(".ta-results");
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectitem;
	
	@FindBy(xpath="//div[@class='actions']/a")
	WebElement placeorder;
	
	public shipment selectcountry(String country)
	{
		Actions a=new Actions(driver);
		a.sendKeys(Countryele,country).build().perform();
		visibilityofele(dropdown);
		

		selectitem.click();
		placeorder.click();
		 shipment s=new shipment(driver);
		 return s;
		
	}

}
