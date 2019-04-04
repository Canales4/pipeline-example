package laboratorio;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class AppUnitTest {

	//metodo para comprobar el nombre del paquete
	@Test
	public void projectPackageOk() {
			assertEquals("laboratorio", this.getClass().getPackage().getName());
	}

	@Test
	public void helloWorldOk() {
		assertEquals("Hello Hector", new Controller().helloWorld("Hector"));
	}
}
