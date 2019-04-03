package laboratorio;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class AppFunctionalTest {

	@Test
	public void tittlePageOk() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8081/laboratorio");
		System.out.print(driver.getTitle());
		Desktop d = Desktop.getDesktop();
		d.browse(new URI("http://localhost:8081/laboratorio"));
	}
}
