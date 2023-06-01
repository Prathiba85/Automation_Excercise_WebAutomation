package Page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasePage extends Base_page {
	public TestCasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Elements

	@FindBy(xpath = "//a[text()=' Test Cases']")
	WebElement txt_testcase_title;
	@FindBy(xpath = "//iframe[@id='aswift_5']")
	WebElement aswift5_frame;
	@FindBy(xpath = "//iframe[@title='Advertisement']")
	WebElement advertisement_frame;
	// @FindBy(xpath="//div[@aria-label='Close ad']")WebElement btn_close;
	@FindBy(xpath = "//div[@id='dismiss-button']")
	WebElement btn_dismiss;
	// Actions

	public String get_testcasetitle() {

		return txt_testcase_title.getText();
	}

	public void dismiss_advertisement()
	{
		List<WebElement> aswift4_iframe = driver.findElements(By.xpath("//iframe[@id='aswift_4']"));
		List<WebElement> aswift5_iframe = driver.findElements(By.xpath("//iframe[@id='aswift_5']"));
		System.out.println("Aswift4 Size " + aswift4_iframe.size());
		System.out.println("Aswift5 Size " + aswift5_iframe.size());

		if (aswift4_iframe.size() > 0) {
			WebElement aswift_iframe = driver.findElement(By.xpath("//iframe[@id='aswift_4']"));
			driver.switchTo().frame(aswift_iframe);
			List<WebElement> ad_iframe = driver.findElements(By.xpath("//iframe[@id='ad_iframe']"));
			System.out.println("Adiframe Size " + ad_iframe.size());
			List<WebElement> closeadv = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
			System.out.println("Closeadv in aswift_4 " + closeadv.size());
			List<WebElement> crossadv = driver.findElements(By.xpath("//*[name()='svg'][2]"));
			System.out.println("Crossadv in awift frame " + crossadv.size());
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
						System.out.println("Closeadv in adv frame " + closeadv.size());
						List<WebElement> cross1adv = driver.findElements(By.xpath("//*[name()='svg']"));
						System.out.println("Cross in adv frame " + crossadv.size());
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
		driver.switchTo().defaultContent();
		

	}
}
