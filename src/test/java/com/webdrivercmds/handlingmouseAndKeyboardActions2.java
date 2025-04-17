package com.webdrivercmds;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class handlingmouseAndKeyboardActions2 {

	public static void main(String[] args) {
		 ChromeDriver driver = new  ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://jqueryui.com/droppable/");
		    Actions actions=new Actions(driver);
		    WebElement ele = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		    driver.switchTo().frame(ele);
		   
		   WebElement draggableele = driver.findElement(By.xpath("//div[@id='draggable']"));
		   WebElement droppableele = driver.findElement(By.xpath("//div[@id='droppable']"));
		   actions.dragAndDrop(draggableele,droppableele).build().perform();
		   driver.switchTo().defaultContent();
		   driver.findElement(By.xpath("//a[text()='Draggable']")).click();
		   driver.switchTo().frame(ele);
		   actions.dragAndDropBy(draggableele,100,0).build().perform();
	}

}
