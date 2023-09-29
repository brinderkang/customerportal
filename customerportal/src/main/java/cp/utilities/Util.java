package cp.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.ITestResult;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void getwebelementlist(String ele)
	{
		driver.findElements(By.xpath(ele));
	}
	public void selectdropdown(WebElement ele,String val)
	{
		Select se= new Select(ele);
//		se.selectByVisibleText(val);
		se.selectByValue(val);
	}
	
	public static void selectddByVisibleText(WebElement element,String txtvalue)
	{
		Select objselect=new Select(element);
		objselect.selectByVisibleText(txtvalue);
	}
	
	public static void getDropdownValue(List<WebElement> listele, String actualVal)
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
	public static void getelementlist(List<WebElement> listele)
	{
		List<WebElement> listele1 = new ArrayList<>();
		for(WebElement ele:listele)
		{			
			listele1.add(ele);			
		}
		System.out.println(listele1);
		//return listele;
	}
	
	public static void waituntilElementClickable(WebElement element)
	{
		WebDriverWait wait;
		wait =new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waituntilElementPresent(WebElement element)
	{
		WebDriverWait wait;
		wait =new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waituntilElementDisappear(WebElement element)
	{
		WebDriverWait wait;
		wait =new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static void scrollpage(WebElement element)
	{
		JavascriptExecutor je =(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public String truncatedecimal(String data)
	{
		try {
			int st = (data.substring(data.indexOf("."))).length();
			System.out.println(st);
			if((data.substring(data.indexOf(".")).length()>2))
			{
				return data;
			}
			else {
			String exceldata = data.substring(0, data.indexOf("."));
			return exceldata;
			}
		} catch (Exception e) {
			return data;
		}
	}
	
	// To Highlight Elements using javascript
		public static void Fn_highlight(WebElement vObj) throws Throwable{
				
				for (int i=1 ; i<2;i++){
					((JavascriptExecutor) driver).executeScript("arguments[0].style.border= '10px solid yellow';", vObj);
					Thread.sleep(300);
					((JavascriptExecutor)driver).executeScript("arguments[0].style.border= '10px solid black';", vObj);
					
					}
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border= 'none';", vObj);
		}
		
//		DRAG and DROP
		public static void dragdrop(WebElement From, WebElement To)
		{
			//Using Action class for drag and drop.		
	         Actions act=new Actions(driver);					

		//Dragged and dropped.		
	         act.dragAndDrop(From, To).build().perform();	
		}
		
//		RANDOM NUMBER
		public static int randomnumber(int digits)
		{
			Random rand = new Random();
			  
	        // Generate random integers in range 0 to 9999
	        int rand_int1 = rand.nextInt(digits);
	        return rand_int1;
		}
		
//		RANDOM ALPHABETS
		public static String randomalphabets(int length)
		{
			String generatedString = "test"+RandomStringUtils.randomAlphabetic(length);
	        //System.out.println(generatedString.toLowerCase());
			return generatedString.toLowerCase();
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
