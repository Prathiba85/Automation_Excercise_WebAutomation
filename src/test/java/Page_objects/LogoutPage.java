package Page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends Base_page {
	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Elements
	@FindBy(xpath="//a[@href='/logout']")
	 WebElement logout;
	public  void click_logout()
	{
		logout.click();
	}
}
