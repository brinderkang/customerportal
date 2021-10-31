package cp.utilities;

import java.io.File;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
//import org.testng.ITestResult;

import cp.base.Baseclass;

public class Util extends Baseclass {
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;

	public void draganddrop(WebElement source,WebElement dest)
	{
		//Using Action class for drag and drop.		
        Actions act=new Actions(driver);					

	//Dragged and dropped.		
        act.dragAndDrop(source, dest).build().perform();
		
	}
	public void switchToFrame(int frameid)
	{
		driver.switchTo().frame(frameid);
	}
	
	public void switchToFrame(String frameid)
	{
		driver.switchTo().frame(frameid);
	}
	
	public void getDropdownValue(List<WebElement> listele, String actualVal)
	{
		for(WebElement ele:listele) 
		{
			String Val=ele.getText().trim();
			if(Val.equalsIgnoreCase(actualVal))
			{
				ele.click();
			}
		}
	}
	
	public void getDropdownInnerHTML(List<WebElement> listele, String actualVal) throws InterruptedException
	{
		for(WebElement ele:listele)
		{
			String Val=ele.getAttribute("innerHTML").trim();
			Thread.sleep(2000);
			if(Val.equalsIgnoreCase(actualVal))
			{
				ele.click();
				return;
			}
		}
	}
	
//	public void takeScreenShot(ITestResult result){
//
//		if(ITestResult.FAILURE== result.getStatus())
//		{
//		try{
//		TakesScreenshot ts= (TakesScreenshot)driver;
//
//		File source=ts.getScreenshotAs(OutputType.FILE);
//
//		//FileUtils.copyFile(src, new File("destination.png"))
//
//		FileHandler.copy(source, new File("./screenshot/"+result.getName()+".png"));
//		}
//		catch(Exception e)
//		{
//		System.out.println("Exception while taking screenshot");
//		}
//
//		}
//		}
	
//	public static void takeScreenshot() throws Exception {
//		String timeStamp;
//		File screenShotName;
//		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		//The below method will save the screen shot in d drive with name "screenshot.png"
//		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
//		screenShotName = new File("D:\\MyTest\\Screenshots\\"+timeStamp+".png");
//		FileUtils.copyFile(scrFile, screenShotName);
//		 
//		String filePath = screenShotName.toString();
//		String path = "<img src="\"file://"" alt="\"\"/" />";
//		Reporter.log(path);
//		 
//		}
	
	
	
	
}
