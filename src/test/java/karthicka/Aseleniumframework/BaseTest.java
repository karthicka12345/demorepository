package karthicka.Aseleniumframework;

import org.openqa.selenium.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Login;

public class BaseTest 
{
	public WebDriver driver;
	
 public Login login;
	
	public WebDriver initialize() throws IOException
	{
	
	 
	 Properties prop=new Properties();
	 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "//src//main//java//testcomponents//Global.properties");
	 prop.load(fis);
	 //String browsername=prop.getProperty("browser");
	 String browsername=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
	
	 if(browsername.contains("chrome"))
	 {
		 WebDriverManager.chromedriver().setup();
		 ChromeOptions cp=new ChromeOptions();
		 if(browsername.contains("headless"))
				 {
		 cp.addArguments("headless");
				 }
		
		 driver=new ChromeDriver(cp);
		 driver.manage().window().setSize(new Dimension(1440,900));
		
	 }
	 else if(browsername.equalsIgnoreCase("firefox"))
	 {
		System.setProperty("webdriver.gecko.driver","gecko.exe");
	 }
	 else if(browsername.equalsIgnoreCase("edge"))
	 {
		System.setProperty("webdriver.edge.driver","C:\\Users\\Karthicka\\Downloads\\edgedriver\\msedgedriver.exe");
		driver=new EdgeDriver();
	 }
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	 driver.manage().window().maximize();
	 
	 return driver;
	}
@BeforeMethod(alwaysRun=true)
	public Login launchapplication() throws IOException
	{
		driver=initialize();
	    login=new Login(driver);
		 login.goTo();
		
		 return login;

		
	}
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		System.out.println("downloaded sucessfully");
		driver.close();
	}
	
	public List<HashMap<String, String>> getjsondataTohashmap(String filepath) throws IOException
	{
	
		String jsoncontent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
	    ObjectMapper mapper=new  ObjectMapper();
	    List<HashMap<String,String>> data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){});
	    return data;
		
	}
	
	public String getScreenshot(String testcase,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir") + "//reports//" + testcase + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testcase + ".png";
		
	}
	

}
