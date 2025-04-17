package com.webdrivercmds;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingMultiSelectionBox {

	public static void main(String[] args) {
		 ChromeDriver driver = new  ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://omayo.blogspot.com/");
		   WebElement multisele = driver.findElement(By.xpath("//select[@id='multiselect1']"));
		   Select select =new Select(multisele);
		   select.selectByVisibleText("Volvo");
		   select.selectByIndex(3);
		   select.selectByValue("Hyundaix");
		   List<WebElement> options = select.getOptions();
		   for(WebElement option:options) {
			   System.out.println(option.getText());
		   }
		   List<WebElement> selectoptions = select.getAllSelectedOptions();
		   for(WebElement option:selectoptions) {
			   System.out.println(option.getText());
		   }
		   boolean status = select.isMultiple();
		   System.out.println(status);
		   select.deselectByValue("Hyundaix");
		  // select.deselectByVisibleText("Volvo");
		   //select.deselectByIndex(3);

	}

}
