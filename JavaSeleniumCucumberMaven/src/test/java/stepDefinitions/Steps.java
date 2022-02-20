package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class Steps {

	public WebDriver driver;
	public LoginPage loginPage;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@Given("the user opens {string}")
	public void the_user_opens(String url) {
		driver.get(url);
	}

	@When("the user enters {string}, {string}, {string}, {string}")
	public void the_user_enters(String org, String loc, String user, String pass) {
		loginPage = new LoginPage(driver);
		loginPage.login(org, loc, user, pass);
	}

	@Then("^the user is in ([a-zA-Z]{1,}) page$")
	public void the_user_is_in_page(String page) {
		driver.getCurrentUrl();
		driver.getTitle();
		System.out.println(driver.getCurrentUrl() + "**************"+ driver.getTitle());
		if(page.equals("dashboard"))
		Assert.assertEquals("EP CORE | Console",driver.getTitle());
		else if(page.equals("login"))
		Assert.assertEquals("EP-CORE | Login",driver.getTitle());
	}
	
	@Given("dataTableTest")
	public void data_table_test(DataTable dataTable) {
		List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
		System.out.println(data.get(0));    //{Name=JJ, Age=30}
		System.out.println(data.get(1));    // {Name=JK, Age=6}
	}

	
	@After
	public void closeBrowser() {
		driver.close();
	}
	
	
}
