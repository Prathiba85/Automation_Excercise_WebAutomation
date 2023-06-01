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

public class TC009_Search_Product extends BaseClass {
	
	@Test(priority =9)
	public void TC008_Verify_ProductList() throws InterruptedException, FilloException
	{
		HomePage hp =new HomePage(driver);
		hp.click_products();
		
	
		ProductPage pp = new ProductPage(driver);
	
		pp.dismiss_adv();
		String Actual_heading=pp.verify_AllProcutTxt();
		String Expected_heading ="ALL PRODUCTS";
		Assert.assertEquals(Actual_heading, Expected_heading);
			//get Expected values from excel spreadsheet
		Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test09'");
		recordset.next();
		String productname = recordset.getField("ProductName");
		pp.search_Product(productname);
		
	  List <WebElement>All_products = pp.get_Allproduct();
	  for(WebElement a: All_products)
	  {
		 String product = (a.getText());
		 System.out.println(product);
		 boolean searchedproduct= product.contains(productname);
		 Assert.assertEquals(searchedproduct, true);
	  }
		
	}

}
