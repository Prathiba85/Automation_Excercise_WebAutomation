package TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Page_objects.ContactusPage;
import Page_objects.HomePage;
import Page_objects.ProductPage;
import Page_objects.TestCasePage;

public class TC011_Verify_Subscription_inCart extends BaseClass {
	
	@Test(priority =11)
	public void TC010_Verify_Subsription() throws FilloException 
	{
		HomePage hp =new HomePage(driver);
		hp.click_Cart();
		Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test10'");
		recordset.next();
		String email = recordset.getField("Email");
		hp.subscribe_email(email);
		boolean verifyresult = hp.verify_successful_subscription();
		Assert.assertEquals(true, verifyresult);
	
	}

}
