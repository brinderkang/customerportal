package cp.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cp.base.Baseclass;
import cp.utilities.Util;
import cp.utilities.Xlreader;

public class Applynow2 extends Baseclass{
	
	Xlreader objxlread =new Xlreader("C:\\Users\\brinderjeet.singh\\git\\customerportal\\customerportal\\src\\main\\java\\cp\\testData\\Testdata.xlsx");
//	Xlreader objxlread =new Xlreader(System.getProperty("user.dir")+"/src/main/java/cp/testData/Testdata.xlsx");
	
//	Xlreader obj1xlread =new Xlreader();
	Util objutil = new Util();
	HashMap<String, String> map;
	public static String sfemail;
	public static String emptype;
	
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
	@FindBy(xpath="//select[@id='income-source']")
	WebElement incomesource;
	@FindBy(name="ss3")
	WebElement ssn3;
	@FindBy(id="ss1")
	WebElement ssn1;
	@FindBy(name="ss2")
	WebElement ssn2;
	@FindBy(xpath="//div[@class='load-indicator']")
	WebElement loader;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//span[text()='Check my options']")
	WebElement checkmyoptions;
	@FindBy(xpath="//p[text()='This process may take a few seconds']")
	WebElement loading;
	
	@FindBy(xpath = "//img[@class='loading-inline requestzip']")
	WebElement zipcodeloading;
	
	String loanamt;
	
	public Applynow2()
	{
		PageFactory.initElements(driver, this);
		if (!(driver.getCurrentUrl()).contains("https://testmain.lendingpoint.com/"))
		{
			driver.get("https://testmain.lendingpoint.com/apply");
		}
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
			if(loader.isDisplayed())
			{
				Thread.sleep(4000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		for(int i=1;i<Xlreader.getCellCount("testmain", 0);i++)
		{
			map = new HashMap<String, String>();
			
			String column_name=Xlreader.getCellData("testmain", 0, i);
			String cell_data=Xlreader.getCellData("testmain", rownumber, i);
			cell_data = objutil.truncatedecimal(cell_data);
			System.out.print(column_name.toLowerCase());
			System.out.println(" :  "+cell_data+ " ");
			map.put(column_name, cell_data);
			if(column_name.toLowerCase().equals("incomesource"))
			{
				emptype=cell_data;
			}
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
				int n = 1000 + new Random().nextInt(9000);
		        //System.out.println("320216"+n+"    Length of number is : "+ Integer.toString(n).length());
				cell_data= "320216"+n;
				phonenumber.sendKeys(cell_data);
			break;
			case "email":
				cell_data= "bsingh+"+Util.randomnumber(10000)+"@lendingpoint.com";
				//cell_data = Util.randomalphabets(5)+Util.randomnumber(10000)+"@lendingpoint.com";
				sfemail=cell_data;
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
				Thread.sleep(4000);
			break;
			case "state":
//				zipcode.get
				Util.waituntilElementClickable(stateDD);
				
				objutil.selectdropdown(stateDD, cell_data);
				//stateDD.sendKeys(cell_data);
			break;
			case "city":
				city.sendKeys(cell_data);
				System.out.println("City name:- "+city.getText());
				if(city.getText()== "")
				{
					System.out.println("City name :- "+city.getText());
					Thread.sleep(5000);
					city.sendKeys(cell_data);
				}
			break;
			case "annualincome":
				annualincome.sendKeys(cell_data);
			break;
			case "incomesource":
				objutil.selectdropdown(incomesource, cell_data);
			break;
			case "ssn1":
				Util.waituntilElementClickable(ssn1);
				ssn1.sendKeys(cell_data);
			break;
			case "ssn2":
				ssn2.sendKeys(cell_data);
			break;
			case "ssn3":
				ssn3.sendKeys(cell_data);
				Thread.sleep(4000);
			break;
			case "password":
				password.sendKeys(cell_data);
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
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean checkmyoptions()
	{
		Offerspage objofferpage = new Offerspage();
		try {
		Util.waituntilElementClickable(checkmyoptions);
		checkmyoptions.click();
		try 
		{
			do
			{
				Thread.sleep(10000);
			}
			while(loading.isDisplayed());
		} catch (Exception e) 
		{
			System.out.println("Loading completed");			
		}
		
		Util.waituntilElementPresent(objofferpage.offerspagemenu);
		
		if ((driver.getCurrentUrl()).contains("SelectAnOffer"))
		{
			return true;
		}
		else 
		{
			return false;
		}
		
		
		
//		if((objofferpage.offerspagemenu.isDisplayed())==true)
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
		
		}
		catch(Exception e)
		{
			try {
				boolean decline_txt=objofferpage.declinetxt.isDisplayed();
				if(decline_txt){
				System.out.println("loan declined");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			return false;
		}
		
	}

}
