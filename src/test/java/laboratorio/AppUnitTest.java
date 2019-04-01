package laboratorio;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import laboratorio.Controller;
public class AppUnitTest {
	private WebDriver driver;
	//metodo para comprobar el nombre del paquete
	@Test
	public void projectPackageOk() {
			assertEquals("laboratorio", this.getClass().getPackage().getName());
	}

	@Test
	public void helloWorldOk() {
		assertEquals("Hello Hector", new Controller().helloWorld("Hector"));
		//assertEquals("Hello Hector", "Hello Hector");
	}

	@Before
	public void setUp() {
		driver = new HtmlUnitDriver();
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void muestraTitulo(){
		driver.get("http://localhost:8081/laboratorio");
		System.out.println(driver.getTitle());
	}
}
