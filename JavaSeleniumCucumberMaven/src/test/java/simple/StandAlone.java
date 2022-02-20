package simple;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class StandAlone {

	public static void main(String args[]) throws WebDriverException, IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.co.uk/");
		driver.findElement(By.id("sp-cc-accept")).click();

		WebElement e = driver.findElement(By.id("twotabsearchtextbox"));

		Actions myActions = new Actions(driver);
		Action listOfAction = myActions.moveToElement(e).click().keyDown(Keys.SHIFT).sendKeys("jay").keyUp(Keys.SHIFT).doubleClick()
				.contextClick().build();
		listOfAction.perform();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		File output = new File(".//screenshot/a.png");
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE), output);
		
		
		driver.close();

	}

}
