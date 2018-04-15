package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import keywords.ExecuteKeywords;

public class Runner {
	static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}
	
	@Test
	public void testThis() throws Exception {
		ExecuteKeywords exec = new ExecuteKeywords();
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		exec.keyword_executor();
	}
}