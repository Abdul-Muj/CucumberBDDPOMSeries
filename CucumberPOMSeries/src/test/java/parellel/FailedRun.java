package parellel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target/failedrerun.txt"
				},
		monochrome=true,
		glue = { "parellel" },
		features = { "@target/failedrerun.txt" }
		
		
		
		)


public class FailedRun extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		
		return super.scenarios();
		
	}
	
	
}
