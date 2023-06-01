package TestCases;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_objects.Account_CreationPage;
import Page_objects.HomePage;
import Page_objects.LandingPage;
import Page_objects.LogoutPage;
import Page_objects.SignupPage;

public class TC005_Register_User_With_Registeredemail extends BaseClass {
	public static String firstname;
	public static String name;
	public static String pwd;
	public static String email;
	@Test(priority =5)
	public void TC005_registration_with_Existing_Email() throws InterruptedException, FilloException
	{
		HomePage hp = new HomePage(driver);
		hp.click_signup_login();
		//SignupPage sp = new SignupPage(driver);
		Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test03'");
		recordset.next();
		String email = recordset.getField("Email");
		String name = recordset.getField("Name");
		hp.set_signupname(name);
		hp.set_signupemail(email);
		hp.click_signup();
		
		String actualerror = hp.Signuperror();
		String experror = "Email Address already exist!";
		Assert.assertEquals(actualerror, experror);
		
		
		
	}

}
