package cp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cp.base.Baseclass;
import cp.utilities.Util;

public class Tilapage extends Baseclass{
	
	@FindBy(xpath = "//span[text()=\"YOU’RE ALMOST DONE\"]")
	WebElement tilahdr;
	@FindBy(xpath = "//span[contains(text(),'Please confirm your loan details, complete the electronic records consent, and sign your loan agreement.')]")
	WebElement txt1;
	@FindBy(xpath = "//div[contains(text(),'FEDERAL TRUTH-IN-LENDING DISCLOSURES')]")
	WebElement federalTILAtxt;
	
	@FindBy(xpath = "//th[contains(text(),'Total of payments')]")
	WebElement totalpaymenttxt;
	@FindBy(xpath = "//td[contains(text(),'The amount you will have paid after you have made all payments as scheduled.')]")
	WebElement totalpaymenttxt1;
	@FindBy(xpath = "(//td[@class='number'])[1]")
	WebElement totalpayment;
	
	@FindBy(xpath = "//th[contains(text(),'Amount financed')]")
	WebElement amountfinancedtxt;
	@FindBy(xpath = "//td[contains(text(),'The amount of credit provided to you or on your behalf.')]")
	WebElement amountfinancedtxt1;
	@FindBy(xpath = "(//td[@class='number'])[2]")
	WebElement amountfinanced;
	
	@FindBy(xpath = "//th[contains(text(),'Finance charge')]")
	WebElement financechargetxt;
	@FindBy(xpath = "//td[contains(text(),'The dollar amount the credit will cost you.')]")
	WebElement financechargetxt1;
	@FindBy(xpath = "(//td[@class='number'])[3]")
	WebElement financecharge;
	
	@FindBy(xpath = "//th[contains(text(),'Annual percentage rate')]")
	WebElement annualpercentratetxt;
	@FindBy(xpath = "//td[contains(text(),'The cost of your credit as a yearly rate.')]")
	WebElement annualpercentratetxt1;
	@FindBy(xpath = "(//td[@class='number'])[4]")
	WebElement annualpercentrate;
	
	@FindBy(xpath = "//th[contains(text(),'Number of payments')]")
	WebElement numberofpaymentstxt;
	@FindBy(xpath = "(//td[@class='number'])[5]")
	WebElement numberofpayments;
	
	@FindBy(xpath = "//th[contains(text(),'Amount of payments')]")
	WebElement paymentamounttxt;
	@FindBy(xpath = "(//td[@class='number'])[6]")
	WebElement paymentamount;
	
	@FindBy(xpath = "//th[contains(text(),'When payments are due')]")
	WebElement paymentduetxt;
	@FindBy(xpath = "//span[contains(text(),'MONTHLY')]")
	WebElement paymentfrequency;
	@FindBy(xpath = "//span[contains(text(),'Beginning 30 days from date of funding.')]")
	WebElement paymentdatetxt;
	
	@FindBy(xpath = "(//table[@class='lp-table lp-payment-box'])[4]/thead/tr[1]/th[1]")
	WebElement itemizationhrd;
	@FindBy(xpath = "(//table[@class='lp-table lp-payment-box'])[4]/tbody/tr[2]/td[2]")
	WebElement amountgiventoyou;
	@FindBy(xpath = "(//table[@class='lp-table lp-payment-box'])[4]/tbody/tr[3]/td[2]")
	WebElement amountpaidwithus;
	@FindBy(xpath = "(//table[@class='lp-table lp-payment-box'])[4]/tbody/tr[4]/td[2]")
	WebElement amountpaidonyourbehalf;
	@FindBy(xpath = "(//table[@class='lp-table lp-payment-box'])[4]/tbody/tr[5]/td[2]")
	WebElement amountfinanced1;
	@FindBy(xpath = "(//table[@class='lp-table lp-payment-box'])[4]/tbody/tr[6]/td[2]")
	WebElement prepaidfinancecharge;
	@FindBy(xpath = "(//table[@class='lp-table lp-payment-box'])[4]/tbody/tr[7]/td[1]")
	WebElement amountdisclosedtxt;
	
	@FindBy(xpath = "(//table[@class='lp-table lp-payment-box'])[5]/tbody/tr[1]/td[1]")
	WebElement licensingbank;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	WebElement consentcheckbox1;
	@FindBy(xpath = "//*[contains(text(),' By clicking the box, you agree that you have reviewed and agree to the ')]")
	WebElement consenttext1;
	@FindBy(xpath = "//a[contains(text(),'CONSENT TO ELECTRONIC COMMUNICATIONS')]")
	WebElement consentlinktxt;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement consentcheckbox2;
	@FindBy(xpath = "//*[contains(text(),'By clicking the box, you agree (1) that you have reviewed and agree to the terms set forth in the ')]")
	WebElement agreementtxt1;
	@FindBy(xpath = "//*[@text='contract.numbers']")
	WebElement contractnumber;
	@FindBy(xpath = "(//a[contains(text(),'LOAN AGREEMENT')])[1]")
	WebElement loanagreementtxt;
	
	@FindBy(xpath = "//span[@id = 'sign-container']")
	WebElement signature;
	@FindBy(xpath = "//*[contains(text(),'Your above signature will be placed on the Consent to Electronic Communications and LOAN AGREEMENT and the documents will be emailed to you after you click the below “SIGN LOAN AGREEMENT & CONSENT TO ELECTRONIC COMMUNICATIONS” button.')]")
	WebElement signconsent;
	
	@FindBy(xpath = "//div[@text='contract.review']")
	WebElement reviewcontract;
	
	@FindBy(xpath = "//*[@request='Sending']")
	WebElement signcontractbtn;
	
	
	public Tilapage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyConsentChkbox1()
	{
		try {
			Util.waituntilElementClickable(consentcheckbox1);
			consentcheckbox1.click();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean verifyConsentChkbox2()
	{
		try {
			consentcheckbox2.click();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean verifySignContractBtn()
	{
		try {
			signcontractbtn.click();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

}
