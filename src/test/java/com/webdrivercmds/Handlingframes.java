package com.webdrivercmds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingframes {

	public static void main(String[] args) {
		 ChromeDriver driver = new  ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://docs.oracle.com/javase/8/docs/api/");
		    driver.switchTo().frame("classFrame");
		   driver.findElement(By.xpath("//a[text()='Description']")).click();
	}

}
