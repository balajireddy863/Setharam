

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

public class Base_Test {
	public WebDriver driver;
	@BeforeClass
	public void beforeTest() throws IOException, InterruptedException {
		String chromePath=System.setProperty("webdriver.chrome.driver","G:\\Selenium_Tra\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url = Utility_functions.Test_configration("AppUrl");
		driver.get(url);
		Thread.sleep(1000);
		WebElement login=driver.findElement(By.xpath("//a[text()='Log in']"));
		login.click();
		WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
		Utility_functions.sendKeys(email,Utility_functions.Test_configration("email"));
		WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
		Utility_functions.sendKeys(password, Utility_functions.Test_configration("password"));
		WebElement loginButton=driver.findElement(By.xpath("//input[@value='Log in']"));
		Utility_functions.click(loginButton);
		WebElement books = driver.findElement(By.linkText("Books"));
		Utility_functions.click(books);
		WebElement sort = driver.findElement(By.xpath("//select[@id=\"products-orderby\"]"));
		Utility_functions.select_by_index(sort, 3);
		WebElement grid = driver.findElement(By.xpath("//select[@id=\"products-viewmode\"]"));
		Utility_functions.select_by_index(grid, 1);
	
		
				
		
		//driver.get("http://demowebshop.tricentis.com/");
	}
	@AfterClass
	public void close()
	{
		driver.close();
		
	}
}
