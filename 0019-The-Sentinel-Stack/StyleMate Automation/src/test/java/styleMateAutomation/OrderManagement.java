package styleMateAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderManagement {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@Before
	public void setup() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("OrderManagementReport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		driver = new ChromeDriver();
		
		driver.get("https://luni-interface-029.vercel.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Given("I want to test the order management")
	public void createTest() {
		
		test = extent.createTest("Execution will begin shortly...!!");
		
	}

	@When("I navigate and locate order status section")
	public void runTest() throws InterruptedException {
		
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    
			WebElement scrollToTrack = driver.findElement(By.linkText("Track your order"));
			js.executeScript("arguments[0].scrollIntoView()", scrollToTrack);
			Thread.sleep(2000);
			
			driver.findElement(By.linkText("Track your order")).click();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(3000);
		
	}

	@Then("I verify detalils and test tracking functionality")
	public void endTest() {
	    
		test.fail("The link is not clickable");
		System.out.println("The link is not clickable");
		
	}
	
	@After
	public void teardown() {
	    extent.flush();
	    driver.quit();
	}
	
}
