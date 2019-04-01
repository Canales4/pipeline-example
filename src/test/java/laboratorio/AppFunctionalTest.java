package laboratorio;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.DockerClientFactory;
import org.testcontainers.containers.BrowserWebDriverContainer;

public class AppFunctionalTest {
	@Rule
	public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
			.withDesiredCapabilities(DesiredCapabilities.chrome());

	@Test
	public void tittlePageOk() {
		RemoteWebDriver driver = chrome.getWebDriver();

		//driver.get("http://" + DockerClientFactory.instance().dockerHostIpAddress() + ":8888/laboratorio/");
		assertEquals("Laboratorio", driver.getTitle());
	}
}
