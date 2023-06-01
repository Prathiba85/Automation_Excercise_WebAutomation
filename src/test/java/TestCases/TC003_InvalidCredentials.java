package TestCases;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_objects.Account_CreationPage;
import Page_objects.HomePage;
import Page_objects.LandingPage;
import Page_objects.LogoutPage;
import Page_objects.SignupPage;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class TC003_InvalidCredentials extends BaseClass {

//public Connection connection = BaseClass.
	
	
	@Test (priority =3)
	public void TC003_InvalidCredentials() throws InterruptedException, FilloException
	{
		HomePage hp = new HomePage(driver);
		hp.click_signup_login();
		
		Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test02'");
		recordset.next();
		String email = recordset.getField("Email");
		String password = recordset.getField("Password");
		
		
		hp.set_email_login(email);
		hp.set_password_login(password);
		
		hp.click_login();
		
		String Actual_error= hp.loginerror();
		String Expected_error = "Your email or password is incorrect!";
		Assert.assertEquals(Expected_error, Actual_error);
	
			
		
	}

}
