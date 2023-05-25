package Page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_page {
	public WebDriver driver;

	public Base_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}
