package Page_objects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestCases.TC001_Register_User;

public class LandingPage extends Base_page {

	String firstname = TC001_Register_User.firstname;
	static String name = TC001_Register_User.name;
	public static String xp;

	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "/html/body/header/div/div/div/div[2]/div/ul/li[10]/a/b")
	WebElement username;
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logout;
	@FindBy(xpath = "//a[text()=' Logged in as ']")
	WebElement loggedinuser;

	public static String get_dynamicxpath_loginuser() {
		String loggeduser_xpath = "//div[@class='shop-menu pull-right']//li[10]//a//b[text()='placeholder']";
		String xp = loggeduser_xpath.replace("placeholder", name);
		System.out.println(xp);
		return xp;

	}

	String xpath_name = LandingPage.get_dynamicxpath_loginuser();

	@FindBy(xpath = "xpath_name")
	WebElement logged_user;

	public String get_loggeduser() {
		System.out.println(xpath_name);
		JavascriptExecutor jsexec = (JavascriptExecutor) driver;

		jsexec.executeScript("arguments[0].style.border='5px solid green'", username);
		username.click();
		return username.getText();

	}

	public void dismiss_adv() {

		List<WebElement> aswift1_iframe = driver.findElements(By.xpath("//iframe[@id='aswift_1']"));
		List<WebElement> aswift6_iframe = driver.findElements(By.xpath("//iframe[@id='aswift_6']"));
		//System.out.println("Aswift1 Size " + aswift1_iframe.size());
		//System.out.println("Aswift6 Size " + aswift6_iframe.size());

		if (aswift1_iframe.size() > 0) {
			WebElement aswift_iframe = driver.findElement(By.xpath("//iframe[@id='aswift_1']"));
			driver.switchTo().frame(aswift_iframe);
			List<WebElement> ad_iframe = driver.findElements(By.xpath("//iframe[@id='ad_iframe']"));
			//System.out.println("Adiframe Size " + ad_iframe.size());
			List<WebElement> closeadv = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
			//System.out.println("Closeadv in aswift_1 " + closeadv.size());
			List<WebElement> crossadv = driver.findElements(By.xpath("//*[name()='svg'][2]"));
			//System.out.println("Crossadv in adv frame " + crossadv.size());
			if (closeadv.size() > 0) {

				WebElement close_adv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
				JavascriptExecutor jsadv = (JavascriptExecutor) driver;
				jsadv.executeScript("arguments[0].click();", close_adv);
				driver.switchTo().defaultContent();
			}

			else {
				if (crossadv.size() > 0) {
					WebElement cross_adv = driver
							.findElement(By.xpath("//div[@id='dismiss-button']//div//*[name()='svg']"));
					JavascriptExecutor jsadv = (JavascriptExecutor) driver;
					jsadv.executeScript("arguments[0].click();", cross_adv);
					driver.switchTo().defaultContent();
				}

				else {

					if (ad_iframe.size() > 0) {

						WebElement adiframe = driver.findElement(By.xpath("//iframe[@id='ad_iframe']"));
						driver.switchTo().frame(adiframe);
						List<WebElement> close1adv = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
						//System.out.println("Closeadv in adv frame " + closeadv.size());
						List<WebElement> cross1adv = driver.findElements(By.xpath("//*[name()='svg']"));
						//System.out.println("Cross in adv frame " + crossadv.size());
						if (close1adv.size() > 0) {
							WebElement close_adv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
							JavascriptExecutor jsadv = (JavascriptExecutor) driver;
							jsadv.executeScript("arguments[0].click();", close_adv);
							driver.switchTo().defaultContent();
						} else {
							if (cross1adv.size() > 0) {

								WebElement cross_adv = driver
										.findElement(By.xpath("//div[@id='dismiss-button']//div//*[name()='svg']"));
								JavascriptExecutor jsadv = (JavascriptExecutor) driver;
								jsadv.executeScript("arguments[0].click();", cross_adv);
								driver.switchTo().defaultContent();
							}
						}
					}

				}

			}

		}

	}

	public void click_logout() {
		logout.click();
	}

}
