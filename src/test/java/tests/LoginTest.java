package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	
	WebDriver driver;
	
	@Test
	public void login() throws IOException, InterruptedException {
		
		
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();
		
		Thread.sleep(3000);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailField().sendKeys(prop.getProperty("email"));
		loginPage.passwordField().sendKeys(prop.getProperty("password"));
		loginPage.loginButton().click();
		
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.Edityouraccountinformation().isDisplayed());
	}
	
	
	@BeforeMethod
	public void openApplication() throws IOException {
		driver = initializeDreiver();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void closure() {
		driver.close();
	}

}
