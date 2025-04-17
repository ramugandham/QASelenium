package com.webdrivercmds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoCmds {

	public static void main(String[] args) {
	    ChromeDriver driver = new  ChromeDriver();
	    driver.manage().window().maximize();//method chianing process follow
	    driver.get("https://omayo.blogspot.com/");
	    //driver.findElement(By.id("ta1")).sendKeys("hello selenium test is passed");
	    //driver.findElement(By.name("q")).sendKeys("hello selenium test is passed");
	   // driver.findElement(By.className("dropbtn")).click();
	    //driver.findElement(By.linkText("jqueryui")).click();
	   // driver.findElement(By.partialLinkText("jquer")).click();
	   // driver.findElement(By.xpath("//input[@value='Login']")).click();
	   // driver.findElement(By.cssSelector("input[value='Login']")).click();
	    //By is predefined class in selenium lib and methods are static can access class name
		/*
		 * WebElement textBox = driver.findElement(By.id("textbox1")); textBox.clear();
		 * textBox.sendKeys("java"); textBox.clear(); textBox.sendKeys("selenium java")
		 */;
		 String text = driver.findElement(By.xpath("//p[@id='pah']")).getText();
		 System.out.println(text);
		 String labletext = driver.findElement(By.xpath("//input[@value='Search']")).getDomAttribute("value");
		 System.out.println(labletext);
		 String titlepage =driver.getTitle();
		 System.out.println(titlepage);
		 driver.findElement(By.linkText("jqueryui")).click();
		 String CurrentUrlpage =driver.getCurrentUrl();
		 System.out.println(CurrentUrlpage);
		 driver.close();
		 //driver.quit();
	}

}
