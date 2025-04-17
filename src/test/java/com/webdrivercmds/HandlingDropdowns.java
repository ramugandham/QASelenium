package com.webdrivercmds;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdowns {

	public static void main(String[] args) {
		 ChromeDriver driver = new  ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://omayo.blogspot.com/");
		   WebElement dropdown = driver.findElement(By.xpath("//select[@id='drop1']"));
		   Select select =new Select(dropdown);
		   select.selectByVisibleText("doc 2");
		   select.selectByIndex(1);
		   select.selectByValue("mno");
		   List<WebElement> options = select.getOptions();
		   for(WebElement option:options) {
			   System.out.println(option.getText());
		   }
		   boolean status = select.isMultiple();
		   System.out.println(status);

	}

}
