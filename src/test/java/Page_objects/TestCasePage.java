package Page_objects;


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
	
	@FindBy(xpath="//b[text()='Test Cases']")WebElement txt_testcase_title;
	@FindBy(xpath="//iframe[@id='aswift_3']")WebElement aswift3_frame;
	@FindBy(xpath="//iframe[@title='Advertisement']")WebElement advertisement_frame;
	@FindBy(xpath="//div[@aria-label='Close ad']")WebElement btn_close;
	@FindBy(xpath="//div[@id='dismiss-button']")WebElement btn_dismiss;
	//Actions
	
	public String get_testcasetitle()
	{
		
		return txt_testcase_title.getText();
	}

	public void dismiss_advertisement()
	{
		if(aswift3_frame.isDisplayed())
		{
		driver.switchTo().frame( aswift3_frame);
		driver.switchTo().frame(advertisement_frame);
		if(btn_close.isDisplayed())
		{
		btn_close.click();
		}
		else 
		{
			btn_dismiss.click();
		}
		}
			
	}
	
}
