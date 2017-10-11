package com.metacube.testautomation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_LoginCheck {
	WebDriver driverChrome;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		driverChrome =  new ChromeDriver();
		driverChrome.get("http://automationpractice.com/index.php");
	}

	@Test(priority=2)
	public void testForgotPassword() throws InterruptedException {
		driverChrome.findElement(By.className("login")).click();
		driverChrome.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		assertEquals(driverChrome.getTitle(), "Forgot your password - My Store");
	}

	@Test(priority = 1)
	public void testAccountCreation() throws InterruptedException {
		driverChrome.findElement(By.className("login")).click();
		Thread.sleep(1000);
		driverChrome.findElement(By.id("email_create")).sendKeys("preeti.kumawat@metacube.com");
		driverChrome.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(2000);
		assertEquals(driverChrome.getCurrentUrl(), 
				"http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(1000);
		driverChrome.quit();
	}
}
