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


public class SearchWithInvalidPostalCode {

	
	 WebDriver driver;
	 
	 @Before() public void setup() throws IOException {
	 System.setProperty("webdriver.chrome.driver",Paths.get(System.getProperty("user.dir")).toRealPath() +
	 "\\src\\test\\java\\JustEatUK\\JustEat\\resources\\chromedriver.exe");
	 this.driver = new ChromeDriver(); this.driver.manage().window().maximize();
	 this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	 
	  }
	  
	 @After() public void tearDown() { driver.manage().deleteAllCookies();
	 driver.quit(); }
	 

	@Given("^user navigates to the website \"([^\"]*)\"$")
	public void user_navigates_to_the_website(String arg1) throws Throwable {
		driver.get(arg1);

	}

	@When("^user want food with \"([^\"]*)\"$")
	public void user_want_food_with(String arg1) throws Throwable {
		
		WebElement postCode = driver.findElement(By.xpath("//input[@name='postcode']"));
		postCode.sendKeys(arg1);

	}

	@When("^user perform search for restaurants$")
	public void user_perform_search_for_restaurants() throws Throwable {
		
		driver.findElement(By.className("Form_c-search-btn_2cjDI")).submit();
	}

	@Then("^user should see appropriate error message \"([^\"]*)\"$")
	public void user_should_see_appropriate_error_message(String arg1) throws Throwable {
		
		String actualError = driver.findElement(By.xpath("//div[@id='errorMessage']")).getText();
		Assert.assertEquals(actualError, arg1);
		
	}

}
