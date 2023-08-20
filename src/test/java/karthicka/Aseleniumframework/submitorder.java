package karthicka.Aseleniumframework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class submitorder 
{
	public static void main(String[] args) throws InterruptedException 
	{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/client");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 driver.findElement(By.id("userEmail")).sendKeys("karthickatest@gmail.com");
		 driver.findElement(By.id("userPassword")).sendKeys("July$123");
		 driver.findElement(By.name("login")).click();
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		 List<WebElement> li=driver.findElements(By.cssSelector(".mb-3"));
		/* for(int i=0;i<li.size();i++)
		 {
			 String name=li.get(i).getText();
			 String[] arr=name.split("\n");
			 String item=arr[0].trim();
			 if(item.contains("ADIDAS ORIGINAL"))
			 {
				 driver.findElements(By.xpath("//button[text()=' Add To Cart']")).get(i).click();
			 }
		 }*/
		 WebElement prod= li.stream().
				 filter(list->list.findElement(By.tagName("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
				 prod.findElement(By.xpath("//button[text()=' Add To Cart']")).click();
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		 w.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ng-animated"))); 
		 driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		 List<WebElement> products=driver.findElements(By.xpath("//div/ul[@class='cartWrap ng-star-inserted']"));
		 for(WebElement pro:products)
		 {
			 if(pro.getText().contains("ADIDAS ORIGINAL"))
			 {
				 System.out.println("product present");
			 }
			 else
			 {
				 System.out.println("product not present");
			 }
		 }
		// List<WebElement> cart=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		// Boolean match=cart.stream().anyMatch(c->c.getText().equals("ADIDAS ORIGINAL"));
		 //Assert.assertTrue(true);
		 driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		 driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		
		 Thread.sleep(5000);
			List<WebElement> options=driver.findElements(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']"));
			 Thread.sleep(5000);
			for(WebElement option:options)
			{
				if(option.getText().equalsIgnoreCase("India"))
				{
					option.click();
					break;
				}
			}
			driver.findElement(By.xpath("//div[@class='actions']/a")).click();
		 
		   
	}

   
}
