package keywords;

import org.openqa.selenium.WebDriver;

import scripts.Runner;
import utils.ReadKeywords;

public class ExecuteKeywords extends Keywords {
	public void keyword_executor() throws Exception {
		
		WebDriver driver=Runner.getDriver();

		String keyword, locator, text, attribute;
		ReadKeywords rk = new ReadKeywords();
		String data[][] = rk.readKeywords("testdata/TestData.xls");
		

		for (int i = 1; i < data.length; i++) {

			keyword = data[i][0];
			locator = data[i][1];
			text = data[i][2];
			attribute = data[i][3];

			switch (keyword) {
			case "navigate_to":
				navigate_to(driver, text);
				break;

			case "send_keys":
				send_keys(driver, locator, text);
				break;

			case "click_element":
				click_element(driver, locator);
				break;

			case "click_link":
				click_link(driver, text);
				break;

			case "get_text":
				get_text(driver, locator);
				break;

			case "verify_text":
				verify_text(driver, locator, text);
				break;

			case "element_present":
				element_present(driver, locator);
				break;

			case "link_present":
				link_present(driver, text);
				break;

			case "get_attribute":
				get_attribute(driver, locator, attribute);
				break;

			case "verify_attribute":
				verify_attribute(driver, locator, attribute, text);
				break;

			case "close_browser":
				close_browser(driver);
				break;

			case "quit_browser":
				quit_browser(driver);
				break;
				
			case "select_dd":
				select_dd(driver, locator, text);
				break;
				
			case "scroll_down":
				scrollDown(driver);
				break;
				
			case "wait":
				wait_time(Integer.parseInt(text));
				break;
			
			default:
				System.out.println("Enter Valid Keyword. Entered value = " + keyword);
				break;
			}

		}
	}
}
