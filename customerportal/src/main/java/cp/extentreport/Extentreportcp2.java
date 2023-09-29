package cp.extentreport;

//import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Extentreportcp2  implements IReporter {
//	private ThreadLocal<ExtentTest> parentTest;
//    private ThreadLocal<ExtentTest> test;
//
//    @BeforeClass
//    public synchronized void beforeClass() {
//        ExtentTest parent = ExtentTestManager.createTest(getClass().getName());
//        parentTest.set(parent);
//    }
//
//    @BeforeMethod
//    public synchronized void beforeMethod(Method method) {
//        ExtentTest child = parentTest.get().createNode(method.getName());
//        test.set(child);
//    }
//
//    @AfterMethod
//    public synchronized void afterMethod(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE)
//            test.get().fail(result.getThrowable());
//        else if (result.getStatus() == ITestResult.SKIP)
//            test.get().skip(result.getThrowable());
//        else
//            test.get().pass("Test passed");
//
//        ExtentManager.getExtent().flush();
//    }
	}

	

	
