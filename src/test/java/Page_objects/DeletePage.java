package Page_objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePage extends Base_page {

	public DeletePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Elements

	@FindBy(xpath = "//b[text()='Account Deleted!']")
	WebElement txt_deletetext;
	@FindBy(xpath = "//a[@data-qa='continue-button']")
	WebElement btn_continue;

	public String get_deletedmsg() {
		return txt_deletetext.getText();
	}

	public void click_continue() {
		btn_continue.click();
	}

}
