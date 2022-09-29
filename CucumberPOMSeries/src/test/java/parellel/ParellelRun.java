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
		//tags = "not @Skip",
		monochrome=true,
		glue = { "parellel" },
		features = { "src/test/resources/parellel" }
		
		
		
		)

public class ParellelRun extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		
		return super.scenarios();
		
	}

}
