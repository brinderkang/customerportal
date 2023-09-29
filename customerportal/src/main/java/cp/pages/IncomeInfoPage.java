package cp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cp.base.Baseclass;
import cp.utilities.Util;

public class IncomeInfoPage extends Baseclass {
	
	@FindBy(xpath = "(//span[text()='Income Information'])[2]")
	WebElement incomeinfohdr;
	@FindBy(xpath = "//div[@class='userInfo']")
	WebElement userinfotxt;
	@FindBy(xpath = "//label[@data-value='Employee']")
	WebElement employeechkbox;
	@FindBy(xpath = "//label[@data-value='Self Employed']")
	WebElement selfemployeechkbox;
	@FindBy(xpath = "//label[@data-value='Other']")
	WebElement otherchkbox;
	
	@FindBy(name="employerName")
	WebElement companynameinput;
	@FindBy(id="employerPhone")
	WebElement workphoneinput;
	@FindBy(name="workEmailAddress")
	WebElement workemailinput;
	@FindBy(name="jobTitle")
	WebElement positioninput;
	@FindBy(name="startDate")
	WebElement startdateinput;
	@FindBy(xpath = "//span[text()='next']")
	WebElement nextbtn;


	
	public IncomeInfoPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean incomeInfotexts()
	{
		try {
			Util.waituntilElementPresent(incomeinfohdr);
			incomeinfohdr.isDisplayed();
			userinfotxt.isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public boolean Incomedetails()
	{
		try {
			if((Applynow2.emptype).equalsIgnoreCase("Employee"))
			{
				employeechkbox.isSelected();
			}
			else if((Applynow2.emptype).equalsIgnoreCase("Self Employed"))
			{
				selfemployeechkbox.isSelected();
			}
			else if((Applynow2.emptype).equalsIgnoreCase("Other"))
			{
				otherchkbox.isSelected();
			}
			
			
			companynameinput.sendKeys(prop.getProperty("companyname"));
			workphoneinput.sendKeys(prop.getProperty("workphone"));
			workemailinput.sendKeys(prop.getProperty("workemail"));
			positioninput.sendKeys(prop.getProperty("position"));
			startdateinput.sendKeys(prop.getProperty("startdate"));
			nextbtn.click();
			return true;
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Unsuccessful income details");
			return false;
		}
	}

}
