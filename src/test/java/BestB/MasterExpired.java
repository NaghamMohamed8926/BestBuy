package BestB;

import static org.openqa.selenium.Keys.ENTER;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MasterExpired {
	public static WebDriver driver;
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@BeforeTest	
	public static void openbestbuy() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\work space\\Submission\\src\\test\\resources\\chromedriver.exe");
		//Print all broswer links in chromelog.txt file
		System.setProperty("webdriver.chrome.logfile", "./Chromelog.txt");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.bestbuy.com/");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

	}
	
	public static void search() throws InterruptedException, AWTException {
        	
		//Select united states country
		WebElement Unitedstates = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[2]/img[1]"));
		Unitedstates.click();
        
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		//Close popup window
		WebElement Popup = driver.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]"));
		Popup.click();
		Thread.sleep(2000);
		
		//Select ipad from suggestions 
		WebElement ipadair = driver.findElement(By.xpath("//input[@id='gh-search-input']"));
		ipadair.sendKeys("ipad");
		Thread.sleep(2000);
		//Choose ipad air 4th choice from Suggestions menu
		ipadair.sendKeys(Keys.ARROW_DOWN);
		ipadair.sendKeys(Keys.ARROW_DOWN);
		ipadair.sendKeys(Keys.ARROW_DOWN);
		ipadair.sendKeys(Keys.ARROW_DOWN);
		ipadair.sendKeys(ENTER);
		
		//Select "Exclude out of stock items" to filter online only items 
		WebElement onlineonly=driver.findElement(By.xpath("//input[@id='soldout_facet-Exclude-Out-of-Stock-Items-0']"));
		onlineonly.click();
		
		Thread.sleep(2000);
		
		//Select first result
		WebElement firstresult=driver.findElement(By.xpath("//body/div[4]/main[1]/div[10]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div[1]/div[6]/ol[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
		firstresult.click();
		
		Thread.sleep(2000);
		
		    Robot robot = new Robot();

		    for(int i=0; i<11; i++) {
		        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		    }

		 
		Thread.sleep(2000);
		
		
		//Add the product to Cart
		WebElement addtocart=driver.findElement(By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]"));
		addtocart.click();
		
		//Press Go to the cart Button
		WebElement gotocart=driver.findElement(By.xpath("//a[contains(text(),'Go to Cart')]"));
		gotocart.click();
		
		//Check out from Cart
		WebElement Checkout=driver.findElement(By.xpath("//button[contains(text(),'Checkout')]"));
		Checkout.click();
				
		//Continue as guest without login
		WebElement guestcontinue=driver.findElement(By.xpath("/html/body/div[1]/div/section/main/div[2]/div[4]/div/div[2]/button"));
		guestcontinue.click();
		Thread.sleep(2000);
		
		//Scroll Down to the end of the page
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		
		//Enter Email Address and Phone Number in Contact Information
		WebElement UserName=driver.findElement(By.xpath("//input[@id='user.emailAddress']"));
		UserName.sendKeys("test2021.n@gmail.com");
		
		WebElement PhoneNumber=driver.findElement(By.xpath("//input[@id='user.phone']"));
		PhoneNumber.sendKeys("235 666 6666");
		
		WebElement ContinueButton=driver.findElement(By.xpath("//body/div[@id='checkout-container']/div[2]/div[1]/div[2]/div[1]/div[1]/main[1]/div[2]/div[2]/form[1]/section[1]/div[1]/div[2]/div[1]/div[1]/button[1]"));
	    ContinueButton.click();
	    
	    Thread.sleep(2000);
	    
	    //Enter invalid Master card number 
	    WebElement MasterCard=driver.findElement(By.xpath("//input[@id='optimized-cc-card-number']"));
		MasterCard.sendKeys("5555 4444 3333 1111");
		
		//Select Month
		Select Month = new Select(driver.findElement(By.xpath("//body/div[@id='checkout-container']/div[2]/div[1]/div[2]/div[1]/div[1]/main[1]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/label[1]/div[1]/div[1]/select[1]")));
		Month.selectByIndex(3);
		
		//Select Year
		Select Year = new Select(driver.findElement(By.xpath("//body/div[@id='checkout-container']/div[2]/div[1]/div[2]/div[1]/div[1]/main[1]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[2]/label[1]/div[1]/div[1]/select[1]")));
		Year.selectByIndex(9);
				
		//Enter CVC of master card 
		WebElement CVC=driver.findElement(By.xpath("//input[@id='credit-card-cvv']"));
		CVC.sendKeys("737");
		
		//Scroll Down to the end of the page
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		
		//Enter FirstName
		WebElement FirstName=driver.findElement(By.xpath("//input[@id='payment.billingAddress.firstName']"));
		FirstName.sendKeys("Nagham");
		
		//Enter LastName
		WebElement LastName=driver.findElement(By.xpath("//input[@id='payment.billingAddress.lastName']"));
		LastName.sendKeys("Mo");
		
		//Enter Address
		WebElement Address=driver.findElement(By.xpath("//input[@id='payment.billingAddress.street']"));
		Address.sendKeys("Imex House, 40, Princess St, Manche");
		
		//Enter City
		WebElement City=driver.findElement(By.xpath("//input[@id='payment.billingAddress.city']"));
		City.sendKeys("Monterey Park");
		
		//Select State
		Select State = new Select(driver.findElement(By.xpath("//select[@id='payment.billingAddress.state']")));
		State.selectByIndex(3);
		
		//Enter ZipCode
		WebElement ZipCode=driver.findElement(By.xpath("//input[@id='payment.billingAddress.zipcode']"));
		ZipCode.sendKeys("91755");
		
		//Enter Place your order button
		WebElement Placeorder=driver.findElement(By.xpath("//body/div[@id='checkout-container']/div[2]/div[1]/div[2]/div[1]/div[1]/main[1]/div[2]/div[3]/div[1]/section[1]/div[4]/button[1]"));	
		Placeorder.click();
		
		Thread.sleep(2000);
		
		//Enter Keep Adress as entered button
		WebElement Keepaddress=driver.findElement(By.xpath("//span[contains(text(),'Keep Address as Entered')]"));	
		Keepaddress.click();
		
		Thread.sleep(2000);
		
    }

	@Test
	public void ValidateSearch() throws InterruptedException, AWTException {
		search();
	}
	
	@AfterTest
	public void CloseDriver() {
		
		driver.quit();
		
	}
	
}

