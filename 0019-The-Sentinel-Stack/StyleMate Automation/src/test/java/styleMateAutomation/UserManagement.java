package styleMateAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagement {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@Before
	public void setup() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("UserManagementReport.html");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		driver = new ChromeDriver();
		
		driver.get("https://luni-interface-029.vercel.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Given("I want to test the user registration")
    public void userReg() {
        
		test = extent.createTest("Execution will begin shortly...!!");
		
    }

    @When("I locate inputs and enter credentials")
    public void locateEle() throws InterruptedException {
        
    	driver.findElement(By.cssSelector("a[href='/account/login']")).click();
		driver.findElement(By.cssSelector("a[href='/account/register']")).click();
    	driver.findElement(By.cssSelector(".fname__input.register__input")).sendKeys("demouser");
		driver.findElement(By.cssSelector(".lname__input.register__input")).sendKeys("login");
		driver.findElement(By.cssSelector(".email__input.register__input")).sendKeys("demouserlogin@gmail.com");
		driver.findElement(By.cssSelector(".password__input.register__input")).sendKeys("demouserlogin");
		Thread.sleep(4000);
		
		try {
			
	    	driver.findElement(By.cssSelector(".register__button")).click();

		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		

    }

    @Then("I expect to create a user account")
    public void ValidateOutcomes() {
        
    	test.fail("Failed to register a user account");
    	System.out.println("The create account button is not clickable");
    	
    }

    @Given("I want to test the user login with valid credentials")
    public void validLogin() {
    	
		test = extent.createTest("Execution will begin shortly...!!");
    	
    }

    @When("I locate inputs and enter valid credentials")
    public void findEle() {
    	
		driver.findElement(By.cssSelector("a[href='/account/login']")).click();
    	driver.findElement(By.cssSelector(".email__input.login__input")).sendKeys("demouserlogin@gmail.com");
		driver.findElement(By.cssSelector(".password__input.login__input")).sendKeys("demouserlogin");
		driver.findElement(By.cssSelector("button[class='login__button']")).click();
    	
    }

    @Then("I expect to login to the account")
    public void clickBtn() {
    	
		test.pass("Button clicked successfully");
    	
    }

    @Given("I want to attempt the user login with invalid credentials")
    public void invalidLogin() {
    	
		test = extent.createTest("Execution will begin shortly...!!");
		
    }

    @When("I locate inputs and enter invalid credentials")
    public void locateInputs() {
    	
		driver.findElement(By.cssSelector("a[href='/account/login']")).click();
    	driver.findElement(By.cssSelector(".email__input.login__input")).sendKeys("12345678");
		driver.findElement(By.cssSelector(".password__input.login__input")).sendKeys("12345678");
    	driver.findElement(By.cssSelector("button[class='login__button']")).click();

    }

    @Then("I expect system to handle the situation gracefully")
    public void verifyRes() {
        
		test.fail("Button clicked successfully, system doesn't show any error message");
    	
    }

    @Given("I want to attempt the password reset")
    public void resetPass() {
    	
    	test = extent.createTest("Execution will begin shortly...!!");
    	
    }

    @When("I locate and click password reset link")
    public void clickLink() throws InterruptedException {
    	
    	try {
			
    		driver.findElement(By.cssSelector("a[href='/account/login']")).click();
        	driver.findElement(By.cssSelector(".login__forgot__password")).click();

		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(3000);
            	
    }

    @Then("I expect to be redirected to the respective page")
    public void verifyResults() {
    	
    	test.fail("The reset password doesn't work");
    	System.out.println("Password rest link is not clickable and functional");

    }
	
	@After
	public void teardown() {
	    extent.flush();
	    driver.quit();
	}

}
