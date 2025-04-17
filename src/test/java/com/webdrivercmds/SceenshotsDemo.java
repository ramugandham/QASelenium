package com.webdrivercmds;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class SceenshotsDemo {
   
	public static void main(String[] args) throws IOException {
	
		 WebDriver driver = new  ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://tutorialsninja.com/demo/");
		    //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		   File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcfile,new File(System.getProperty("user.dir")+"\\Screenshots\\demoScnshot.png"));
		    //driver.close();
	}

}
