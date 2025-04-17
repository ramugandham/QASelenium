package com.webdrivercmds;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandles2 {

	public static void main(String[] args) {
		WebDriverWait wait;
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);

		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		String parentWindowId = driver.getWindowHandle();
		System.out.println(parentWindowId);
		driver.findElement(By.xpath("//a[@id='selenium143']")).click();
		driver.findElement(By.linkText("Open a popup window")).click();
	    // ✅ Wait until 3 windows are opened (without lambda)
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getWindowHandles().size() == 3;
            }
        });
		/*
		 * Set<String> allwindows = driver.getWindowHandles(); String childWindowOneID =
		 * null; String childWindowtwoID = null; for (String window : allwindows) {
		 * driver.switchTo().window(window); if (driver.getTitle().equals("New Window"))
		 * { childWindowtwoID = window;
		 * 
		 * } else if (driver.getTitle().contains("selenium143")) { childWindowOneID =
		 * window; }
		 * 
		 * }
		 */
        // Identify all windows
        Set<String> allWindows = driver.getWindowHandles();
        String childWindowOneID = null;
        String childWindowTwoID = null;

        for (String window : allWindows) {
            if (window.equals(parentWindowId)) continue;

            driver.switchTo().window(window);
            String title = driver.getTitle();

            if (title.equals("New Window")) {
                childWindowTwoID = window;
            } else {
                childWindowOneID = window; // fallback to the other
            }
        }

		
        driver.switchTo().window(childWindowTwoID);
		String textOnPopUpWindow = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		System.out.println(textOnPopUpWindow);
		driver.close();
		driver.switchTo().window(childWindowOneID);
		driver.findElement(By.xpath("//a[normalize-space()='What should I know prior to learning Selenium?']")).click();
		driver.close();
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.xpath("//textarea[@id='ta1']")).sendKeys("seleniumjava");

	}

}
