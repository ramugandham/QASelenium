package Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class CommonUtils {
	
	public static Properties loadProperties() {
		 Properties prop = new Properties();
		 FileReader fr;
		try {
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resource\\Projectdata.properties");
			prop.load(fr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
	public static String newEmailGenration() {
		/*
		 * Date date=new Date(); return new Date().toString().replace(" ",
		 * "_").replace(":", "_")+"@gmail.com";
		 */
		return System.currentTimeMillis()+"@gmail.com";
	}
	
	public static Object[][] getTestData(MyXLSReader xls_received, String testName, String sheetName) {

		MyXLSReader xls = xls_received;

		String testCaseName = testName;

		String testDataSheet = sheetName;

		int testStartRowNumber = 1;

		while (!(xls.getCellData(testDataSheet, 1, testStartRowNumber).equals(testCaseName))) {

			testStartRowNumber++;

		}

		int columnStartRowNumber = testStartRowNumber + 1;
		int dataStartRowNumber = testStartRowNumber + 2;

		int rows = 0;
		while (!(xls.getCellData(testDataSheet, 1, dataStartRowNumber + rows).equals(""))) {

			rows++;

		}

		// Total number of columns in the required test
		int columns = 1;

		while (!(xls.getCellData(testDataSheet, columns, columnStartRowNumber).equals(""))) {

			columns++;

		}

		Object[][] obj = new Object[rows][1];

		HashMap<String, String> map = null;

		// Reading the data in the test
		for (int i = 0, row = dataStartRowNumber; row < dataStartRowNumber + rows; row++, i++) {

			map = new HashMap<String, String>();

			for (@SuppressWarnings("unused")
			int j = 0, column = 1; column < columns; column++, j++) {

				String key = xls.getCellData(testDataSheet, column, columnStartRowNumber);

				String value = xls.getCellData(testDataSheet, column, row);

				map.put(key, value);

			}

			obj[i][0] = map;

		}

		return obj;
       
		
		
		
	}
	public static ExtentReports getExtentReports() {
		ExtentReports extentReports=new ExtentReports(); 
		File extentFile =new File(System.getProperty("user.dir")+"\\Reports\\ExtentReport.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentFile);
		ExtentSparkReporterConfig sparkConfig = sparkReporter.config();
		sparkConfig.setReportName("Tutorial Ninja Test Automation Results");
		sparkConfig.setDocumentTitle("TN Reports");
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Selenium Version","selenium 4.1.2");
		extentReports.setSystemInfo("Username", System.getProperty("user.name"));
		return extentReports;
	}
}
