package Page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base_page {
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Elements
	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement singnup;
	@FindBy(xpath="//a[@href='/login']")WebElement Sign_up_login;
	@FindBy(xpath="//input[@data-qa='signup-name']")WebElement signup_name;
	@FindBy(xpath="//input[@data-qa='signup-email']")WebElement signup_email;
	@FindBy(xpath="//h2[text()='New User Signup!']")WebElement Newuser_signup;
	@FindBy(xpath="//input[@data-qa='login-email']")WebElement txt_email;
	@FindBy(xpath="//input[@data-qa='login-password']")WebElement txt_password;
	@FindBy(xpath="//button[@data-qa='login-button']")WebElement btn_login;
	@FindBy(xpath="//p[contains(text(),'Your email')]")WebElement error;
	@FindBy(xpath="//p[contains(text(),'Email Address')]")WebElement signup_error;
	@FindBy(xpath="//a[text()=' Contact us']")WebElement btn_contactus;
	@FindBy(xpath="//a[text()=' Test Cases']")WebElement btn_testcases;
	@FindBy(xpath="//a[@href='/products']")WebElement btn_products;
	@FindBy(xpath="//h2[text()='Subscription']")WebElement txt_Subscription;
	@FindBy(xpath="//input[@id='susbscribe_email']")WebElement txt_Email_Subscription;
	@FindBy(xpath="//button[@id='subscribe' and @type = 'submit']")WebElement btn_Submitsubscribe;
	@FindBy(xpath="//div[@class ='alert-success alert']")WebElement msg_subscription;
	@FindBy(xpath="//a[text()=' Cart']")WebElement btn_cart;
	@FindBy(xpath="//a[text()=' Delete Account']")WebElement btn_deleteaccount;
	
	//Actions
	public void click_signup_login()
	{
		Sign_up_login.click();
	}
	
	public void set_signupname(String signupname)
	{
		signup_name.sendKeys(signupname);
	}
	public void set_signupemail(String signupemail)
	{
		signup_email.sendKeys(signupemail);
	}
	
	public void click_signup()
	{
		singnup.click();
	}
	public String newuser_signup()
	{
		
		return Newuser_signup.getText();
	}

	//Login for existing user 
	
	public void set_email_login(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void set_password_login(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void click_login()
	{
		btn_login.click();
	}
	
	public String loginerror()
	{
		return error.getText();
		
	}
	
	public String Signuperror()
	{
		return signup_error.getText();
		
	}
	
	public void click_contactus()
	{
		btn_contactus.click();
	}
	public void click_testcases()
	{
		btn_testcases.click();
		
	}
	public void click_products()
	{
		btn_products.click();
	}
	public String get_SubscriptionText()
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",txt_Subscription);
		return txt_Subscription.getText();
	}
	
	public void subscribe_email(String email)
	{
		txt_Email_Subscription.sendKeys(email);
		btn_Submitsubscribe.click();
	}
	
	public boolean verify_successful_subscription()
	{
		if(msg_subscription.isDisplayed())
		{
			return true;
		}
		return false;
		
	}
	public void click_Cart()
	{
		
		btn_cart.click();
		
	}
	public void click_deleteaccount()
	{
		
		btn_deleteaccount.click();
		
	}
}
