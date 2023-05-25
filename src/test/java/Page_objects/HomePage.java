package Page_objects;

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
}
