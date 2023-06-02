package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import Page_objects.HomePage;
import Page_objects.TestCasePage;

public class TC007_TestCases_Tab extends BaseClass {
	
	@Test(priority =7)
	public void TC007_TestCases_Tab() throws InterruptedException
	{
		HomePage hp =new HomePage(driver);
		hp.click_testcases();
		
	TestCasePage tp =new TestCasePage(driver);
	tp.dismiss_advertisement();
		String actual_Title=tp.get_testcasetitle();
		String expected_Title="Test Cases";
		Assert.assertEquals(actual_Title,expected_Title);
	}

}
