package cp.extentreport;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentTestNGReportBuilder {
	
	protected static ExtentReports extent;
    private static ThreadLocal parentTest = new ThreadLocal();
    protected static ThreadLocal test = new ThreadLocal();
    public static ExtentTest child;

	@BeforeSuite
	public void beforeSuite() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String TempFileName=dateFormat.format(date);
		String NewFileName1=TempFileName.replace("/","_");
		String NewFileName2=NewFileName1.replace(" ","_");
		String NewFileName=NewFileName2.replace(":","_");
		System.out.println(NewFileName);
		System.out.println(System.getProperty("user.dir"));
		String extertreportname = "\\ExtentreportFiles\\extentreport-"+"extent1"+NewFileName+".html";
		System.out.println(extertreportname);
		
		extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\ExtentreportFiles\\"+"extent1.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentreportFiles\\"+NewFileName+"extent1.html");
		extent.attachReporter(htmlReporter);
	}
	
    @BeforeClass
    public synchronized void beforeClass() {
        ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
        child = ((ExtentTest) parentTest.get()).createNode(method.getName());
        test.set(child);
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)       
            ((ExtentTest) test.get()).fail(result.getThrowable());
        else if (result.getStatus() == ITestResult.SKIP)
            ((ExtentTest) test.get()).skip(result.getThrowable());
        else
            ((ExtentTest) test.get()).pass("Test passed");

        extent.flush();
    }

}
