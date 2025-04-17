package com.webdrivercmds;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handlingtables {
//static and dynamic way 
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
		int rowsCount = rows.size();
		List<WebElement> coloum = driver.findElements(By.xpath("//table[@id='table1']//th"));
		int coloumCount = coloum.size();
		for (int r = 1; r <= rowsCount; r++) {
			if (r == 1) {
				for (int c = 1; c <= coloumCount; c++) {
					String Xpath = "//table[@id='table1']//th[" + c + "]";
					String headertext = driver.findElement(By.xpath(Xpath)).getText();
					System.out.print(headertext + " ");
				}

			} else {
				for (int c = 1; c <= coloumCount; c++) {
					String Xpath = "//table[@id='table1']//tr[" + (r - 1) + "]//td[" + c + "]";
					String alldata = driver.findElement(By.xpath(Xpath)).getText();
					System.out.print(alldata + " ");
				}
			}
			System.out.println();
		}

		// smart waystatic tables
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement> rows1 = table.findElements(By.tagName("tr"));
		System.out.println(rows1.size());
		for (int i = 1; i < rows1.size(); i++) { // skip header
			List<WebElement> cols = rows1.get(i).findElements(By.tagName("td"));
			for (WebElement col : cols) {
				System.out.print(col.getText() + " | ");
			}
			System.out.println();
		}

	}

}
