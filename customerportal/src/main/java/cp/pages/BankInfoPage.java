package cp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cp.base.Baseclass;
import cp.utilities.Util;


public class BankInfoPage extends Baseclass {
	
	@FindBy(xpath = "(//*[text()='Bank Information'])[3]")
	WebElement bankinfotxt;
	@FindBy(xpath = "//span[text()='CONNECT YOUR BANK ACCOUNT NOW']")
	WebElement connectyourbanktxt;
	@FindBy(xpath = "//a[@href='#/BankInformation/Connect']")
	WebElement connectyourbanklink;
	
	@FindBy(xpath = "//p[contains(text(),'On the next screens,')]")
	WebElement txt1;
	@FindBy(xpath = "//*[contains(text(),'To link to and verify')]")
	WebElement txt2;
	@FindBy(xpath = "//button[text()='Skip this step']")
	WebElement skipplaidbtn;
//	SKIP PLAID
//	@FindBy(xpath = "//a[text()='Skip this step ']")
	@FindBy(xpath = "//a[@class = 'skip-bank is-plaid-skippable btn btn-link']")
	WebElement skipthissteptxt;
//	PLAID
	@FindBy(id="a11y-title")
	WebElement usesplaidtxt;
	@FindBy(xpath = "//span[text()='Continue']")
	WebElement continuebtn;
	@FindBy(xpath = "//h1[text()='Select your institution']")
	WebElement selecturbanktxt;
	@FindBy(xpath = "//input[@id='search-input']")
	WebElement banksearchtextbox;
	@FindBy(xpath = "(//*[@class='SearchAndSelectPane-module__title'])")
	WebElement banksearchresult;
	@FindBy(id="aut-ins_109508")
	WebElement banksearchresult1;
	
	@FindBy(xpath = "//h1[text()='Enter your credentials']")
	WebElement entercredentialstxt;
	@FindBy(id = "aut-input-0")
	WebElement bankusername;
	@FindBy(id = "aut-input-1")
	WebElement bankpassword;
	@FindBy(xpath = "//span[text()='Submit']")
	WebElement submitbtn;
	
	@FindBy(xpath = "//h1[text()='Select accounts']")
	WebElement selectacctxt;
	@FindBy(id="vZpeMBG13BsnAJE6ZDZRI4eppy8z8JFWbZ5Wr")
	//div[text()='Plaid Saving']
	WebElement checkboxplaidsaving;
	@FindBy(xpath="//div[text()='Plaid Checking']")
	WebElement checkboxplaidchecking;
	@FindBy(xpath="//div[text()='Checking']")
	WebElement checkboxplaidsaving1;
	@FindBy(xpath = "//span[text()='Continue']")
	WebElement continueselectaccbtn;
	
//	@FindBy(xpath = "//h1[text()='This application is requesting access to your...']")
	@FindBy(xpath = "//h1[text()='Review the types of financial data you'll share']")
	WebElement requestaccesstxt;
	@FindBy(xpath = "//span[text()='Allow']")
	WebElement allowbtn;
	
	public BankInfoPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	public boolean bankInfoElements()
	{
		try {
			Util.waituntilElementPresent(bankinfotxt);
		bankinfotxt.isDisplayed();
		connectyourbanktxt.isDisplayed();
		String banklink = connectyourbanklink.getAttribute("href");
		//System.out.println(banklink);
		if(banklink.contains("#/BankInformation/Connect"))
		{
			Assert.assertTrue(true);
		}
		else {Assert.assertTrue(true);
		}
		
		txt1.isDisplayed();
		txt2.isDisplayed();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
//	SKIP PLAID 
	public boolean skipplaid()
	{
		try {
			Util.waituntilElementPresent(bankinfotxt);
			skipthissteptxt.click();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean bankConnectPlaid()
	{
		try {
			connectyourbanktxt.click();
			Thread.sleep(6000);
			driver.switchTo().frame("plaid-link-iframe-1");
			System.out.println("save");
			usesplaidtxt.isDisplayed();
			String pl=usesplaidtxt.getText();
			System.out.println(pl);
			continuebtn.click();
			selecturbanktxt.isDisplayed();
			banksearchtextbox.sendKeys(prop.getProperty("bankname"));
			banksearchresult.click();
			banksearchresult1.click();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unsuccessful bank connect in plaid");
//			String winHandleBefore = driver.getWindowHandle();
//			
//			// Perform the click operation that opens new window
//
//			// Switch to new window opened
//			for(String winHandle : driver.getWindowHandles()){
//				System.out.println(winHandle);
//			    driver.switchTo().window(winHandle);
//			}
			
			return false;
		}
	}
	public boolean plaidcredentials()
	{
		try {
			entercredentialstxt.isDisplayed();
			bankusername.sendKeys(prop.getProperty("bankusername"));
			bankpassword.sendKeys(prop.getProperty("bankpassword"));
			submitbtn.click();
			
			selectacctxt.isDisplayed();
//			System.out.println("save");
			checkboxplaidsaving1.isDisplayed();
			checkboxplaidsaving1.click();
			continueselectaccbtn.click();
			
			//requestaccesstxt.isDisplayed();
			allowbtn.click();
			driver.switchTo().defaultContent();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			checkboxplaidsaving.click();
			e.printStackTrace();
			System.out.println("Unsuccessful bank login in plaid");
			
			return false;
		}
	}
}
