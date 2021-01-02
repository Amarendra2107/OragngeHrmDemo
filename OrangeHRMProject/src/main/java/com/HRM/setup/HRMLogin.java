package com.HRM.setup;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.HRM.login.HRMLoginPage;

public class HRMLogin {

	public WebDriver driver;
	HRMLoginPage page=null;

	@BeforeTest
	@Parameters({"browser","url"})
	public void setUp(String browser,String url) throws MalformedURLException, InterruptedException
	{
		System.out.println(" login test for HRM application is started...");

		if(browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver","E:\\FireFoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\B Amar\\Desktop\\Chrome Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		//launch browser

		page= new HRMLoginPage(driver);
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test
	@Parameters({"username","password"})
	public void verifyLogin(String username,String password) {
		page.setusername(username);
		page.setpassword(password);
		page.clickLogin();
		String expec = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1")).getText();
		String act="Personal Details";
		if(expec.equals(act)==true)
		{
			System.out.println("Test is Passed");
		}else
		{
			System.out.println("Test is Failed");
		}
	}
	@AfterTest
	public void tearDown()
	{
		System.out.println("login test for HRM application ended...");
		driver.close();
	}	
}
