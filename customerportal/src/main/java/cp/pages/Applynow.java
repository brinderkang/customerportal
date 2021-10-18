package cp.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cp.base.Baseclass;
import cp.utilities.Xlreader;

public class Applynow extends Baseclass{
	
	Xlreader objxlread =new Xlreader("D:/Brinder/PhotonWorkspace/customerportal/src/main/java/cp/testData/Testdata.xlsx");
	
//	Xlreader obj1xlread =new Xlreader();
	
//	Page Factory
	@FindBy(xpath="//img[contains(@src,'lendingpoint.svg')]")
	WebElement logo;
	@FindBy(xpath="//input[@id='loanAmount']")
	WebElement loanamount;
	
	@FindBy(xpath=("//select[@id='loanPurpose']"))
	WebElement loanpurposeDD;
	
	@FindBy(name="firstName")
	WebElement firstname;	
	@FindBy(id="lastName")
	WebElement lastname;
	@FindBy(id="dob")
	WebElement dob;
	@FindBy(id="phone")
	WebElement phonenumber;
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="street")
	WebElement address1;
	@FindBy(id="unit")
	WebElement address2;
	@FindBy(id="zip")
	WebElement zipcode;
	@FindBy(id="state")
	WebElement stateDD;
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="annualIncome")
	WebElement annualincome;
	@FindBy(id="ss3")
	WebElement ssn3;
	@FindBy(id="ss1")
	WebElement ssn1;
	@FindBy(id="ss2")
	WebElement ssn2;
	
	
	
	public Applynow()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLogo()
	{
		boolean flag=logo.isDisplayed();
		return flag;
	}
	public boolean Basic_info() throws IOException
	{
		try {
		for(int i=0;i<Xlreader.getCellCount("testmain", 0);i++)
		{
			String column_name=Xlreader.getCellData("testmain", 0, i);
			System.out.println(column_name);
		}
		String loanamt=String.valueOf(Xlreader.getCellData("testmain", 1, "Loanamount"));
		loanamount.sendKeys(loanamt);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
