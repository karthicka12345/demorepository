package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abstractcomponents.ReusableLibrary;

public class ProductsPage extends ReusableLibrary
{
	
WebDriver driver;
	
	public ProductsPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	By productslistload=By.cssSelector(".mb-3");
	By producttext=By.tagName("b");
	By addtocartbtn=By.xpath("//button[text()=' Add To Cart']");
	By toast=By.id("toast-container");
	By spinner=By.className("ng-animated");
	
	@FindBy(css=".mb-3")
	List<WebElement> productslist;
	
	public List<WebElement> productlist()
	{
		visibilityofele(productslistload);
		return productslist;
	}
	
			
	public WebElement selectproduct(String prodname)
	{
		WebElement prod=productslist.stream().
		 filter(list->list.findElement(producttext).getText().equals(prodname)).findFirst().orElse(null);
		return prod;
	}
	
	public void addcart(String prodname)
	{
		 selectproduct(prodname).findElement(addtocartbtn).click();
		 visibilityofele(toast);
		 invisibilityofele(spinner);
	}



}
