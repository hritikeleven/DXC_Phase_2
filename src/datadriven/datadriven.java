package datadriven;

import java.io.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class datadriven {
	
	String csvpath ="D:\\ECLIPSE dxc phase 2\\DataDrivenTesting\\CSV_Data\\CSV_data.csv";
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver"
				,"D:\\ECLIPSE dxc phase 2\\DXCLaunchChrome\\SeleniumChromeBrowserJars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	}
	
	@Test
	public void TestingBlog() throws Exception {
		
		System.setProperty("webdriver.chrome.driver"
				,"D:\\ECLIPSE dxc phase 2\\DXCLaunchChrome\\SeleniumChromeBrowserJars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");
		
		CSVReader reader = new CSVReader(new FileReader(csvpath));
		String[] csvcell;
		
		while((csvcell=reader.readNext()) != null) {
			String FName=csvcell[0];
			String LName=csvcell[1];
			String Email=csvcell[2];
			String MPhone=csvcell[3];
			String Company=csvcell[4];
			
			driver.findElement(By.name("FirstName")).sendKeys(FName);
			driver.findElement(By.name("LastName")).sendKeys(LName);
			driver.findElement(By.name("EmailID")).sendKeys(Email);
			driver.findElement(By.name("MobNo")).sendKeys(MPhone);
			driver.findElement(By.name("Company")).sendKeys(Company);
			
			//Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@id=\"post-body-8228718889842861683\"]/div[1]/form/input[6]")).click();
		
			//Thread.sleep(10000);
			driver.switchTo().alert().accept();
		}
			reader.close();
			driver.quit();
	}
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	

}

