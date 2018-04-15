package keywords;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class Keywords {

	public void navigate_to(WebDriver driver, String text) {
		driver.navigate().to(text);
	}

	public void send_keys(WebDriver driver, String locator, String text) {
		try {
			driver.findElement(By.xpath(locator)).sendKeys(text);
		} catch (NoSuchElementException e) {
			System.out.println("Element Not Found while entering " + text + " on locator -> " + locator);
			System.out.println("Exception thrown ---> " + e);
		}
	}

	public void click_element(WebDriver driver, String locator) {
		try {
			driver.findElement(By.xpath(locator)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element Not Found while clicking on element with locator -> " + locator);
			System.out.println("Error is " + e);
		}
	}

	public void click_link(WebDriver driver, String text) {
		try {
			driver.findElement(By.linkText(text)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element Not Found while clicking on link with link text --> " + text);
			System.out.println("Error is " + e);
		}
	}

	public String get_text(WebDriver driver, String locator) {
		try {
			System.out.println(driver.findElement(By.xpath(locator)).getText());
			return driver.findElement(By.xpath(locator)).getText();
		} catch (NoSuchElementException e) {
			System.out.println("Element Not Found for reading any text on element with locator -> " + locator);
			System.out.println("Error is " + e);
			return null;
		}
	}

	public void verify_text(WebDriver driver, String locator, String text) {
		try {

			Assert.assertEquals(get_text(driver, locator), text);
		} catch (NoSuchElementException e) {
			System.out.println("Element Not Found for comparing text on element with locator -> " + locator);
			System.out.println("Error is " + e);
		}
	}

	public boolean element_present(WebDriver driver, String locator) {
		try {
			return driver.findElement(By.xpath(locator)).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found with locator --> " + locator);
			System.out.println("Error is " + e);
			return false;
		}
	}

	public boolean link_present(WebDriver driver, String text) {
		try {
			return driver.findElement(By.linkText(text)).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found with link text --> " + text);
			System.out.println("Error is " + e);
			return false;
		}
	}

	public String get_attribute(WebDriver driver, String locator, String attribute) {
		try {
			System.out.println(driver.findElement(By.xpath(locator)).getAttribute(attribute));
			return driver.findElement(By.xpath(locator)).getAttribute(attribute);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found with locator --> " + locator);
			System.out.println("Error is " + e);
			return null;
		}
	}

	public void verify_attribute(WebDriver driver, String locator, String attribute, String text) {
		Assert.assertEquals(get_attribute(driver, locator, attribute), text);
	}

	public void close_browser(WebDriver driver) {
		driver.close();
	}

	public void quit_browser(WebDriver driver) {
		driver.quit();
	}

	public void wait_time(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {

		}
	}

	public void select_dd(WebDriver driver, String locator, String text) {
		Select s = new Select(driver.findElement(By.xpath(locator)));
		s.selectByVisibleText(text);
	}

	public void scrollDown(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 300);");
	}
}
