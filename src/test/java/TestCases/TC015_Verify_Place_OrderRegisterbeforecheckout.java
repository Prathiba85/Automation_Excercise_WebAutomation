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
import Page_objects.DeletePage;
import Page_objects.HomePage;
import Page_objects.PaymentPage;
import Page_objects.ProductPage;
import Page_objects.TestCasePage;

public class TC015_Verify_Place_OrderRegisterbeforecheckout extends BaseClass {

	@Test(priority = 14)
	public void TC014_VerifyPlacedOrder() throws InterruptedException, FilloException {

		// Create account
		TC001_Register_User ru = new TC001_Register_User();
		ru.TC001_Register_newuser();

		// add product
		HomePage hp = new HomePage(driver);
		hp.click_products();
		ProductPage pp = new ProductPage(driver);
		pp.addproduct_addcart(3);
		pp.click_cart();

		// Click proceed to checkout and check the address
		AddToCartPage atc = new AddToCartPage(driver);
		atc.click_proceedcheckout();

		String expected_delivery_address = TC001_Register_User.Address;
		

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

			Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test15'");
			recordset.next();
			String dynamicproductname = "ProductName" + i;
			// System.out.println(dynamicproductname);
			String expectedaddedproduct = recordset.getField(dynamicproductname);
			// System.out.println("Actual product "+actual_product);
			// System.out.println("Expected product "+expectedaddedproduct);
			Assert.assertEquals(actual_product, expectedaddedproduct);
			i++;

		}
		
		//place order
		cp.type_comments();
		cp.place_orders();
		
		
		//Enter payment details
		PaymentPage payp = new PaymentPage(driver);
	
		String name = TC001_Register_User.name;
		Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test15'");
		recordset.next();
		String Card_Number = recordset.getField("Card_Number");
		String CVC = recordset.getField("CVC");
		String Expiration_MM = recordset.getField("Expiration_MM");
		String Expiration_YYYY  = recordset.getField("Expiration_YYYY");
		
		payp.set_NameOnCard(name);
		payp.set_CardNumber(Card_Number);
		payp.set_CvcNumber(CVC);
		payp.set_ExpireMonth(Expiration_MM);
		payp.set_ExpireYear(Expiration_YYYY);
		//payp.click_placeorder();
		//payp.dismiss_adv();
		payp.click_pay();
		
		
		//verify confirm message
		String actual_message = payp.get_confirmmsg();
		String expected_message = "ORDER PLACED!";
		Assert.assertEquals(actual_message, expected_message);
		
		//Delete account
		hp.click_deleteaccount();
		
		//Verify deletemessage
		DeletePage dep = new DeletePage(driver);
		String actualdeletemessage= dep.get_deletedmsg();
		String expectedeletedmessage = "ACCOUNT DELETED!";
		Assert.assertEquals(actualdeletemessage, expectedeletedmessage);
		dep.click_continue();
		
		
	}
}
