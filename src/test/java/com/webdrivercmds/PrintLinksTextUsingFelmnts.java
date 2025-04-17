package com.webdrivercmds;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintLinksTextUsingFelmnts {
    // list of links click one by one and print title and navigate back page 
	
	public static void main(String[] args) {
	
		 ChromeDriver driver = new  ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://omayo.blogspot.com/");
		    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    /*
			 * org.openqa.selenium.StaleElementReferenceException: stale element reference:
			 * stale element not found loss connective browers using navigate method thats
			 * why to get exception toavoid problem using forloop xpath dyamicall takeing
			 */
			/*
			 * List<WebElement> links =
			 * driver.findElements(By.xpath("//div[@id='LinkList1']//li")); for( WebElement
			 * link:links) { System.out.println(link.getText()); link.click();
			 * driver.getTitle(); driver.navigate().back(); }
			 */
		    
		    int link = driver.findElements(By.xpath("//div[@id='LinkList1']//li")).size();
		    for(int i=1;i<=link;i++) {
		    	String xpath="(//div[@id='LinkList1']//a)["+i+"]";
		    	WebElement links = driver.findElement(By.xpath(xpath));
		    	links.click();
		    	System.out.println(driver.getTitle());
		    	driver.navigate().back();
		    	
		    }
		    driver.close();
	}

}
