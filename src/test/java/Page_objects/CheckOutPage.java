package Page_objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Base_page {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Elements

	@FindBy(xpath = "//h2[@class='title text-center' and contains(text(),'Get In Touch')]")
	WebElement txt_getintouch;
	@FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][2]")
	WebElement txt_deliveryaddress;
	@FindBy(xpath = "//textarea[@class='form-control']")
	WebElement txt_placeorder;
	@FindBy(xpath = "//a[text()='Place Order']")
	WebElement btn_placeorder;
	// Actions

	public String get_getintouch() {

		return txt_getintouch.getText();
	}

	public String get_deliveryaddress() {

		return txt_deliveryaddress.getText();
	}

	public List<String> get_checkedoutproducts() {

		List<WebElement> all_products = driver
				.findElements(By.xpath("//table[@class='table table-condensed']//tbody//tr"));

		int n = all_products.size() - 1;
		List<String> addedproducts = new <String>ArrayList();

		for (int i = 1; i <= n; i++) {
			String s = String.valueOf(i);
			String productxpath = "//div[@id='cart_info']//tr[@id='product-X']//td[2]//h4";
			String dynamicxpath = productxpath.replaceAll("X", s);
			System.out.println(dynamicxpath);

			WebElement product = driver.findElement(By.xpath(dynamicxpath));
			String productname = product.getText();
			System.out.println(productname);

			addedproducts.add(productname);

		}

		return addedproducts;

	}

	public void type_comments() {
		txt_placeorder.sendKeys("This is a test comments added while placing order");
	}

	public void place_orders() {
		btn_placeorder.click();
	}

}
