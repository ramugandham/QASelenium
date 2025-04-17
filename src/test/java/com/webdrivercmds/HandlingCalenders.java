package com.webdrivercmds;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingCalenders {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter year ");
		String ExpectedYear = sc.nextLine();
		System.out.println("enter month ");
		String ExpectedMonth=sc.nextLine();
		System.out.println("enter day ");
		String ExpectedDay=sc.nextLine();
		sc.close();
		 ChromeDriver driver = new  ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		   WebElement ele = driver.findElement(By.xpath("//input[@id='datepicker']"));
		   ele.click();
		   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ui-datepicker-div']")));
		  String Year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		  String Month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		  while(!Year.equals(ExpectedYear)||!Month.equals(ExpectedMonth)) {
			  driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			  Year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			  Month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			  
		  }
		  String xpath="//td[@data-handler='selectDay']//a[text()='"+ExpectedDay+"']";
		  driver.findElement(By.xpath(xpath)).click();
		   
	}

}
