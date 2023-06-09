package TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class BaseClass {
	public static WebDriver driver;

	public Logger logger; // for logging

	public ResourceBundle rb;
	String br = "chrome";
	public Fillo fillo;
	public static Connection connection;

	@BeforeSuite
	public void ExcelSetup() throws FilloException
	{
		
		fillo = new Fillo();
		connection = fillo.getConnection("DataSheet.xlsx");
	}
	
	@AfterSuite
	public void closeExcelSetup() throws FilloException
	{
		
		
		connection.close();
	}

	@BeforeClass(groups = { "Regression", "Master", "Sanity" })
	public void setup() {
		rb = ResourceBundle.getBundle("config"); // Load config.properties file

		logger = LogManager.getLogger(this.getClass()); // logging

		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",new String[]
		//{"enable-automation"});

		if (br.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
		
			
			options.addExtensions(new File("C:\\browserdriver\\extension_4_7_3_0.crx"));
			options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
			driver = new ChromeDriver(options);

		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitwait(2000);

		driver.get(rb.getString("appURL"));

		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

	// Random string
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}

	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);

		return (st + "@" + num);
	}
}
