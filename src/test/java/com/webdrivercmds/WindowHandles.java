package com.webdrivercmds;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandles {

	public static void main(String[] args) {
		WebDriverWait wait;
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);

		ChromeDriver driver = new ChromeDriver(options);
		
		    driver.manage().window().maximize();
		    driver.get("https://omayo.blogspot.com/");
		    String parentWindowId = driver.getWindowHandle();
		    System.out.println(parentWindowId);
		    driver.findElement(By.xpath("//a[@id='selenium143']")).click();
		    Set<String> allwindows = driver.getWindowHandles();
		    String childWindowOneID = null;
		    for(String window:allwindows) {
		    	if(!window.equals(parentWindowId)) {
		    		childWindowOneID=window;
		    		break;
		    	}
		    	
		    }
		    driver.findElement(By.linkText("Open a popup window")).click();
		   new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.getWindowHandles().size() == 3);
		     allwindows = driver.getWindowHandles();
		     String childWindowtwoID = null;
			    for(String window:allwindows) {
			    	if(!window.equals(parentWindowId)&&!window.equals(childWindowOneID)) {
			    		childWindowtwoID=window;
			    		break;
			    	}
			    	
			    }
			    if (childWindowtwoID != null) {
			        driver.switchTo().window(childWindowtwoID);
			        // continue your actions
			    } else {
			        System.out.println("Second child window was not found.");
			    }

	
		   // driver.switchTo().window(childWindowtwoID);	
		  
		    String textOnPopUpWindow = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		    System.out.println(textOnPopUpWindow);
		    driver.close();
		    driver.switchTo().window(childWindowOneID);	
		    driver.findElement(By.xpath("//a[normalize-space()='What should I know prior to learning Selenium?']")).click();
		    driver.close();
		    driver.switchTo().window(parentWindowId);	
		     driver.findElement(By.xpath("//textarea[@id='ta1']")).sendKeys("seleniumjava");
		  
	}

}
