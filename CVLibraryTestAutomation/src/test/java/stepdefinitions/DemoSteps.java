package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DemoSteps {

	WebDriver driver;
	
	
	@Given("^I launch cv library application$")
	public void launchCvLibraryApplication() {
		System.out.println("Inside Main Method");
		System.setProperty("webdriver.chrome.driver","C:\\softwares\\chromedriver_win32_latest\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("After Browser Lunch");
		driver.get("https://www.cv-library.co.uk/");
		
	}
	
	@Then("^I enter job title as$")		
	public void enterJobTitle(String jobTitle) {
	WebElement job=	driver.findElement(By.xpath("//input[@id='keywords']"));
		job.click();
		job.sendKeys(jobTitle);
		
	}
	
	@Then("^I enter location as$")		
	public void enterJobLocation(String location) {
	WebElement locationLocator=	driver.findElement(By.xpath("//input[@id='location']"));
		locationLocator.click();
		locationLocator.sendKeys(location);
		
	}
	
	@Then("^I select distance as$")		
	public void selectDistance(String distanceValue) {
	WebElement diastanceLocator=driver.findElement(By.xpath("//select[@id='distance']"));
	
	Select distance = new Select(diastanceLocator);
	distance.selectByVisibleText(distanceValue);
		
	}
	
	@Then("^I click find jobs button $")		
	public void clickFindJobs() {
	WebElement FindJobsLocator=driver.findElement(By.xpath("//input[@id='hp-search-btn']"));
	FindJobsLocator.click();		
	}
	
	@Then("^I should see the search results $")		
	public void validateResults() {
	WebElement validateLocator=driver.findElement(By.xpath("//label[contains(text(),'Results Per Page:')]"));
	String expectedResult="Results Per Page";
	String actualResult=validateLocator.getText();
	Assert.assertEquals(expectedResult,actualResult);
	}
	
}
