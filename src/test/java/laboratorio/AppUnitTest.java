package laboratorio;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import laboratorio.Controller;
public class AppUnitTest {
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

	@Test
	public void muestraTitulo(){
			WebDriver driver = new FirefoxDriver();
			driver.get("http://localhost:8081/Laboratorio");
			String l = driver.getTitle();
			assertEquals("Laboratorio",l);
  		System.out.println("Your page title Is : "+l);
			driver.close();
	}
}
