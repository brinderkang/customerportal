package cp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cp.base.Baseclass;

public class FirstPaymentPage extends Baseclass {
	@FindBy(xpath="//div[text()='How do you want to make your first payment?']")
	WebElement hdrfirstpayment;
	
	@FindBy(xpath="//input[@value='bankAccount']")
	WebElement radiobankaccount;
	
	@FindBy(xpath="//input[@value='debitCard']")
	WebElement radiodebitcard;
	
	@FindBy(xpath="//input[@value='creditCard']")
	WebElement radioother;
	@FindBy(xpath="//input[@formcontrolname='paymentFreq']")
	WebElement paymentfrequency;
	@FindBy(id="preferredDate")
	WebElement firstpaymentdate;
	@FindBy(name="bankName")
	WebElement bankname;
	@FindBy(name="accountNumber")
	WebElement accountnumber;
	@FindBy(name="routingNumber")
	WebElement routingNumber;
	@FindBy(id="oneTimePayment")
	WebElement enrollinautopay;
	@FindBy(xpath="//button[text()=' Continue ']")
	WebElement btncontinue;

}
