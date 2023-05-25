package Page_objects;

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
	//webElements
	
	@FindBy(xpath ="//div[@id='dismiss-button']")
	WebElement close_adv;
	
	@FindBy(xpath ="//div[@id='dismiss-button']")
	WebElement crossdis_adv;
	
	@FindBy(xpath="//iframe[@id='aswift_1']")WebElement google_adviframe;
	@FindBy(xpath="//iframe[@id='ad_iframe']")WebElement ad_iframe;
	@FindBy(xpath="/html/body/header/div/div/div/div[2]/div/ul/li[10]/a/b")WebElement username;
	@FindBy(xpath="//a[@href='/logout']")
	 WebElement logout;
			
	public static String get_dynamicxpath_loginuser()
	{
		String loggeduser_xpath="//div[@class='shop-menu pull-right']//li[10]//a//b[text()='placeholder']";
		//String loggeduser_xpath="//a//b[text()='placeholder']";
		//String xp=loggeduser_xpath.replace("placeholder",firstname);
		String xp=loggeduser_xpath.replace("placeholder",name);
		System.out.println(xp);
		return xp;
		
	}
	String xpath_name=LandingPage.get_dynamicxpath_loginuser();
	
	@FindBy(xpath ="xpath_name")
	WebElement logged_user;
	
	
	public String get_loggeduser()
	{
		System.out.println(xpath_name);	
		JavascriptExecutor jsexec = (JavascriptExecutor)driver;
		//jsexec.executeScript("arguments[0].style.border='5px solid green'",logged_user);
		jsexec.executeScript("arguments[0].style.border='5px solid green'",username);
		username.click();
		return username.getText() ;
		
	}
	
	public void dismiss_adv()
		{
		driver.switchTo().frame(google_adviframe);	
			driver.switchTo().frame(ad_iframe);
			if(close_adv.isDisplayed()==true)
			{
				JavascriptExecutor jsadv = (JavascriptExecutor)driver;
				jsadv.executeScript("arguments[0].click();",close_adv);
		
			}
			/*
			if(crossdis_adv.isDisplayed()==true)
			{
				JavascriptExecutor jsadv = (JavascriptExecutor)driver;
				jsadv.executeScript("arguments[0].click();",crossdis_adv);
			
		}*/
			
			
			
			/*
			else
			{
				
				JavascriptExecutor jsadv = (JavascriptExecutor)driver;
				jsadv.executeScript("arguments[0].click();",close_adv);
		
			}
			*/
			
			
		}
		
		
		public  void click_logout()
		{
			logout.click();
		}
		
	}
