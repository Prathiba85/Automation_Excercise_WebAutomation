package Page_objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage<WebElements> extends Base_page {
	public AddToCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Elements

	@FindBy(xpath = "//a[text()=' Cart']")WebElement btn_cart;
	@FindBy(xpath = "//a[text()='Proceed To Checkout']")WebElement btn_proceed_checkout;
	@FindBy(xpath = "//u[contains(text(),'Register')]")WebElement btn_register_login;
	// Actions

	public List<String> get_addedproducts(int n) {

		List<String> addedproducts = new <String> ArrayList();

		for (int i = 1; i <= n; i++) {
			String s = String.valueOf(i);
			String productxpath = "//div[@id='cart_info']//tr[@id='product-X']//td[2]//h4";
			String dynamicxpath = productxpath.replaceAll("X", s);
			System.out.println(dynamicxpath);
			// WebElement product =driver.findElement(By.xpath("dynamicxpath")) ;
			WebElement product = driver.findElement(By.xpath(dynamicxpath));
			String productname = product.getText();
			addedproducts.add(productname);

		}

		return addedproducts;

	}
	
	public void click_proceedcheckout()
	{
		btn_proceed_checkout.click();
	}
	public void click_register_login()
	{
		btn_register_login.click();
	}
	

}
