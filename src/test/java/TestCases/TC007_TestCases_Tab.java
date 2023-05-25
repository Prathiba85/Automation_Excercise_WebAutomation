package TestCases;

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
import Page_objects.TestCasePage;

public class TC007_TestCases_Tab extends BaseClass {
	
	@Test(priority =7)
	public void TC007_TestCases_Tab() throws InterruptedException
	{
		HomePage hp =new HomePage(driver);
		hp.click_testcases();
		Thread.sleep(5000);
	TestCasePage tp =new TestCasePage(driver);
	tp.dismiss_advertisement();
		String actual_Title=tp.get_testcasetitle();
		String expected_Title="TEST CASES";
		Assert.assertEquals(actual_Title,expected_Title);
	}

}
