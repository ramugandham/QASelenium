package com.webdrivercmds;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllLinksUsingtagname {
    // list of links click one by one and print title and navigate back page 
	
	public static void main(String[] args) {
	
		 ChromeDriver driver = new  ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://tutorialsninja.com/demo/");
		    //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    // List<WebElement> links = driver.findElements(By.xpath("//a"));
		     List<WebElement> links = driver.findElements(By.tagName("a"));
		    System.out.println(links.size());
		    for(WebElement link:links) {
		    System.out.println(link.getDomAttribute("href"));
		    	
		    }
		    driver.close();
	}

}
