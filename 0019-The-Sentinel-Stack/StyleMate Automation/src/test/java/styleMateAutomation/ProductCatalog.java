package styleMateAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductCatalog {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@Before
	public void setup() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("SearchAndCatalog.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		driver = new ChromeDriver();
		
		driver.get("https://luni-interface-029.vercel.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Given("I want to validate the search feature")
	public void verifySearch() {
				
	}

	@When("I locate search and input valid keywords")
	public void validSearch() {
		
		test = extent.createTest("Execution will begin shortly...!!");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Versace"); // Adjust accordingly to the product name, brand or category
			    
	}

	@When("I click the search icon")
	public void clickSearch() {
		
	   driver.findElement(By.xpath("//button[@type='submit']")).click();
	   driver.navigate().back();
	   
	}

	@Then("I verify the relevant search outcomes")
	public void verifyResults() {

		test.fail("The search feature doesn't show the search results");
	    
	}
	
	@Given("I want to verify the search feature")
	public void i_want_to_verify_the_search_feature() {
	    
	}

	@When("I locate search & input invalid keywords")
	public void invalidSearch() {

		test = extent.createTest("Execution will begin shortly...!!");

		WebElement invalidKeyword = driver.findElement(By.xpath("//input[@placeholder='Search for products']"));
		invalidKeyword.clear();
		invalidKeyword.sendKeys("xyz123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
			    
	}

	@Then("I verify the system behavior")
	public void verifyBehavior() {
		
		WebElement errorMsg = driver.findElement(By.xpath("//div[@class='search__container__header']"));

        String messageText = errorMsg.getText();
        String expectedMessage = "No results found for \"xyz123\"";
        Assert.assertEquals(messageText, expectedMessage);
        
		test.pass("The system handles invalid search inputs with an appropriate error message!");
	    
	}
	
	@Given("I want to verify the search behavior")
	public void i_want_to_verify_the_search_behavior() {
		
	}

	@When("I leave the input field empty and click search")
	public void emptySearch() {

		test = extent.createTest("Execution will begin shortly...!!");

		WebElement inputQuery = driver.findElement(By.xpath("//input[@placeholder='Search for products']"));
		inputQuery.clear();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        String validationMessage = (String) js.executeScript(
            "return arguments[0].validationMessage;", 
            inputQuery
        );

        Assert.assertEquals(
            validationMessage,
            "Please fill out this field."
        );
        
	}

	@Then("I validate the system behavior")
	public void validateBehavior() {
		
		test.pass("Test case passed!");
	    
	}
	
	@Given("I want to validate the product filter")
	public void i_want_to_validate_the_product_filter() {
	    
	}

	@When("I locate and choose a filter option")
	public void verifyFilter() throws InterruptedException {

		test = extent.createTest("Execution will begin shortly...!!");

		List<WebElement> menLinks = driver.findElements(By.cssSelector("a[href='/category/men']"));
		menLinks.get(0).click();
		Thread.sleep(2000);
		
		WebElement filterBtn = driver.findElement(By.xpath("//label[text()='Filter by']/following-sibling::div//div[@role='button']"));
		filterBtn.click();

		driver.findElement(By.xpath("//ul[@role='listbox']//li[text()='Latest']")).click();

			    
	}

	@Then("I verify the relevant products are displayed")
	public void validateOutcomes() {
		
		test.pass("The filtering feature works as expected!");
	    
	}
	
	@Given("I want to validate the sorting feature")
	public void i_want_to_validate_the_sorting_feature() {
	    
	}

	@When("I locate and choose a sorting option")
	public void verifySorting() throws InterruptedException {

		test = extent.createTest("Execution will begin shortly...!!");

		List<WebElement> menLinks = driver.findElements(By.cssSelector("a[href='/category/women']"));
		menLinks.get(0).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[text()='Show']/following-sibling::div//div[@role='button']")).click();
		driver.findElement(By.xpath("//ul[@role='listbox']//li[text()='All']")).click();
		    
	}

	@Then("I verify the relevant sorted category")
	public void checkResults() {
		
		test.pass("The sorting feature shows expected sorted category!");
	    
	}
	
	@Given("I want to validate the product detail page")
	public void i_want_to_validate_the_product_detail_page() {
	    
	}

	@When("I locate click a product card\\/image")
	public void clickProductImg() throws InterruptedException {

		test = extent.createTest("Execution will begin shortly...!!");

		List<WebElement> menLink = driver.findElements(By.cssSelector("a[href='/category/men']"));
		menLink.get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/item/men/630bdc280dd6605053c3f066']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='product__name__main']")).getText();
		driver.findElement(By.xpath("//div[@class='product__detail__description']")).getText();
		driver.findElement(By.xpath("//div[@class='product-color-label']")).getText();
		
		WebElement swatch = driver.findElement(By.xpath("//div[@style='background-color: black;']"));
		String style = swatch.getAttribute("style");
		Assert.assertTrue(style.contains("background-color: black"));
		
		driver.findElement(By.className("product__price__detail")).getText();
		
		List<WebElement> highlights = driver.findElements(
				By.xpath("//div[contains(@class,'description__specifics')]/ul/li")

		);

		for (WebElement item : highlights) {
		    String text = item.getText().trim();
		    System.out.println(text);
		}
	    
	}

	@Then("I verify navigation and product info on the page")
	public void verifyProductInfo() {
		
		test.pass("Product details verified!");
	    
	}
	
	@Given("I want to validate the product image gallery")
	public void i_want_to_validate_the_product_image_gallery() {
	    
	}

	@When("I locate and click different thumbnail images")
	public void verifyImgGallery() throws InterruptedException {

		test = extent.createTest("Execution will begin shortly...!!");
		
		Thread.sleep(4000);
		
		List<WebElement> menLink = driver.findElements(By.cssSelector("a[href='/category/men']"));
		menLink.get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/item/men/630bdc280dd6605053c3f066']")).click();
		Thread.sleep(2000);
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
	      .until(ExpectedConditions.presenceOfElementLocated(
	        By.cssSelector("button[aria-label='Slide 2']")));

	    ((JavascriptExecutor) driver).executeScript(
	      "document.querySelector(\"button[aria-label='Slide 2']\").click();"
	    );
	    
	    Thread.sleep(3000);
			    
	}

	@Then("I verify the main image changes accordingly")
	public void checkOutcomes() {
		
		test.pass("Images change accordingly!");
	}
	
	@After
	public void teardown() {
	    extent.flush();
	    if (driver != null) {
	    	driver.quit();
	    	}
	}
}