package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.CommonUtils;

public class Base {
	WebDriver driver;

	public Properties prop;

	public WebDriver openBrowserAndApplicationURL() {

		prop = CommonUtils.loadProperties();
		String browserName = prop.getProperty("BrowserName");
		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefoxe")) {
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(prop.getProperty("applicationURL"));

		return driver;
	}

	public void quiteBrowser(WebDriver driver) {
		if (driver != null) {
			driver.quit();
		}
	}
}
