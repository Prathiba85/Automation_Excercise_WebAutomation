package TestCases;

//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
//import org.sikuli.script.SikuliException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Page_objects.ContactusPage;
import Page_objects.HomePage;

public class TC006_Contactus_form extends BaseClass {
	public static String firstname;
	public static String name;
	public static String pwd;
	public static String email;
	@Test(priority =6)
	public void TC006_Contactus() throws FilloException, InterruptedException 
	{
		HomePage hp = new HomePage(driver);
		String actual_Homepage = driver.getCurrentUrl();
		String expected_HomePage="https://automationexercise.com/";
		Assert.assertEquals(actual_Homepage, expected_HomePage);
		hp.click_contactus();
		ContactusPage cp = new ContactusPage(driver);
		String actual_message = cp.get_getintouch();
		String expected_message = "GET IN TOUCH";
		Assert.assertEquals(actual_message, expected_message);
		
		Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test04'");
		recordset.next();
		String email = recordset.getField("Email");
		String name = recordset.getField("Name");
		String subject = recordset.getField("Subject");
		String message = recordset.getField("Message");
		
		ContactusPage ctp = new ContactusPage(driver);
		ctp.Set_Contactname(name);
		ctp.Set_Contactemail(email);
		ctp.Set_Suject(subject);
		ctp.Set_message(message);
		
		
		ctp.click_submit();
		driver.switchTo().alert().accept();
	}

}
