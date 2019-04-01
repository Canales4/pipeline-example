package laboratorio;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import laboratorio.Controller;
public class AppUnitTest {

	@Test
	public void projectPackageOk() {
		try{
			assertEquals("laboratorio", this.getClass().getPackage().getName());
		}catch(NullPointerException e){
			System.out.println(e);
		}
	}

	@Test
	public void helloWorldOk() {
		assertEquals("Hello Hector", new Controller().helloWorld("Hector"));
		//assertEquals("Hello Hector", "Hello Hector");
	}
}
