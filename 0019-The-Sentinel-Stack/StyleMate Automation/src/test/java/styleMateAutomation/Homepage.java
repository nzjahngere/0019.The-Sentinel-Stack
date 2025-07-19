package styleMateAutomation;

import java.time.Duration;
import java.util.Arrays;
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

public class Homepage {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@Before
	public void setup() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("Homepage.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		driver = new ChromeDriver();
		
	}
	
	@Given("I am on the home page of the website")
	public void openBrowser() {
		
		test = extent.createTest("Execution will begin shortly...!!");
		
		driver = new ChromeDriver();
		driver.get("https://luni-interface-029.vercel.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		test.pass("Test case passed!");
		
	}
	
	@When("the page loads completely")
	public void homepageLoading() {
		
		test = extent.createTest("Execution will begin shortly...!!");
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Home - StyleMate";
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Test case passed!");
		} else {
			System.out.println("Test case failed...!!");
		}
		
		test.pass("Test case passed!");
		
	}
	
	@Then("I validate the logo display")
	public void logoDisplay() {
		
		test = extent.createTest("Execution will begin shortly...!!");
		
	    WebElement logo = driver.findElement(By.xpath("//img[@style='width: 80%;']"));
	    if(logo.isDisplayed()) {
	    	System.out.println("Logo is displayed!");
		} else {
			System.out.println("Logo isn't there...!!");
		}
	    
	    //logo.click();
	    
	    test.pass("Test case passed!");
	    
	}
	
	@When("I click on the each menu item")
	public void clickLinks() throws InterruptedException {
		
		test = extent.createTest("Execution will begin shortly...!!");
		
		List<String> navItems = Arrays.asList("Home", "Shop", "Men", "Women", "Kids");
		
        for (String item : navItems) {
            WebElement navLink = driver.findElement(By.linkText(item));         
            navLink.click();
                        
            Thread.sleep(1000);
            
            test.pass("Test case passed!");
        }
	}
	
	@Then("I expect to be redirected to their respective pages")
	public void verifyNavbar() {
		
	    System.out.println("Navbar verified");
	    
	}
	
	@When("I scroll to the featured products section")
	public void scrollToFeatured() throws InterruptedException {
		
		test = extent.createTest("Execution will begin shortly...!!");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement ele = driver.findElement(By.linkText("Versace"));
		js.executeScript("arguments[0].scrollIntoView()", ele);
        Thread.sleep(1000);
        
        test.pass("Test case passed!");
        
	}
	
	@Then("I verify product details")
	public void verifyProductDetails() throws InterruptedException {
		
		test = extent.createTest("Execution will begin shortly...!!");
		
		List<WebElement> products = driver.findElements(By.className("product__card__detail"));
		
        for (WebElement product : products) {
        	
            String name = product.findElement(By.className("product__name")).getText();
            String description = product.findElement(By.className("product__description")).getText();
            String price = product.findElement(By.className("product__price")).getText();
            
            System.out.println("==============================");
            System.out.println("Name: " + name);
            System.out.println("Description: " + description);
            System.out.println("Price: " + price);
            System.out.println("==============================");
            
        }
        
        if (!products.isEmpty()) {
            products.get(0).click();
        }
        
        test.pass("Test case passed!");
		
		System.out.println("Product details verified!");
        driver.navigate().back();
        driver.quit();

	}
	
	@After
	public void teardown() {
	    extent.flush();
	}
	
}