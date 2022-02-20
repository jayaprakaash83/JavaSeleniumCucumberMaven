package cucumberTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//		features = {".//features/Login.feature"},
//		features = {".//features/Login.feature", ".//features/another.feature"},   //runnung multiple features
		features = ".//features/", // executes all feature files under the specified folder
		glue = "stepDefinitions",
		dryRun = false,
		plugin = { "pretty", "html:reports/cucumber-report/results.html" },
//		tags = "@smoke or @regression",
//		tags = "@smoke and not @regression",
//		tags = "@smoke and @regression",
//		tags = "@smoke",
		monochrome = true)

public class Runner {

}
