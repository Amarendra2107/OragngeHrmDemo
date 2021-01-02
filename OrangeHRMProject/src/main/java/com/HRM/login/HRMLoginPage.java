package com.HRM.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMLoginPage {
    
	WebDriver driver;
	
	//Find user name field
	@FindBy(id="txtUsername")
	WebElement username;
	
	//find password field
	
    @FindBy(id="txtPassword")	
	WebElement password;
    
    //find submit button
    @FindBy(id="btnLogin")
    WebElement login;
    
    @FindBy(id="welcome")
    WebElement welcome;
    
    @FindBy(xpath="/html/body/div[1]/div[1]/div[10]/ul/li[2]/a")
    WebElement logout;
    
	public HRMLoginPage(WebDriver d) {
		
	 driver=d;
		PageFactory.initElements(d, this);
	}
	//send user name and password
    public void setusername(String uname )
    {
    	username.sendKeys(uname);
    }
    public void setpassword(String pass)
    {
    	password.sendKeys(pass);
    }
    public void clickLogin()
    {
    	login.click();
    }
    
    public void goForLogout()
    {
    	welcome.click();
    }
    
    public void logout()
    {
    	logout.click();
    }
  
}
