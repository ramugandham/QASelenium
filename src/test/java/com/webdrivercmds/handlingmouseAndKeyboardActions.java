package com.webdrivercmds;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class handlingmouseAndKeyboardActions {

	public static void main(String[] args) {
		 ChromeDriver driver = new  ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://omayo.blogspot.com/");
		    Actions actions=new Actions(driver);
		    WebElement ele = driver.findElement(By.xpath("//span[@id='blogsmenu']"));
		    actions.moveToElement(ele).perform();
		  //  WebElement ele1 = driver.findElement(By.xpath("//*[text()='Selenium143']"));
		   // actions.moveToElement(ele1).click().build().perform();
		    actions.contextClick(ele).build().perform();
		    WebElement dobleele1 = driver.findElement(By.xpath("//*[@id='testdoubleclick']"));
		    		actions.doubleClick(dobleele1).build().perform();
		    		//links clicking using contol+click open new tab
		    WebElement Linkele1 = driver.findElement(By.xpath("//a[text()='jqueryui']"));	
		    actions.keyDown(Keys.CONTROL).click(Linkele1).keyUp(Keys.CONTROL).build().perform();
		    		
	}

}
