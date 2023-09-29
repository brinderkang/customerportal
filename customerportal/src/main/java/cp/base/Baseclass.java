package cp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import cp.extentreport.ExtentTestNGReportBuilder;
import cp.utilities.Util;

public class Baseclass extends ExtentTestNGReportBuilder {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report;
//	public static ExtentTest test;
	
	public Baseclass() {
		try {
			prop=new Properties();
			System.out.println(System.getProperty("user.dir")+"  BS");
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/cp/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void initialisation()
	{
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		if(browsername.equalsIgnoreCase("chrome"))
		{
//			System.setProperty("webdriver.chrome.driver","D:\\Brinder\\BrowserDrivers\\chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/cp/browserdrivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		if(browsername.equals("Firefox"))
		{
		System.setProperty("webdriver.geko.driver", "D:\\Brinder\\BrowserDrivers\\gekodriver.exe");
		driver=new FirefoxDriver();
		}
		if(browsername.equals("headless"))
		{
			WebDriverManager.chromedriver().setup();
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("--no-sandbox");
	        chromeOptions.addArguments("--headless");
	        chromeOptions.addArguments("disable-gpu");
	        driver=new ChromeDriver(chromeOptions);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
	}
	
	/*@BeforeSuite
	public void setUp()
	{
	    ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/test-output/extentReport.html"));
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);

	    htmlReporter.config().setChartVisibilityOnOpen(true);
	    htmlReporter.config().setDocumentTitle("Extent report");
	    htmlReporter.config().setReportName("Final Report");
	}

	@AfterMethod
	public void getResult(ITestResult result)
	{
	    if(result.getStatus() == ITestResult.FAILURE)
	    {
	        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	        test.fail(result.getThrowable());
	    }
	    else if(result.getStatus() == ITestResult.SUCCESS)
	    {
	        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	    }
	    else
	    {
	        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	        test.skip(result.getThrowable());
	    }
	}

	@AfterSuite
	public void tearDown(){
	    extent.flush();
	   }
*/
}
