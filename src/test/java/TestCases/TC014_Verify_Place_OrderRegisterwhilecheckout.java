package TestCases;

import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Page_objects.AddToCartPage;
import Page_objects.CheckOutPage;
import Page_objects.ContactusPage;
import Page_objects.HomePage;
import Page_objects.ProductPage;
import Page_objects.TestCasePage;

public class TC014_Verify_Place_OrderRegisterwhilecheckout extends BaseClass {

	@Test(priority = 14)
	public void TC014_VerifyPlacedOrder() throws InterruptedException, FilloException {
		HomePage hp = new HomePage(driver);
		hp.click_products();

	
		ProductPage pp = new ProductPage(driver);
		AddToCartPage atc = new AddToCartPage(driver);

		pp.dismiss_adv();
		pp.addproduct_addcart(3);
		pp.click_cart();

		// Proceed to checkout
		atc.click_proceedcheckout();
		atc.click_register_login();

		// Create account
		TC001_Register_User ru = new TC001_Register_User();
		ru.TC001_Register_newuser();
		String expected_delivery_address = TC001_Register_User.Address;

		// Click add Cart
		pp.click_cart();
		Thread.sleep(2000);
		pp.click_continueoncart();

		// Click proceed to checkout and check the address
		atc.click_proceedcheckout();
		System.out.println("expected Address" + expected_delivery_address);
		CheckOutPage cp = new CheckOutPage(driver);
		String actual_billing_address = cp.get_deliveryaddress();
		Assert.assertEquals(actual_billing_address, expected_delivery_address);

		// Validate product 1
		List<String> actualadded_productname = cp.get_checkedoutproducts();
		int i = 1;
		int size = actualadded_productname.size();
		for (String product : actualadded_productname) {

			String actual_product = product;
			// System.out.println(actual_product);

			Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test14'");
			recordset.next();
			String dynamicproductname = "ProductName" + i;
			// System.out.println(dynamicproductname);
			String expectedaddedproduct = recordset.getField(dynamicproductname);
			// System.out.println("Actual product "+actual_product);
			// System.out.println("Expected product "+expectedaddedproduct);
			Assert.assertEquals(actual_product, expectedaddedproduct);
			i++;

		}

	}
}
