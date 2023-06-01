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

public class ProductPage<WebElements> extends Base_page {
	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Elements

//@FindBy(xpath="//h2[text()='All Products']")WebElement txt_allproducts; //div[@class='features_items']//p[contains(text(),'Top')]

	@FindBy(xpath = "//h2[contains(text(),'All')]")
	WebElement txt_allproducts;
	@FindBy(xpath = "//a[@href='/product_details/1']")
	WebElement btn_product1_viewproduct;

	@FindBy(xpath = "//div[@id='dismiss-button']")
	WebElement close_adv;
	@FindBy(xpath = "//div[@class='product-information']//h2")
	WebElement product_name;

	@FindBy(xpath = "//div[@class='product-information']//p[contains(text(),'Category')]")
	WebElement Category;
	@FindBy(xpath = "//div[@class='product-information']//span[contains(text(),'Rs')]")
	WebElement price;
	@FindBy(xpath = "//input[@id='search_product']")
	WebElement txt_search;
	@FindBy(xpath = "//button[@id='submit_search']")
	WebElement btn_search;
	@FindBy(xpath = "//div[@class='modal-content']//button[text()='Continue Shopping']")
	WebElement btn_continueshopping;
	@FindBy(xpath = "//a[text()=' Cart']")
	WebElement btn_cart;
	
	// Actions

	public String verify_AllProcutTxt() {

		return txt_allproducts.getText();
	}

	public void click_btn_product1_viewproduct() {
		JavascriptExecutor jsadv = (JavascriptExecutor) driver;
		jsadv.executeScript("arguments[0].click();", btn_product1_viewproduct);

	}

	public void dismiss_adv() {

		List<WebElement> aswift5_iframe = driver.findElements(By.xpath("//iframe[@id='aswift_5']"));
		// System.out.println("Aswift iframe 6 "+aswift5_iframe.size());
		if (aswift5_iframe.size() > 0) {
			WebElement aswift5iframe = driver.findElement(By.xpath("//iframe[@id='aswift_5']"));
			driver.switchTo().frame(aswift5iframe);

			List<WebElement> close_adv = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
			// System.out.println("close add" +close_adv.size());
			if (close_adv.size() > 0) {
				WebElement closeadv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
				JavascriptExecutor jsadv = (JavascriptExecutor) driver;
				jsadv.executeScript("arguments[0].click();", closeadv);
				driver.switchTo().defaultContent();
			} else {
				List<WebElement> adv_iframe = driver.findElements(By.xpath("//iframe[@title='Advertisement']"));
				// System.out.println("Aswift iframe 6 "+adv_iframe.size());
				if (adv_iframe.size() > 0) {
					WebElement adviframe = driver.findElement(By.xpath("//iframe[@title='Advertisement']"));
					driver.switchTo().frame(adviframe);
					WebElement closeadv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
					JavascriptExecutor jsadv = (JavascriptExecutor) driver;
					jsadv.executeScript("arguments[0].click();", closeadv);
					driver.switchTo().defaultContent();
				}
			}

		}

		List<WebElement> aswift7_iframe = driver.findElements(By.xpath("//iframe[@id='aswift_7']"));
		// System.out.println("Aswift iframe 6 "+aswift7_iframe.size());
		if (aswift7_iframe.size() > 0) {
			WebElement aswift7iframe = driver.findElement(By.xpath("//iframe[@id='aswift_7']"));
			driver.switchTo().frame(aswift7iframe);

			List<WebElement> close_adv = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
			// System.out.println("close add" +close_adv.size());
			if (close_adv.size() > 0) {
				WebElement closeadv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
				JavascriptExecutor jsadv = (JavascriptExecutor) driver;
				jsadv.executeScript("arguments[0].click();", closeadv);
				driver.switchTo().defaultContent();
			}

			else {
				List<WebElement> ad_iframe = driver.findElements(By.xpath("//iframe[@title='Advertisement']"));
				if (ad_iframe.size() > 0) {
					WebElement adviframe = driver.findElement(By.xpath("//iframe[@title='Advertisement']"));
					driver.switchTo().frame(adviframe);
					WebElement closeadv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
					JavascriptExecutor jsadv = (JavascriptExecutor) driver;
					jsadv.executeScript("arguments[0].click();", closeadv);
					driver.switchTo().defaultContent();
				}
			}

		}
		List<WebElement> aswift6_iframe = driver.findElements(By.xpath("//iframe[@id='aswift_6']"));
		// System.out.println("Aswift iframe 6 "+aswift6_iframe.size());
		if (aswift6_iframe.size() > 0) {
			WebElement aswift6iframe = driver.findElement(By.xpath("//iframe[@id='aswift_6']"));
			driver.switchTo().frame(aswift6iframe);

			List<WebElement> close_adv = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
			// System.out.println("close_adv "+close_adv.size());
			if (close_adv.size() > 0) {
				WebElement closeadv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
				JavascriptExecutor jsadv = (JavascriptExecutor) driver;
				jsadv.executeScript("arguments[0].click();", closeadv);
				driver.switchTo().defaultContent();
			} else {
				List<WebElement> adv_iframe = driver.findElements(By.xpath("//iframe[@title='Advertisement']"));
				if (adv_iframe.size() > 0) {
					WebElement adviframe = driver.findElement(By.xpath("//iframe[@title='Advertisement']"));
					driver.switchTo().frame(adviframe);
					WebElement closeadv = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
					JavascriptExecutor jsadv = (JavascriptExecutor) driver;
					jsadv.executeScript("arguments[0].click();", closeadv);
					driver.switchTo().defaultContent();
				}
			}

		}

	}

	public String getProductname() {
		return product_name.getText();

	}

	public String getcategory() {
		return Category.getText();

	}

	public String getprice() {
		return price.getText();

	}

	public void search_Product(String productname) {

		txt_search.sendKeys(productname);
		btn_search.click();

	}

	public List<WebElement> get_Allproduct() {
		List<WebElement> products = driver.findElements(By.xpath(
				"//div[@class='features_items']//div[@class='productinfo text-center']//p[contains(text(),'Top')]"));
		return products;

	}

	public void addproduct_addcart(int n) throws InterruptedException {

		Thread.sleep(2000);
		for (int i = 1; i <= n; i++) {
			String s = String.valueOf(i);

			String overlay = "//a[@data-product-id='X']//ancestor::div[@class='overlay-content']";
			String dynamicoverlay = overlay.replaceAll("X", s);
			System.out.println("overlay" + dynamicoverlay);
			WebElement flash_overlay = driver.findElement(By.xpath(dynamicoverlay));
			String overlay_addtocart = "//a[@data-product-id='X']";
			String dynamicoverlay_addtocart = overlay_addtocart.replaceAll("X", s);
			System.out.println("add to cart" + dynamicoverlay_addtocart);
			WebElement flash_overlay_addtocart = driver.findElement(By.xpath(dynamicoverlay_addtocart));

			Actions as = new Actions(driver);
			as.moveToElement(flash_overlay).build().perform();
			as.moveToElement(flash_overlay_addtocart).build().perform();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", flash_overlay_addtocart);
			btn_continueshopping.click();
		}

	}

	/*
	 * public void addfourproduct_addcart() throws InterruptedException {
	 * 
	 * Thread.sleep(2000); Actions as = new Actions(driver);
	 * as.moveToElement(flash_overlay_1).build().perform();
	 * as.moveToElement(btn_overlay_add_to_cart1).build().perform();
	 * JavascriptExecutor js = ((JavascriptExecutor) driver);
	 * js.executeScript("arguments[0].click();", btn_overlay_add_to_cart1);
	 * btn_continueshopping.click();
	 * 
	 * // Item2 Actions as1 = new Actions(driver);
	 * as1.moveToElement(flash_overlay_2).build().perform();
	 * as1.moveToElement(btn_overlay_add_to_cart2).build().perform();
	 * JavascriptExecutor js1 = ((JavascriptExecutor) driver);
	 * js1.executeScript("arguments[0].click();", btn_overlay_add_to_cart2);
	 * btn_continueshopping.click();
	 * 
	 * // Item3 Actions as3 = new Actions(driver);
	 * as1.moveToElement(flash_overlay_3).build().perform();
	 * as1.moveToElement(btn_overlay_add_to_cart3).build().perform();
	 * JavascriptExecutor js3 = ((JavascriptExecutor) driver);
	 * js1.executeScript("arguments[0].click();", btn_overlay_add_to_cart3);
	 * btn_continueshopping.click();
	 * 
	 * // Item4 Actions as4 = new Actions(driver);
	 * as1.moveToElement(flash_overlay_4).build().perform();
	 * as1.moveToElement(btn_overlay_add_to_cart4).build().perform();
	 * JavascriptExecutor js4 = ((JavascriptExecutor) driver);
	 * js1.executeScript("arguments[0].click();", btn_overlay_add_to_cart4);
	 * btn_continueshopping.click();
	 * 
	 * }
	 */
	public void click_cart() {
		btn_cart.click();

	}

	public void click_continueoncart() {

		List<WebElement> continueoncart = driver.findElements(By.xpath("//button[text()='Continue On Cart']"));
		if (continueoncart.size() > 0) {
			WebElement continue_oncart = driver.findElement(By.xpath("//button[text()='Continue On Cart']"));
			JavascriptExecutor js4 = ((JavascriptExecutor) driver);
			js4.executeScript("arguments[0].click();", continue_oncart);

		}
	}

}
