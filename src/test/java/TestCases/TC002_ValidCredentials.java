package TestCases;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_objects.Account_creation;
import Page_objects.HomePage;
import Page_objects.LandingPage;
import Page_objects.LogoutPage;
import Page_objects.SignupPage;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class TC002_ValidCredentials extends BaseClass {

//public Connection connection = BaseClass.
	
	
	@Test (priority =2)
	public void TC002_ValidCredentials() throws InterruptedException, FilloException
	{
		HomePage hp = new HomePage(driver);
		hp.click_signup_login();
		
		Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test01'");
		recordset.next();
		String email = recordset.getField("Email");
		String password = recordset.getField("Password");
		
		
		hp.set_email_login(email);
		hp.set_password_login(password);
		Thread.sleep(2000);
		hp.click_login();
	
		LogoutPage logout = new LogoutPage(driver);
		logout.click_logout();
		
		
		
	}

}
