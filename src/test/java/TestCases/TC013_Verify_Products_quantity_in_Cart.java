package TestCases;

import java.util.List;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Page_objects.AddToCartPage;
import Page_objects.ContactusPage;
import Page_objects.HomePage;
import Page_objects.ProductPage;
import Page_objects.TestCasePage;

public class TC013_Verify_Products_quantity_in_Cart extends BaseClass {
	
	@Test(priority =13)
	public void TC013_VerifyProductsQuantity() throws InterruptedException, FilloException
	{
		HomePage hp =new HomePage(driver);
		hp.click_products();
		

		ProductPage pp = new ProductPage(driver);
		AddToCartPage atc = new AddToCartPage(driver);
		pp.dismiss_adv();
		pp.addproduct_addcart(4);
		pp.click_cart();
		//Validate product 1
		List <String>  actualadded_productname = atc.get_addedproducts(2);
		int i =1;
		int size = actualadded_productname.size();
		for( String product: actualadded_productname)
		{
			
			String actual_product= product;
			System.out.println(actual_product);
				
				Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test13'");
				recordset.next();
				String dynamicproductname="ProductName"+i;
				//System.out.println(dynamicproductname);
				String expectedaddedproduct = recordset.getField(dynamicproductname);
				//System.out.println("Actual product "+actual_product);
				//System.out.println("Expected product "+expectedaddedproduct);
				Assert.assertEquals(actual_product, expectedaddedproduct);
				i++;
				
				
			}
		
		
		}
}
