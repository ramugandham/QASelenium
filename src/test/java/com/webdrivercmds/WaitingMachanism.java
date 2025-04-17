package com.webdrivercmds;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingMachanism {

	public static void main(String[] args) throws InterruptedException {
		 ChromeDriver driver = new  ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		   // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
		    driver.get("https://omayo.blogspot.com/");
		    driver.findElement(By.xpath("//button[normalize-space()='Dropdown']")).click();
		   // Thread.sleep(2000);
		   
		    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='myDropdown']/a[2]")));
		   ele1.click();
		 
	}

}
