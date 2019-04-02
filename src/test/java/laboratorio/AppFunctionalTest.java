package laboratorio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppFunctionalTest {

	@Test
	public void tittlePageOk() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8081/laboratorio");
		assertEquals("Laboratorio", driver.getTitle());
	}
}
