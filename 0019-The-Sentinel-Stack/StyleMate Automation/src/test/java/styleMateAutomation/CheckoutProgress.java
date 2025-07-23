package styleMateAutomation;

import java.time.Duration;
import java.util.List;

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

public class CheckoutProgress {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@Before
	public void setup() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("CheckoutFeatureReport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		driver = new ChromeDriver();
		
		driver.get("https://luni-interface-029.vercel.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Given("I want to test the checkout process")
	public void createTest() {
		
		test = extent.createTest("Execution will begin shortly...!!");
	    
	}

	@When("I navigate to the cart page with items")
	public void runTest() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    
		WebElement scrollToAdidas = driver.findElement(By.partialLinkText("Adidas"));
		js.executeScript("arguments[0].scrollIntoView()", scrollToAdidas);
		Thread.sleep(3000);
		
		List<WebElement> itemList = driver.findElements(By.cssSelector("svg[data-testid='AddShoppingCartIcon']"));
		itemList.get(7).click();
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		Thread.sleep(3000);
	    
	}

	@Then("I click checkout button and verify details")
	public void endTest() throws InterruptedException {
	    
		driver.findElement(By.cssSelector("svg[data-testid='ShoppingCartIcon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[class='MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButtonBase-root  css-79xub']")).click();
		Thread.sleep(2000);
		
	}
	
	@After
	public void teardown() {
	    extent.flush();
	    driver.quit();
	}
	
}
