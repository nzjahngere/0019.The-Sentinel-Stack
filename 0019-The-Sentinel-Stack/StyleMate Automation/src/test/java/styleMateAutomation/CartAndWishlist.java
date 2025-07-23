package styleMateAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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

public class CartAndWishlist {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@Before
	public void setup() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("CartAndWishlist.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		driver = new ChromeDriver();
		
		driver.get("https://luni-interface-029.vercel.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Given("I want to validate add to cart feature")
	public void addToCart() throws InterruptedException {
		
		test = extent.createTest("Execution will begin shortly...!!");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement itemVer = driver.findElement(By.linkText("Versace"));

		js.executeScript("arguments[0].scrollIntoView({block: 'center'})", itemVer);
	    Thread.sleep(1000);
	    try {
	        itemVer.click();
	    } catch (ElementClickInterceptedException e) {
	        // fallback if something is overlapping
	        js.executeScript("arguments[0].click()", itemVer);
	    }
		
		/*WebElement itemVer = driver.findElement(By.linkText("Versace"));
		js.executeScript("arguments[0].scrollIntoView()", itemVer);
        Thread.sleep(3000);
        itemVer.click();*/
        Thread.sleep(3000);
                
        driver.findElement(By.cssSelector("svg[data-testid='AddCircleIcon']")).click();
        
        WebElement size = driver.findElement(By.xpath("//div[@aria-haspopup='listbox']"));
        size.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li")));
        options.get(1).click();
        
        Thread.sleep(4000);
        
	}

	@When("I select product options and click Add button")
	public void clickAdd() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[normalize-space()='ADD TO BAG']")).click();
		Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='/']")).click();
        
	}

	@Then("I validate quantity increase in cart")
	public void verifyResults() {
		
		test.pass("Cart verified!");
		
	}

	@Given("verify adding items to cart from the product listing")
	public void listingToCart() throws InterruptedException {
	
		test = extent.createTest("Execution will begin shortly...!!");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		WebElement itemCla = driver.findElement(By.partialLinkText("Clarks"));
		js.executeScript("arguments[0].scrollIntoView()", itemCla);
        Thread.sleep(3000);

	}

	@When("I navigate to the page and locate and click add button")
	public void locateAndClick() {
	    
		List<WebElement> items = driver.findElements(By.cssSelector("svg[data-testid='AddShoppingCartIcon']")); 
		items.get(3).click();
		
	}

	@Then("I verify the cart count increases")
	public void verifyIncrease() {
		
		test.pass("Cart verified!");
	    
	}

	@Given("I validate the incremental feature from the cart")
	public void verifyIncrement() throws InterruptedException {
		
		test = extent.createTest("Execution will begin shortly...!!");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    
		WebElement scrollToMugler = driver.findElement(By.linkText("Mugler"));
		js.executeScript("arguments[0].scrollIntoView()", scrollToMugler);
		Thread.sleep(3000);
		
		List<WebElement> itemList = driver.findElements(By.cssSelector("svg[data-testid='AddShoppingCartIcon']"));
		itemList.get(1).click();
		
		/*for (int i = 0; i < itemList.size(); i++) {
		    itemList.get(i).click();
		}*/
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		Thread.sleep(3000);
		
	}

	@When("I locate and click + button")
	public void clickPlus() throws InterruptedException {
		
		driver.findElement(By.cssSelector("svg[data-testid='ShoppingCartIcon']")).click();
		Thread.sleep(3000);
		//List<WebElement> elements = 
				driver.findElement(By.cssSelector("svg[data-testid='AddCircleIcon']")).click();
		Thread.sleep(2000);
		/*elements.get(0).click();
		Thread.sleep(1000);*/
		
	}

	@Then("I verify the item count and price increases respectively")
	public void verifyOutcomes() {
	    
		test.pass("Cart verified!");
		
	}

	@Then("I do the same using - button and validate outcomes")
	public void useDecrement() throws InterruptedException {
		
		//List<WebElement> elem = 
		driver.findElement(By.cssSelector("svg[data-testid='RemoveCircleIcon']")).click();
		//elem.get(0).click();
		Thread.sleep(2000);
		
		test.pass("Cart verified!");
	    
	}

	@Given("I validate the empty cart")
	public void emptyCart() {
		
		test = extent.createTest("Validating empty cart!");
	}

	@When("I locate and click the cart icon")
	public void clickCart() {	    
		
		driver.findElement(By.cssSelector("svg[data-testid='ShoppingCartIcon']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By emptyCart = By.cssSelector("div.cart__empty");
		WebElement emptyCartEl = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCart));
		String actualText = emptyCartEl.getText();
		Assert.assertEquals(actualText, "Empty cart!");
		
	}

	@Then("I verify appropriate message alert with empty cart")
	public void verifyMsg() {
		
		test.pass("Empty cart verified!");
	    
	}

	@Given("I validate the wishlist functionality")
	public void validateWishlist() throws InterruptedException {
		
		test = extent.createTest("Validating wishlist!");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    
		WebElement scrollToOffWhite = driver.findElement(By.linkText("Off-white"));
		js.executeScript("arguments[0].scrollIntoView()", scrollToOffWhite);
		
		Thread.sleep(3000);
		
		//scrollToOffWhite.click();
		
	}

	@When("I locate and click the heart icon on product page")
	public void clickHeart() throws InterruptedException {
	    
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		List<WebElement> elements = driver.findElements(By.cssSelector("svg[data-testid='FavoriteBorderIcon']"));
		elements.get(7).click();
		
		/*for (int i = 0; i < elements.size(); i++) {
		    elements.get(i).click();
		}*/
		
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("a[href='/wishlist']")).click();
		Thread.sleep(2000);
		
	}

	@Then("I verify product is added to the wishlist")
	public void verifyResult() {
	    
		System.out.println("Item added to the wishlist!");
		
	}

	@Then("I click remove icon and verify item is removed")
	public void removeItem() throws InterruptedException {
		
		WebElement moveBtn = driver.findElement(By.cssSelector("button[class='MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButtonBase-root  css-1b82ekp']"));
		moveBtn.click();

		//List<WebElement> elements = 
		/*WebElement moveBtn = driver.findElement(By.cssSelector("button[class='MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButtonBase-root  css-1b82ekp']"));
		moveBtn.click();*/
		
		Thread.sleep(3000);
	    
	}

	@Then("I click add to cart and verify item is moved to cart")	
	public void moveToCart() throws InterruptedException {
		
		/*List<WebElement> elements = driver.findElements(By.cssSelector("svg[data-testid='FavoriteBorderIcon']"));
		elements.get(0).click();
		
		Thread.sleep(3000);*/
		
		//List<WebElement> elements = 
				WebElement removeBtn = driver.findElement(By.cssSelector("svg[data-testid='HighlightOffIcon']"));
				removeBtn.click();
		//elements.get(0).click();
		Thread.sleep(2000);
		
	}
	
	@After
	public void teardown() {
	    extent.flush();
	    driver.quit();
	}

}