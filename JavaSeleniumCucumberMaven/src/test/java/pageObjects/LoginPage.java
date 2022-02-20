package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver rdriver){
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="orgInput")
	WebElement organisation;

	@FindBy(id="locationSelect")
	WebElement location;

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")	
	WebElement password;
	
	@FindBy(xpath="//button")
	WebElement submit;
	
	
	public void login(String org, String loc, String user, String pass) {
		organisation.sendKeys(org);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(location));
		Select locationSel = new Select(location);
		locationSel.selectByVisibleText(loc);
		
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.submit();
	}
	
}
