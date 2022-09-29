package parellel;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.QA.factory.DriverFactory;
import com.QA.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	
	// below hook method is implemented to skip the scenarios with the tag @skip
	@Before(value = "@Skip", order = 0)
	public void skip_scenario(Scenario scenario)
	{
		System.out.println("SKIPPED SCENARIO IS: "+scenario.getName());
		Assume.assumeTrue(false);
	}
	
	
	@Before(order = 1)
	public void getProperty() {
		configreader = new ConfigReader();
		prop = configreader.init_prop();		
	}
	
	@Before(order = 2)
	public void launchBrowser() {
		String browsername = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browsername);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed())
		{
			//Take Screenshot
			String screenshotname = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotname);
		}		
	}

}
