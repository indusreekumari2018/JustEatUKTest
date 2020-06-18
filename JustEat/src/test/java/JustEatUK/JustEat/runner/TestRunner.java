package JustEatUK.JustEat.runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/JustEatUK/JustEat/features"},
		glue= {"JustEatUK.JustEat.stepDefinitions"},
		monochrome= true,
		tags= {},
		plugin= {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
		)

public class TestRunner {

	
}
