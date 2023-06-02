package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;


import Page_objects.HomePage;
import Page_objects.ProductPage;


public class TC008_Verify_All_Product extends BaseClass {
	
	@Test(priority =8)
	public void TC008_Verify_ProductList() throws InterruptedException, FilloException
	{
		HomePage hp =new HomePage(driver);
		hp.click_products();
        ProductPage pp = new ProductPage(driver);
		Thread.sleep(2000);
		pp.dismiss_adv();
		
		String Actual_heading=pp.verify_AllProcutTxt();
		String Expected_heading ="ALL PRODUCTS";
		Assert.assertEquals(Actual_heading, Expected_heading);
		pp.click_btn_product1_viewproduct();
		//get Expected values from excel spreadsheet
		Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test08'");
		recordset.next();
		String Expected_productname = recordset.getField("ProductName");
		String Expected_Category = recordset.getField("Category");
		String Expected_Price=recordset.getField("Price");
		
		//verify product name
		String actual_product_name=pp.getProductname();
		
		Assert.assertEquals(actual_product_name, Expected_productname);
		
		//verify category
		String actual_Category=pp.getcategory();
		Assert.assertEquals(actual_Category, Expected_Category);
		
		//Verify Price
		String actual_price = pp.getprice();
		Assert.assertEquals(actual_price, Expected_Price);
		
	}

}
