package cp.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cp.base.Baseclass;
import cp.utilities.Util;

public class Offerspage extends Baseclass{
	List<String> List2;
	Util objutil = new Util();
	@FindBy(xpath="//h3[text()='Please enter your code']")
	WebElement OTPpopupheader;
	@FindBy(xpath="//button[@class='close']")
	WebElement OTPpopupclose;
	@FindBy(xpath="//span[text()='SELECT OFFER']")
	WebElement selectofferheader;
	@FindBy(xpath ="//li[@step-name = 'offers']")
	WebElement offerspagemenu;
	@FindBy(xpath = "//p[text()=' Unfortunately, we’re unable to generate a loan offer for you at this time.']")
	WebElement declinetxt;
	@FindBy(xpath = "//span[text()='Select Offer']")
	WebElement rightpannelselectoffer;
	@FindBy(xpath = "//span[text()='Verify Identity']")
	WebElement rightpannelverifyIdentity;
	@FindBy(xpath = "(//span[text()='Bank Information'])[1]")
	WebElement rightpannelbankinfo;
	@FindBy(xpath = "//span[text()='Income Information']")
	WebElement rightpannelincomeinfo;
	@FindBy(xpath = "//span[text()='Payment SetUp']")
	WebElement rightpannelpaymentsetup;
	@FindBy(xpath = "//span[text()='Sign Agreement']")
	WebElement rightpannelsignaggrement;
	@FindBy(xpath = "//span[text()='Upload Documents']")
	WebElement rightpanneluploaddoc;
	@FindBy(xpath = "//div[@class='lp-slider']")
	WebElement lpslider;
	@FindBy(xpath = "//div[@class='noUi-touch-area']")
	WebElement slidertouch;
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-lower']")
	WebElement lowerslider;
	@FindBy(xpath= "//div[@class='noUi-value noUi-value-vertical noUi-value-large'][3]")
	WebElement upperslider;
	
	@FindBy(xpath = "//small[text()='Loan Amount']")
	WebElement loanamounttxt;
	@FindBy(id="output")
	WebElement loanamount;
	@FindBy(xpath = "//span[text()='Select term (Months) to recalculate payments']")
	WebElement selectedtermtxt;
	@FindBy(xpath = "//input[@class='term'][1]")
	WebElement termradiobutton;
	@FindBy(xpath = "//span[text()='Payment options']")
	WebElement paymentoptiontxt;
	@FindBy(xpath = "//*[@class='paymentAmount']")
	WebElement paymentamount;
	@FindBy(xpath = "//*[@class='text-center']/following::*[text()='Monthly']")
	WebElement monthly;
	@FindBy(xpath = "//*[@class='text-center']/following::*[@class='aprPercent']")
	WebElement aprpercent;
	@FindBy(xpath = "//button[@class='btn btn-default btn-offer ladda-click']")
	WebElement selectofferbtn;
	
	@FindBy(xpath = "(//input[@name='pin'])[1]")
	WebElement otp1;
	@FindBy(xpath = "(//input[@name='pin'])[2]")
	WebElement otp2;
	@FindBy(xpath = "(//input[@name='pin'])[3]")
	WebElement otp3;
	@FindBy(xpath = "(//input[@name='pin'])[4]")
	WebElement otp4;
//	@FindBy(xpath = "//button[@class='close']")
	@FindBy(xpath = "(//span[text()='×'])[1]")
	WebElement otpboxclose;
	
//	CHOOSE OFFER NO SLIDER
	@FindBy(xpath = "(//span[text()='Choose'])[1]")
	WebElement chooseoffer;
	
	
	
	
	public Offerspage()
	{
		PageFactory.initElements(driver, this);
		List2 = Arrays.asList("Select Offer","Verify Identity","Bank Information","Income Information","Payment SetUp","Sign Agreement","Upload Documents");
	}
	
	public boolean getRightPanelvalues() throws Throwable
	{
		try {
		rightpannelselectoffer.isDisplayed();
		Util.Fn_highlight(rightpannelselectoffer);
		//rightpannelverifyIdentity.isDisplayed();
		//Util.Fn_highlight(rightpannelverifyIdentity);
		rightpannelbankinfo.isDisplayed();
		Util.Fn_highlight(rightpannelbankinfo);
		rightpannelincomeinfo.isDisplayed();
		Util.Fn_highlight(rightpannelincomeinfo);
		rightpannelpaymentsetup.isDisplayed();
		Util.Fn_highlight(rightpannelpaymentsetup);
		rightpannelsignaggrement.isDisplayed();
		Util.Fn_highlight(rightpannelsignaggrement);
		rightpanneluploaddoc.isDisplayed();
		Util.Fn_highlight(rightpanneluploaddoc);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public boolean otpbox()
	{
		try {
		otp1.sendKeys("1");
		otp2.sendKeys("2");
		otp3.sendKeys("3");
		otp4.sendKeys("4");
		Thread.sleep(2000);
		otpboxclose.click();
		return true;
		}
		catch (Exception e)
		{
			otpboxclose.click();
			return false;
		}
		
	}
	
	public boolean offerslider()
	{
		try {
			boolean flag = false;
			if (lpslider.isDisplayed())
			{
				Util.dragdrop(lowerslider,upperslider);
				flag=true;
			}
			return flag;
		}
		catch(Exception e)
		{
//			try {
//				chooseoffer.click();
//				return true;
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//				return false;
//			}
			return false;
			
		}
	}
	
	public boolean offercontainer()
	{
		try {
			loanamounttxt.isDisplayed();
			loanamount.isDisplayed();
			selectedtermtxt.isDisplayed();
			termradiobutton.isDisplayed();
			paymentoptiontxt.isDisplayed();
			paymentamount.isDisplayed();
			monthly.isDisplayed();
			aprpercent.isDisplayed();
			selectofferbtn.isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean selectOffer()
	{
		try {
			selectofferbtn.click();
			return true;
		}
		catch(Exception e)
		{
			try {
				chooseoffer.click();
				return true;
				
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
				return false;
			}
			
		}
	}
	
		 
}
