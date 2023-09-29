package cp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import cp.base.Baseclass;
import cp.utilities.Util;

public class PaymentSetupPage extends Baseclass {
	
	@FindBy(xpath="//span[text()='Please select your Autopay preference']")
	WebElement hdrautopayinfo;
	@FindBy(xpath = "//span[text()='Its easy, convenient and always on-time.']")
	WebElement txt1;
	
	@FindBy(xpath = "//label[@data-value='ACH']")
	WebElement bankaccountchkbox;
	@FindBy(xpath = "//label[@data-value='Debit Card']")
	WebElement debitcardchkbox;
	@FindBy(xpath = "//label[@data-value='Certified Check']")
	WebElement otherchkbox;
	
	@FindBy(xpath = "//*[@class='bank-control']")
	WebElement paymentfreqlbl;
	@FindBy(xpath = "//div[@class='spanBankName bank-control']")
	WebElement banknamelbl;
	@FindBy(xpath = "//div[@class='spanRoutingNumber bank-control']")
	WebElement routingnumberlbl;
	@FindBy(xpath = "//div[@class='spanAccountNumber bank-control']")
	WebElement accountnumberlbl;
	
	@FindBy(xpath = "//div[contains(text(),'Your monthly loan payment will be deducted automatically on its due date from the account ')]")
	WebElement txt2;
	
	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextbtn;
	
	public String repaymentOption ="ACH";
	
	
	
	
	FirstPaymentPage objfirstpaymentpage;
	
	public PaymentSetupPage()
	{
		PageFactory.initElements(driver, this);
		objfirstpaymentpage=new FirstPaymentPage();
	}
	
	public boolean paymentSetupTexts()
	{
		try {
				hdrautopayinfo.isDisplayed();
				txt1.isDisplayed();
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean repaymentInfo() throws InterruptedException
	{
		try {
			
		
		if((repaymentOption).equalsIgnoreCase("ACH"))
		{
			bankaccountchkbox.isSelected();
		}
		else if((repaymentOption).equalsIgnoreCase("Debit Card"))
		{
			debitcardchkbox.isSelected();
		}
		else if((repaymentOption).equalsIgnoreCase("Other"))
		{
			otherchkbox.isSelected();
		}
		
		(paymentfreqlbl.getText()).equalsIgnoreCase("Monthly");
		(banknamelbl.getText()).equalsIgnoreCase(prop.getProperty("bankname"));
		(routingnumberlbl.getText()).contains(prop.getProperty("routingnumber"));
		(accountnumberlbl.getText()).contains(prop.getProperty("accountnumber"));
		Thread.sleep(2000);
		nextbtn.click();
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Repayment Unsuccessful");
			return false;
		}
		
	}
	
	

}
