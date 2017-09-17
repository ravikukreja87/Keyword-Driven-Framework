package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import keywords.ExecuteKeywords;

public class Runner {
	static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void main(String[] args) throws Exception {
		ExecuteKeywords exec = new ExecuteKeywords();
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		exec.keyword_executor();
	}
}