package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.ReusableLibrary;

public class Login extends ReusableLibrary
{
	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	 @FindBy(id="userEmail")
	 WebElement useremail;
	 
	 @FindBy(id="userPassword")
	 WebElement password;
	 
	 @FindBy(name="login")
	 WebElement submit;
	 
	 @FindBy(css="[class*='flyInOut']")
		WebElement errormsg;
	 
	 public ProductsPage launch(String email,String pwd)
	 {
		 useremail.sendKeys(email);
		 password.sendKeys(pwd);
		 submit.click();
		 ProductsPage productpage=new ProductsPage(driver);
		 return productpage;
	 }
	 
	 public void goTo()
	 {
		 System.out.println("launched");
		 driver.get("https://rahulshettyacademy.com/client");
	 }
	 
	 public String getmsg()
	 {
		 visibilityofwebele(errormsg);
		 String message=errormsg.getText();
		 return message;
	 }

}
