package Page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends Base_page {

	public SignupPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//webElements
	@FindBy(xpath = "//input[@data-qa='name']")
	WebElement txt_name;
	@FindBy(xpath = "//input[@data-qa='email']")
	WebElement txt_email;
	@FindBy(xpath = "//input[@data-qa='password']")
	WebElement txt_password;
	@FindBy(xpath = "//input[@data-qa='first_name']")
	WebElement txt_firstname;
	@FindBy(xpath = "//input[@data-qa='last_name']")
	WebElement txt_lasttname;
	@FindBy(xpath = "//input[@data-qa='address']")
	WebElement txt_address;
	@FindBy(xpath = "//select[@data-qa='country']")
	WebElement dp_country;
	
	@FindBy(xpath = "//input[@data-qa='state']")
	WebElement txt_state;
	@FindBy(xpath = "//input[@data-qa='city']")
	WebElement txt_city;
	@FindBy(xpath = "//input[@data-qa='zipcode']")
	WebElement txt_zipcode;
	@FindBy(xpath = "//input[@data-qa='mobile_number']")
	WebElement txt_mobilenumber;
	
	@FindBy(xpath = "//button[@data-qa='create-account']")
	WebElement btn_createaccount;
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	WebElement txt_accountinfo;
	@FindBy(xpath = "//input[@name='newsletter']")
	WebElement cb_newsletter;
	@FindBy(xpath = "//input[@name='optin']")
	WebElement optin;
	@FindBy(xpath = "//select[@data-qa='days']")
	WebElement drp_days;
	@FindBy(xpath = "//select[@data-qa='months']")
	WebElement drp_month;
	@FindBy(xpath = "//select[@data-qa='years']")
	WebElement drp_years;
	
	public void set_name(String name)
	{
		txt_name.sendKeys(name);
	}
	public void set_emailaddress(String email)
	{
		txt_email.sendKeys(email);
		
	}
	public void set_password(String pwd)
	{
		txt_password.sendKeys(pwd);
		
	}
	public void set_firstname(String firstname)
	{
		txt_firstname.sendKeys(firstname);
		
	}
	public void set_lasttname(String lastname)
	{
		txt_lasttname.sendKeys(lastname);
		
	}
	public void set_address(String address)
	{
		txt_address.sendKeys(address);
		
	}
	public void set_country()
	{
		Select sc = new Select(dp_country);
		sc.selectByVisibleText("Australia");
		
	}
	public void set_state(String state)
	{
		txt_state.sendKeys(state);
		
	}
	public void set_city(String city)
	{
		txt_city.sendKeys(city);
		
	}
	public void set_Zipcode(String zipcode)
	{
		txt_zipcode.sendKeys(zipcode);
		
	}
	public void set_mobilenumber(String mobilenumber)
	{
		txt_mobilenumber.sendKeys(mobilenumber);
		
	}
	
	public void click_createaccount()
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",btn_createaccount);
	}
	public String gettext_accountinfo()
	{
	
		return txt_accountinfo.getText();
	}
	
	public void click_specialoffer()
	{
		optin.click();
	}
	public void click_newsletter()
	{
		cb_newsletter.click();
	}
	public void click_dateofbirth()
	{
		Select sc_date =new Select(drp_days);
		sc_date.selectByValue("6");
		Select sc_month =new Select(drp_month);
		sc_date.selectByValue("12");
		Select sc_year =new Select(drp_years);
		sc_year.selectByValue("1985");
	}
}
