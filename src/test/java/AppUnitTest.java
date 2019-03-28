
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppUnitTest {

	@Test
	public void projectPackageOk() {
		assertEquals("laboratorio", this.getClass().getPackage().getName());
	}

	@Test
	public void helloWorldOk() {
		assertEquals("Hello Hector", new Controller().helloWorld("Hector"));
		//assertEquals("Hello Hector", "Hello Hector");
	}
}
