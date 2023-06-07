package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class B {
	@Test
	 void checkBrowser() {
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://itera-qa.azurewebsites.net/home/automation");
	driver.findElement(By.xpath("/html/body/div/div[1]/h1")).getText();

}
	  @BeforeClass
	    public void beforeClass() {
	    
	    WebDriver driver = null;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("https://itera-qa.azurewebsites.net/home/automation");
	    }

	    @Test
	    public void textarea() {
	    By driver = null;
		driver.findElement((SearchContext) By.id("name")).sendKeys("Ola Nordmann");
	    driver.findElement((SearchContext) By.id("phone")).sendKeys("+4712345678");
	    driver.findElement((SearchContext) By.id("email")).sendKeys("test@test.no");
	    driver.findElement((SearchContext) By.id("password")).sendKeys("itera");
	    driver.findElement((SearchContext) By.id("address")).sendKeys("Nydalsveien 28, 0422 Oslo, Norway");
	    driver.findElement((SearchContext) By.name("submit")).click();

	    }
}