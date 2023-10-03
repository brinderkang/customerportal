package cp.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cp.base.Baseclass;
import cp.utilities.Util;
import cp.utilities.Xlreader;

public class Applynow extends Baseclass{
	
	Xlreader objxlread =new Xlreader("C:\\Users\\brinderjeet.singh\\git\\customerportal\\customerportal\\src\\main\\java\\cp\\testData\\Testdata.xlsx");
//	Xlreader objxlread =new Xlreader(System.getProperty("user.dir")+"/src/main/java/cp/testData/Testdata.xlsx");
	
//	Xlreader obj1xlread =new Xlreader();
	Util objutil = new Util();
	
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
	
	@FindBy(id="google-addres")
	WebElement address1;
	@FindBy(id="unit")
	WebElement address2;
	@FindBy(id="postal_code")
	WebElement zipcode;
	@FindBy(id="state")
	WebElement stateDD;
	@FindBy(id="locality")
	WebElement city;
	
	@FindBy(id="annualIncome")
	WebElement annualincome;
	@FindBy(name="ss3")
	WebElement ssn3;
	@FindBy(id="ss1")
	WebElement ssn1;
	@FindBy(name="ss2")
	WebElement ssn2;
	
	String loanamt;
	
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
		
		int rowcount = Xlreader.getRowCount("testmain");
		int rownumber = 0;
		for(int r=0;r<=rowcount;r++)
		{
			String rowON = Xlreader.getCellData("testmain", r, "Run");
			if(rowON.equalsIgnoreCase("on"))
			{
				rownumber = r;
			}
		}
		try {
		for(int i=1;i<Xlreader.getCellCount("testmain", 0);i++)
		{
			String column_name=Xlreader.getCellData("testmain", 0, i);
			String cell_data=Xlreader.getCellData("testmain", rownumber, i);
//			System.out.println(column_name.toLowerCase());
			System.out.println(cell_data+ " ");
			switch(column_name.toLowerCase())
			{
			case "loanamount":
				loanamount.sendKeys(cell_data);
				break;
			case "loanpurpose":
				objutil.selectdropdown(loanpurposeDD, cell_data);
				break;
			case "fname":
				firstname.sendKeys(cell_data);
				break;
			case "lname":
				lastname.sendKeys(cell_data);
			break;
			case "dob":
				dob.sendKeys("02/28/1975");
			break;
			case "phone":
				phonenumber.sendKeys(cell_data);
			break;
			case "email":
				email.sendKeys(cell_data);
			break;
			case "address":
				address1.sendKeys(cell_data);
			break;
			case "unit":
				address2.sendKeys(cell_data);
			break;
			case "zipcode":
				zipcode.sendKeys(cell_data);
				Thread.sleep(3000);
			break;
			case "state":
				objutil.selectdropdown(stateDD, cell_data);
				//stateDD.sendKeys(cell_data);
			break;
			case "city":
				city.sendKeys(cell_data);
			break;
			case "annualincome":
				annualincome.sendKeys(cell_data);
			break;
			case "ssn1":
				ssn1.sendKeys(cell_data);
			break;
			case "ssn2":
				ssn2.sendKeys(cell_data);
			break;
			case "ssn3":
				ssn3.sendKeys(cell_data);
			break;
//			default:
//				System.out.println("Invalid Column");
			}
		}
//		String loanamt=String.valueOf(Xlreader.getCellData("testmain", 1, "Loanamount"));
//		loanamount.sendKeys(loanamt);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
