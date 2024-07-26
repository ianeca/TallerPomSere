package pe.tpidoweb.pagina.pedido;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import pe.tpidoweb.menu.MenuPrincipal;
import pe.tpidoweb.pagina.login.PaginaLogin;

public class PaginaRegistrarPedidoSteps {
	@Managed // Se usa para tomar captura
	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaRegistrarPedido paginaRegistrarPedido;
	MenuPrincipal menuPrincipal;
	
	@Before
	public void configuracionInicial() {
		paginaLogin = new PaginaLogin(driver);
		paginaRegistrarPedido = new PaginaRegistrarPedido(driver);
		menuPrincipal = new  MenuPrincipal(driver);
	}
	
	@After
	public void cerrarDriver() {
		driver.quit();
	}

	@Given("cargo la página TpidoWeb")
	public void cargarPaginaTpido() {
		paginaLogin.cargarPagina();
	}
	
	@And("inicio sesión con el usuario {string} y la clave {string}")
	public void iniciarSesion(String usuario, String clave) {
		paginaLogin.iniciarSesion(usuario, clave);
	}
	
	@When("cargo la página Registrar Pedido")
	public void cargarRegistrarPedido() {
		menuPrincipal.cargarPaginaRegistrarPedido();
	}
	@And("añado el nombre del producto {string} y la cantidad {string}")
	public void añadirProducto(String producto, String cantidad) {
		paginaRegistrarPedido.agregarProducto(producto, cantidad);
	}
	
	@And("guardo pedido")
	public void guardarPedido() {
		paginaRegistrarPedido.guardarPedido();
	}
	
	@Then("el aplicativo muestra el mensaje {string}")
	public void verificarRegistro(String mensajeEsperado) {
		Assertions.assertThat(paginaRegistrarPedido.getMensajeObtenido())
		.contains(mensajeEsperado);
	}
}
