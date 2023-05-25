package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_objects.Account_creation;
import Page_objects.HomePage;
import Page_objects.LandingPage;
import Page_objects.LogoutPage;
import Page_objects.SignupPage;

public class TC001_Register_User extends BaseClass {
	public static String firstname;
	public static String name;
	public static String pwd;
	public static String email;
	@Test(priority =1)
	public void TC001_Register_newuser() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.click_signup_login();
		SignupPage sp = new SignupPage(driver);
		
		
		//random registration data
	    email = randomeString()+"@gmail.com";
		name = randomeString();
		pwd=randomeString();
		String actual_newuser_signup = hp.newuser_signup();
		String expected_newuser_signup="New User Signup!";
		AssertJUnit.assertEquals(actual_newuser_signup, expected_newuser_signup);
		hp.set_signupname(name);
		hp.set_signupemail(email);
		hp.click_signup();
		
		String actual_accountinfo = sp.gettext_accountinfo();
		String expected_accountinfo = "ENTER ACCOUNT INFORMATION";
		
		AssertJUnit.assertEquals(actual_accountinfo, expected_accountinfo);
		//Registration fields
		
		
		firstname="testfirstname "+randomeString();
		String lastname="testlastname"+randomeString();
		String Address = "testaddress"+randomeString();
		String country = "Australia";
		String mobilenumber = randomeNumber();
		
		sp.set_password(pwd);
		sp.click_dateofbirth();
		sp.click_newsletter();
		sp.click_specialoffer();
		sp.set_firstname(firstname);
		sp.set_lasttname(lastname);
		sp.set_address(Address);
		sp.set_country();
		sp.set_city("canberra");
		sp.set_state("ACT");
		sp.set_Zipcode("2606");
		sp.set_mobilenumber(mobilenumber);
		sp.click_createaccount();
		
	
		//Assertion
		Account_creation ac = new Account_creation(driver);
	
		
		String expected_accountcreation_text="ACCOUNT CREATED!";
		String actual_accountcreation_text=	ac.account_creation();
		AssertJUnit.assertEquals(actual_accountcreation_text, expected_accountcreation_text);
		ac.Click_continue();
		
		
		//Landing Page
		LandingPage lp = new LandingPage(driver);
		Thread.sleep(2000);
				
		lp.dismiss_adv();
		//String actual_logged_user=lp.get_loggeduser();
		//System.out.println("Actual logged user is :"+actual_logged_user);
		//String expected_loggeduser=name;
		//Assert.assertEquals(actual_logged_user, expected_loggeduser);
		//LogoutPage logout1 = new LogoutPage(driver);
		//logout1.click_logout();
		
		
	}

}
