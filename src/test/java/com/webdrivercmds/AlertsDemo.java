package com.webdrivercmds;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsDemo {

	public static void main(String[] args) {
		ChromeDriver driver = new  ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	    //information alerts
	    //driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	    //confirmation alerts
	   // driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	     //prompt alerts
	    driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	    
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	   String text = alert.getText();
	    System.out.println(text);
	    alert.sendKeys("selenium java");
	    
	   //alert.accept();
	    alert.dismiss();
	    //driver.close();
	}
	

}
