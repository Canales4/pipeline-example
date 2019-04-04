package laboratorio;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AppFunctionalTest {

	@Test
	public void tittlePageOk() {
        String exePath = "C:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8081/laboratorio");
				System.out.println(driver.getTitle());
	}
}
