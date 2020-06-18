package JustEatUK.JustEat.stepDefinitions;



import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchWithValidPostalCode  {
	
		
	WebDriver driver;
	@Before()
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", Paths.get(System.getProperty("user.dir")).toRealPath() +  "\\src\\test\\java\\JustEatUK\\JustEat\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		
		
	}
	
	@After()
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	@Given("^I navigate to \"([^\"]*)\"$")
	public void i_navigate_to(String arg1) throws Throwable {
	    driver.get(arg1);
	}

	@When("^I want food in \"([^\"]*)\"$")
	public void i_want_food_in(String arg1) throws Throwable {
		WebElement postCode = driver.findElement(By.xpath("//input[@name='postcode']"));
		postCode.sendKeys(arg1);
		
	}

	@When("^I search for restaurants$")
	public void i_search_for_restaurants() throws Throwable {
	    
		driver.findElement(By.className("Form_c-search-btn_2cjDI")).submit();
	}

	@Then("^I should see some restaurants in \"([^\"]*)\"$")
	public void i_should_see_some_restaurants_in(String arg1) throws Throwable {
	    
		Thread.sleep(3000);
		String actualPostalCode = driver.findElement(By.className("c-locationHeader-container")).getText();
		
		System.out.println(actualPostalCode);
		Assert.assertTrue(actualPostalCode.contains(arg1));
			
		
	}

	

}
