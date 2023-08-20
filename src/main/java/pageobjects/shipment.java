package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.ReusableLibrary;

public class shipment extends ReusableLibrary  {
	
	WebDriver driver;
	public shipment(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="hero-primary")
	WebElement confirmtext;
	
	public String confirmation()
	{
		String msg=confirmtext.getText();
		return msg;
	}

}
