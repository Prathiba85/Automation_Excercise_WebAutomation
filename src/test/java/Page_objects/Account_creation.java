package Page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Account_creation extends Base_page {

	public Account_creation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//webElements
	@FindBy(xpath = "//h2[@data-qa='account-created']")
	WebElement account_creation;
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btn_continue;
	
	
	
	public String account_creation()
	{
		return account_creation.getText();
	}
	public void Click_continue()
	{
		btn_continue.click();
	}
	
	
	
}
