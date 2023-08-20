package testcomponents;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTestngg {
	
	
	public static ExtentReports extentReptestng()
	{
		
		File file=new File(System.getProperty("user.dir") + "//reports//index.html");
		ExtentSparkReporter reporter=new ExtentSparkReporter(file);
		reporter.config().setReportName("web automation");
		reporter.config().setDocumentTitle("Reports");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester","karthicka");
		return extent;
		
		
	}

}
