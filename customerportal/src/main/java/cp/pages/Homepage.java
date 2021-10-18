package cp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cp.base.Baseclass;

public class Homepage extends Baseclass {
	
//	Page Factory
	@FindBy(xpath="//img[contains(@src,'lp-color.svg')]")
	WebElement logo;
	@FindBy(xpath="(//a[contains(@href,'/continue')])[3]")
	WebElement loginlink;
	@FindBy(xpath="(//a[text()='Apply'])[3]")
	WebElement applybutton;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo() 
	{
		return logo.isDisplayed();
	}
	public Applynow validateLinks() throws InterruptedException
	{
		loginlink.isDisplayed();
		loginlink.isEnabled();
		applybutton.isDisplayed();
		applybutton.isEnabled();
		applybutton.click();
//		Thread.sleep(8000);
		return new Applynow();
	}

}
