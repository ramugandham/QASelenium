package com.webdrivercmds;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuitCmds {

	public static void main(String[] args) {
		 ChromeDriver driver = new  ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://omayo.blogspot.com/");
			/*
			 * driver.findElement(By.xpath("//a[@id='selenium143']")).click();
			 * driver.findElement(By.xpath("//a[normalize-space()='Open a popup window']")).
			 * click(); // driver.close();
			 */	
		    //is displayed(); to check button is visible or not
		    //is enable(); to check button is enable to click or not
		    //is selected(); to check radiobtn and checkbox or not
		   // boolean button2Status = driver.findElement(By.xpath("//button[@id='but2']")).isDisplayed();
			/*
			 * boolean button2Status =
			 * driver.findElement(By.xpath("//button[@id='but2']")).isEnabled();
			 * System.out.println(button2Status); //boolean button1Status =
			 * driver.findElement(By.xpath("//button[@id='but1']")).isDisplayed(); boolean
			 * button1Status =
			 * driver.findElement(By.xpath("//button[@id='but1']")).isEnabled();
			 * System.out.println(button1Status); // boolean buttonhiddenStatus =
			 * driver.findElement(By.xpath("//input[@id='hbutton']")).isDisplayed(); boolean
			 * buttonhiddenStatus =
			 * driver.findElement(By.xpath("//input[@id='hbutton']")).isEnabled();
			 * System.out.println(buttonhiddenStatus);
			 */
			/*
			 * boolean radiobtnStatus =
			 * driver.findElement(By.xpath("//input[@value='Bike']")).isSelected();
			 * System.out.println(radiobtnStatus); boolean checkboxbtnStatus =
			 * driver.findElement(By.xpath("//input[@value='Book']")).isSelected();
			 * System.out.println(checkboxbtnStatus);
			 * driver.navigate().to("https://tutorialsninja.com/demo/");
			 * driver.navigate().back(); driver.navigate().forward();
			 * driver.navigate().refresh();
			 */
			/*
			 * String dom = driver.getPageSource(); System.out.println(dom);
			 */
		      String tagname = driver.findElement(By.xpath("//button[@id='but1']")).getTagName();
		      System.out.println(tagname);
		     String csscolur = driver.findElement(By.xpath("//button[normalize-space()='Dropdown']")).getCssValue("background-color");
		     System.out.println(csscolur);
		     Rectangle rect = driver.findElement(By.xpath("//textarea[normalize-space()='The cat was playing in the garden.']")).getRect();
		     System.out.println(rect.height);
		     System.out.println(rect.width);
		     System.out.println(rect.x);
		     System.out.println(rect.y);
		     driver.quit();

	}

}
