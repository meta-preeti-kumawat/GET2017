package com.metacube.testautomation;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_DemoSelenium {
	WebDriver driverChrome =  new ChromeDriver();
	WebDriver driverIE =  new InternetExplorerDriver();
	WebDriver driverFirefox;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.out.println("In Before Test");
	}

	@Test(priority=1)
	public void testLinkFoundOnChrome() throws InterruptedException {
		driverChrome.get("http://automationpractice.com/index.php");
		Thread.sleep(1000);
		driverChrome.findElement(By.className("login")).click();
		Thread.sleep(1000);
		assertNotNull(driverChrome.findElement(By.id("login_form")), "Error: Not transferred to new link");
	}

	@Test(priority=3)
	public void testLinkFoundOnIE() throws InterruptedException {
		driverIE.get("http://automationpractice.com/index.php");
		Thread.sleep(1000);
		driverIE.findElement(By.className("login")).click();
		Thread.sleep(1000);
		assertNotNull(driverIE.findElement(By.id("login_form")), "Error: Not transferred to new link");
	}

	@Test(priority=5)
	public void testLinkFoundOnFirefox() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.18.0-win32\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driverFirefox =  new FirefoxDriver();
		Thread.sleep(2000);
		driverFirefox.get("http://automationpractice.com/index.php");driverFirefox.findElement(By.className("login")).click();
		Thread.sleep(2000);
		assertNotNull(driverFirefox.findElement(By.id("login_form")), "Error: Not transferred to new link");
	}
	
	@Test(priority = 2)
	public void testFormSubmitWithErrorMessageOnChrome() {
		driverChrome.findElement(By.id("email")).sendKeys("abc@xyz.com");
		driverChrome.findElement(By.id("passwd")).sendKeys("testing123");
		driverChrome.findElement(By.id("SubmitLogin")).click();
		assertNotNull(driverChrome.findElement(By.className("alert-danger")));
	}

	@Test(priority = 4)
	public void testFormSubmitWithErrorMessageOnIE() {
		driverIE.findElement(By.id("email")).sendKeys("abc@xyz.com");
		driverIE.findElement(By.id("passwd")).sendKeys("testing123");
		driverIE.findElement(By.id("SubmitLogin")).click();
		assertNotNull(driverIE.findElement(By.className("alert-danger")));
	}

	@Test(priority = 6)
	public void testFormSubmitWithErrorMessageOnFirefox() {
		driverFirefox.findElement(By.id("email")).sendKeys("abc@xyz.com");
		driverFirefox.findElement(By.id("passwd")).sendKeys("testing123");
		driverFirefox.findElement(By.id("SubmitLogin")).click();
		assertNotNull(driverFirefox.findElement(By.className("alert-danger")));
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		System.out.println("In After Test");
		Thread.sleep(1000);
		driverChrome.quit();
		driverIE.quit();
		driverFirefox.quit();
	}

}
