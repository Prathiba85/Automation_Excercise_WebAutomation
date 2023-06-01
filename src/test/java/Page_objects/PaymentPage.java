package Page_objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends Base_page {

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Elements

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement txt_nameoncard;

	@FindBy(xpath = "//input[@data-qa='card-number']")
	WebElement txt_cardnumber;

	@FindBy(xpath = "//input[@data-qa='cvc']")
	WebElement txt_cvc;
	@FindBy(xpath = "//input[@data-qa='expiry-month']")
	WebElement txt_expmonth;
	@FindBy(xpath = "//input[@name='expiry_year']")
	WebElement txt_expyear;

	@FindBy(xpath = "//a[text()='Place Order']")
	WebElement btn_placeorder;
	@FindBy(xpath = "//h2[@data-qa='order-placed']//b")
	WebElement txt_alertmsg;
	@FindBy(xpath = "//button[@data-qa='pay-button']")
	WebElement btn_paybutton;
	
	
	
	public void set_NameOnCard(String name) {
		txt_nameoncard.sendKeys(name);
	}

	public void set_CardNumber(String cardnumber) {
		txt_cardnumber.sendKeys(cardnumber);
	}

	public void set_CvcNumber(String cvcnumber) {
		txt_cvc.sendKeys(cvcnumber);
	}

	public void set_ExpireMonth(String expmonth) {
		txt_expmonth.sendKeys(expmonth);
	}

	public void set_ExpireYear(String expyear) {
		txt_expyear.sendKeys(expyear);
	}
	
	public void click_placeorder() {
		btn_placeorder.click();
	}
	
	public void click_confirmorder() {
		//btn_confirmorder.click();
	}
	public void click_pay() {
		btn_paybutton.click();
	}

	public String get_confirmmsg() {
		return txt_alertmsg.getText();
		
	}
	public void dismiss_adv() {

		List<WebElement> aswift4_iframe = driver.findElements(By.xpath("//iframe[@id='aswift_4']"));
		//System.out.println("Aswift iframe 6 " + aswift4_iframe.size());
		if (aswift4_iframe.size() > 0) {
			WebElement aswift4iframe = driver.findElement(By.xpath("//iframe[@id='aswift_4']"));
			driver.switchTo().frame(aswift4iframe);

			List<WebElement> close_adv = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
			//System.out.println("close add" + close_adv.size());
			if (close_adv.size() > 0) {
				WebElement closeadv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
				JavascriptExecutor jsadv = (JavascriptExecutor) driver;
				jsadv.executeScript("arguments[0].click();", closeadv);
			} else {
				List<WebElement> adv_iframe = driver.findElements(By.xpath("//iframe[@title='Advertisement']"));
				//System.out.println("Aswift iframe 6 " + adv_iframe.size());
				if (adv_iframe.size() > 0) {
					WebElement adviframe = driver.findElement(By.xpath("//iframe[@title='Advertisement']"));
					driver.switchTo().frame(adviframe);
					WebElement closeadv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
					JavascriptExecutor jsadv = (JavascriptExecutor) driver;
					jsadv.executeScript("arguments[0].click();", closeadv);
				}
			}

		}

		List<WebElement> aswift5_iframe = driver.findElements(By.xpath("//iframe[@id='aswift_5']"));
		//System.out.println("Aswift iframe 6 " + aswift5_iframe.size());
		if (aswift5_iframe.size() > 0) {
			WebElement aswift5iframe = driver.findElement(By.xpath("//iframe[@id='aswift_5']"));
			driver.switchTo().frame(aswift5iframe);

			List<WebElement> close_adv = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
			//System.out.println("close add" + close_adv.size());
			if (close_adv.size() > 0) {
				WebElement closeadv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
				JavascriptExecutor jsadv = (JavascriptExecutor) driver;
				jsadv.executeScript("arguments[0].click();", closeadv);
			}

			else {
				List<WebElement> ad_iframe = driver.findElements(By.xpath("//iframe[@title='Advertisement']"));
				if (ad_iframe.size() > 0) {
					WebElement adviframe = driver.findElement(By.xpath("//iframe[@title='Advertisement']"));
					driver.switchTo().frame(adviframe);
					WebElement closeadv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
					JavascriptExecutor jsadv = (JavascriptExecutor) driver;
					jsadv.executeScript("arguments[0].click();", closeadv);
				}
			}

		}
		List<WebElement> aswift6_iframe = driver.findElements(By.xpath("//iframe[@id='aswift_6']"));
		//System.out.println("Aswift iframe 6 " + aswift6_iframe.size());
		if (aswift6_iframe.size() > 0) {
			WebElement aswift6iframe = driver.findElement(By.xpath("//iframe[@id='aswift_6']"));
			driver.switchTo().frame(aswift6iframe);

			List<WebElement> close_adv = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
			//System.out.println("close_adv " + close_adv.size());
			if (close_adv.size() > 0) {
				WebElement closeadv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
				JavascriptExecutor jsadv = (JavascriptExecutor) driver;
				jsadv.executeScript("arguments[0].click();", closeadv);
			} else {
				List<WebElement> adv_iframe = driver.findElements(By.xpath("//iframe[@title='Advertisement']"));
				if (adv_iframe.size() > 0) {
					WebElement adviframe = driver.findElement(By.xpath("//iframe[@title='Advertisement']"));
					driver.switchTo().frame(adviframe);
					WebElement closeadv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
					JavascriptExecutor jsadv = (JavascriptExecutor) driver;
					jsadv.executeScript("arguments[0].click();", closeadv);
				}
			}

		}

	}
}
