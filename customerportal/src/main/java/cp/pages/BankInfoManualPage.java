package cp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cp.base.Baseclass;
import cp.utilities.Util;


public class BankInfoManualPage extends Baseclass {
	
	@FindBy(xpath = "(//*[text()='BANK INFORMATION']")
	WebElement bankinfohdr;
	@FindBy(xpath = "//p[contains(text(),'Please enter the bank account details where you would like us to deposit the loan proceeds. You can get the proceeds as soon as the next business day upon loan approval.')]")
	WebElement txt1;
	@FindBy(xpath = "//*[text()='Upload voided check']")
	WebElement uploadcheckbtn;
	@FindBy(xpath = "//*[text()='Or manually enter your bank information below']")
	WebElement txt2;
	@FindBy(name= "bankName")
	WebElement banknameinput;
	@FindBy(name= "routingNumber")
	WebElement routingnumberinput;
	@FindBy(name= "confirmRouting")
	WebElement confirmroutinginput;
	@FindBy(name= "accountNumber")
	WebElement accountnumberinput;
	@FindBy(name= "confirmAccount")
	WebElement confirmaccountinput;
	@FindBy(xpath = "//img[contains(@src,'check.png')]")
	WebElement samplecardimg;
	@FindBy(xpath = "//span[text()='next']")
	WebElement nextbtn;

	

	public BankInfoManualPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	public boolean bankInfotexts()
	{
		try {
			Util.waituntilElementPresent(bankinfohdr);
			bankinfohdr.isDisplayed();
			txt1.isDisplayed();
			txt2.isDisplayed();
			uploadcheckbtn.isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public boolean bankdetails()
	{
		try {
			
			banknameinput.sendKeys(prop.getProperty("bankname"));
			routingnumberinput.sendKeys(prop.getProperty("routingnumber"));
			confirmroutinginput.sendKeys(prop.getProperty("routingnumber"));
			accountnumberinput.sendKeys(prop.getProperty("accountnumber"));
			confirmaccountinput.sendKeys(prop.getProperty("accountnumber"));
			samplecardimg.isDisplayed();
			Thread.sleep(3000);
			nextbtn.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unsuccessful Enter bank details manually");
			return false;
		}
	}

}
