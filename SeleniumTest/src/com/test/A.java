package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.ant.AntReporterConfig.Property;

public class A {
	@Test
	void checkHeading() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		FileInputStream fis= new FileInputStream("test.properties");
		
		Properties properties= new Properties();
		
		properties.load(fis);
		
		String val=properties.getProperty("url");
		driver.get(val);
		Thread.sleep(100);
		
		String actHeading = driver.findElement(By.xpath("(//p[@class='login-box-msg'])")).getText();
		System.out.println(actHeading);
		driver.close();
		Assert.assertEquals(actHeading, "Sign to start your session");
//1
	}

	@Test
	void checkBlankMailError() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		FileInputStream fis= new FileInputStream("test.properties");
		
		Properties properties= new Properties();
		
		properties.load(fis);
		
		String val=properties.getProperty("url");
		driver.get(val);
		driver.findElement(By.xpath("//div[2]/form/div[1]/input")).sendKeys("");
		driver.findElement(By.xpath("//div[2]/form/div[2]/input")).sendKeys("");
		driver.findElement(By.xpath("//div[2]/form/div[3]/div/button")).click();
		String actMs = driver.findElement(By.xpath("(//div[@id='email_error'])")).getText();
		System.out.println(actMs);
	driver.close();
		Assert.assertEquals(actMs, "Please enter email.");
	//2
	}	

	@Test
	void checkblankPassMsg() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		String actMsg = driver.findElement(By.xpath("//*[@id=\"password_error\"]")).getText();
		System.out.println(actMsg);
		driver.close();
		Assert.assertEquals(actMsg, "Password is required");
//3
	}

	@Test
	void checkSignIn() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		driver.close();
		//4
	}
	@Test
	void checkNewResistation() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	 driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		driver.close();
		//5
	}
	@Test

		void checkNewResistation1() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		 driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		 String actText=driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();
		 System.out.println(actText);
		 driver.close();
		 Assert.assertEquals(actText, "Register a new membership");
//6		
	}
	@Test
	void checkEmptyerrorMsg() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	 driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	 driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("");
	 driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/input")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/input")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();
 driver.close();
 //7
	}
	@Test
	void checkemptyNameMsg() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	 driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	 driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("");
	 driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/input")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/input")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();
	 String actNameMsg=driver.findElement(By.xpath("//*[@id=\"name_error\"]")).getText();
	 System.out.println(actNameMsg);
		driver.close();
	 Assert.assertEquals(actNameMsg, "Please enter full name.");
	//8
	}
	
	@Test
	void checkemptyMobileMsg() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	 driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	 driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("");
	 driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/input")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/input")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();
	 String actMobileMsg=driver.findElement(By.xpath("//*[@id=\"mobile_error\"]")).getText();
	 System.out.println(actMobileMsg);
		driver.close();
	 Assert.assertEquals(actMobileMsg, "Please enter mobile number.");
//9	 
	}
	@Test
	void checkemptyemailMsg() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	 driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	 driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("");
	 driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/input")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/input")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();
	 String actemailMsg=driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
	 System.out.println(actemailMsg);
		driver.close();
	 Assert.assertEquals(actemailMsg, "Please enter Email.");
	//10 
	}
	
	@Test
	void checkemptyPassMsg() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	 driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	 driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("");
	 driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/input")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/input")).sendKeys("");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();
	 String actePassMsg=driver.findElement(By.xpath("//*[@id=\"password_error\"]")).getText();
	 System.out.println(actePassMsg);
		driver.close();
	 Assert.assertEquals(actePassMsg, "Please enter Password.");
//11	 
	}
	@Test
	void checkValidation() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	 driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	 driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("kiran");
	 driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("9845434443");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/input")).sendKeys("kiran@gmail.com");
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/input")).sendKeys("123456");
		driver.quit();
	 driver.findElement(By.xpath("/html/body/div/div[2]/form/div[5]/div/button")).click();
//12	 
	 
	}
	@Test
	void checkRegisteredSignIn() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		driver.close();
		//13
	}
	@Test
	void checkDashboardHeading() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		String actLebel=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
		driver.close();
		Assert.assertEquals(actLebel, "Dashboard Courses Offered");	
//14
	}
	@Test
	void checkUsers() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
		//15	
	}
	@Test
	void CheckUserList() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(
				"file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
		WebElement actElement = driver
				.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]"));
		System.out.println("actElement >> "+actElement);
		System.out.println("before weList thh >> 254 ");
		
		List<WebElement> weList = actElement.findElements(By.tagName("th"));
		ArrayList<String> CheckUserList = new ArrayList<String>();
		for (WebElement webelement : weList) {
			String headerElement = webelement.getText();
			CheckUserList.add(headerElement);
		}
		System.out.println("act Label >>" + CheckUserList);
		System.out.println("before CheckUserList1 263");

		ArrayList<String> CheckUserList1 = new ArrayList<String>();
		CheckUserList1.add("#");
		CheckUserList1.add("Username");
		CheckUserList1.add("Email");
		CheckUserList1.add("Mobile");
		CheckUserList1.add("Course");
		CheckUserList1.add("Gender");
		CheckUserList1.add("State");
		CheckUserList1.add("Action");
		CheckUserList1.add("excepted Label >> " + CheckUserList1);
		System.out.println("before assert line 275");
		
		System.out.println("277 actElement >> "+actElement);
		System.out.println("278 CheckUserList1 >> "+CheckUserList1);
		Assert.assertEquals(actElement, CheckUserList1);
			//        RRR   ,  2+8
	}
	@Test
	void checkAdduser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
		driver.close();
		
		//16
	}
	@Test
	void checkAddUser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
		driver.close();
//17
	}

@Test
void checkLabelnewuser() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	String actlebel=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
	System.out.println(actlebel);
	
	Assert.assertEquals(actlebel, "Add New User");
}
//18

@Test
void checkUserNameLabel() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	String actName=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[1]/label")).getText();
	System.out.println(actName);
	Assert.assertEquals(actName, "Username");

	//19
}
@Test
void checkMobileNoLabel() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	String actNo=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[2]/label")).getText();
	System.out.println(actNo);
	driver.close();
	Assert.assertEquals(actNo, "Mobile No.");

	//20
}
@Test
void checkEmailLabel() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	String actemail=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[3]/label")).getText();
	System.out.println(actemail);
	driver.close();
	Assert.assertEquals(actemail, "Email");

	//19
}
@Test
void checkCourseLabel() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	String actmsg=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[4]/label")).getText();
	System.out.println(actmsg);
	driver.close();
	Assert.assertEquals(actmsg, "Select Courses");

	//20
}
@Test
void checkGenderLabel() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	String actmsg=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[5]/label")).getText();
	System.out.println(actmsg);
	driver.close();
	Assert.assertEquals(actmsg, "Gender");
//21
}
@Test
void checkStateLabel() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	String actmsg=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/label")).getText();
	System.out.println(actmsg);
	driver.close();
	Assert.assertEquals(actmsg, "State");
//22
}
@Test
void checkPassLabel() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	String actmsg=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[7]/label")).getText();
	System.out.println(actmsg);
	driver.close();
	Assert.assertEquals(actmsg, "Password");
	//23
}
//
@Test
void checkFriendMoibileLabel() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	String actmsg=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[3]/label")).getText();
	System.out.println(actmsg);
	
	Assert.assertEquals(actmsg, "Friend Mobile Number");
	//24
}


@Test
void checkBlankerror() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	driver.close();
	//25
}
@Test
void checkBlankuserNameerror() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	String actmsg=driver.findElement(By.xpath("//*[@id=\"username\"]")).getAttribute( "Please fill out this field");
	driver.close();
	System.out.println(actmsg);
//26	
}
@Test
void checkBlankMobileerror() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("XYZ");
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();	
	String actMmsg=driver.findElement(By.xpath("//*[@id=\"mobile\"]")).getAttribute("Please fill out this field.");
	System.out.println(actMmsg);
driver.close();
//27
}
@Test
void checkBlankEmailerror() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("XYZ");
	driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("989076654");
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();	
	String actMailmsg=driver.findElement(By.xpath("//*[@id=\"email\"]")).getAttribute("Please fill out this field.");
	System.out.println(actMailmsg);
	driver.close();
//28
}
@Test
void checkBlankCourseerror() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("XYZ");
	driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("989076654");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("java@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();	
	String actCmsg=driver.findElement(By.xpath("//*[@id=\"course\"]")).getAttribute("Please fill out this field.");
	System.out.println(actCmsg);
	driver.close();
//29
}
@Test
void checkBlankGendererror() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("XYZ");
	driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("989076654");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("java@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"course\"]")).sendKeys("Selenium");
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	String actGmsg=driver.findElement(By.xpath("//*[@id=\"Male\"]")).getAttribute("Please select one of this options.");
	System.out.println(actGmsg);
	driver.close();
	//30
}
@Test
void checkBlankStateerror() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("XYZ");
	driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("989076654");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("java@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"Male\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"course\"]")).sendKeys("Selenium");
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	String actSmsg=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select")).getAttribute("Please select an item in the list.");
	System.out.println(actSmsg);
	driver.close();
//31
}
@Test
void checkBlankPasserror() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("XYZ");
	driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("989076654");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("java@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"Male\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"course\"]")).sendKeys("Selenium");
	driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select"));
	Select select = new Select(driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select")));
	select.selectByIndex(1);
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	String actPmsg=driver.findElement(By.xpath("//*[@id=\"password\"]")).getAttribute("Please fill out this field.");
	System.out.println(actPmsg);
	driver.close();
//32
}
@Test
void checkBlankFriendError() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("XYZ");
	driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("989076654");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("java@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"Male\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"course\"]")).sendKeys("Selenium");
	driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select"));
	Select select = new Select(driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select")));
	select.selectByIndex(1);
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	String actFmsg=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[3]/div/input")).getAttribute("Please fill out this field.");
	System.out.println(actFmsg);
	driver.close();
//33
}
@Test
void checkAlert() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("XYZ");
	driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("989076654");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("java@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"Male\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"course\"]")).sendKeys("Selenium");
	driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select"));
	Select select = new Select(driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select")));
	select.selectByIndex(1);
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[3]/div/input")).sendKeys("8998343034");
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	driver.close();
	//34
}
@Test
void checkOperators() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[4]/a")).click();
	driver.close();
	//35
}
@Test
void checkOperatorsHeading() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[4]/a")).click();
	String actHeading=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
	System.out.println(actHeading);
	driver.close();
	Assert.assertEquals(actHeading, "Operators");
//36
}
@Test
void checkOperatorsListHeading() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[4]/a")).click();
	String actmsg=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[1]")).getText();
	System.out.println(actmsg);
	driver.close();
	Assert.assertEquals(actmsg, "Operator List");
}
//37
@Test
void checkUsefullinks() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[4]/a")).click();
	driver.findElement(By.xpath("/html/body/div/aside[1]/section/ul/li[5]/a")).click();
	driver.close();
}//38
@Test
void checkUsefullinksHeading() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[4]/a")).click();
	driver.findElement(By.xpath("/html/body/div/aside[1]/section/ul/li[5]/a")).click();
	String actHeading=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
	System.out.println(actHeading);
	Assert.assertEquals(actHeading,"Useful Links");
	//39
	
}
@Test
void checkText() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[4]/a")).click();
	driver.findElement(By.xpath("/html/body/div/aside[1]/section/ul/li[5]/a")).click();
	String actHeading=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[1]/h3")).getText();
	System.out.println(actHeading);
	driver.close();
	Assert.assertEquals(actHeading,"Internet is required");
	//40
	}
@Test
void checkusefulSr() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///D:/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[4]/a")).click();
	driver.findElement(By.xpath("/html/body/div/aside[1]/section/ul/li[5]/a")).click();
	String actsr=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/th[1]")).getText();
	System.out.println(actsr);
	Assert.assertEquals(actsr, "Sr.No");
}
}