package Page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactusPage extends Base_page {
	public ContactusPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Elements

	@FindBy(xpath = "//h2[@class='title text-center' and contains(text(),'Get In Touch')]")
	WebElement txt_getintouch;
	@FindBy(xpath = "//input[@data-qa='name']")
	WebElement txt_contactname;
	@FindBy(xpath = "//input[@data-qa='email']")
	WebElement txt_contactemail;
	@FindBy(xpath = "//input[@data-qa='subject']")
	WebElement txt_subject;
	@FindBy(xpath = "//textarea[@data-qa='message']")
	WebElement txt_message;
	@FindBy(xpath = "//input[@data-qa='submit-button']")
	WebElement btn_submit;
	@FindBy(xpath = "//div[@class='form-group col-md-12']//input[@name='upload_file']")
	WebElement btn_choosefile;

	// Actions

	public String get_getintouch() {

		return txt_getintouch.getText();
	}

	public void Set_Contactname(String name) {
		txt_contactname.sendKeys(name);
	}

	public void Set_Contactemail(String email) {
		txt_contactemail.sendKeys(email);
	}

	public void Set_Suject(String subject) {
		txt_subject.sendKeys(subject);
	}

	public void Set_message(String message) {
		txt_message.sendKeys(message);
	}

	public void click_submit() {
		btn_submit.click();
	}

	public void click_choosefile() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btn_choosefile);

	}

}
