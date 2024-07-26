package pe.tpidoweb.pagina.usuario.registrar;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import pe.tpidoweb.pagina.usuario.PaginaRegistrarUsuario;

public class PaginaRegistroSteps {
	@Managed // Se usa para tomar captura
	WebDriver driver;
	PaginaRegistrarUsuario paginaRegistrarUsuario;
	
	@Before
	public void configuracionInicial() {
		paginaRegistrarUsuario = new PaginaRegistrarUsuario(driver);

	}
	
	@After
	public void cerrarDriver() {
		driver.quit();
	}

	@Given("cargo la página TpidoWeb")
	public void cargarPaginaTpido() {
		paginaRegistrarUsuario.cargarPagina();
	}
	
	@When("registro al usuario con los datos {string} , {string} , {string} y {string}")
	public void cargarRegistrarNuevoUsuario(String nombre, String apellido, String correo, String clave) {
		paginaRegistrarUsuario.registrarNuevoUsuario(nombre, apellido, correo, clave);;
	}

	
	@Then("el aplicativo muestra el mensaje {string}")
	public void verificarRegistro(String mensajeEsperado) {
		Assertions.assertThat(paginaRegistrarUsuario.getMensajeObtenido())
		.isEqualTo(mensajeEsperado);
	}
}
