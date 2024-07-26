package pe.tpidoweb.pagina.usuario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.tpidoweb.pagina.login.PaginaLogin;

public class PaginaRegistrarUsuario {
	//Atributos
		private By txtNombre = By.id("txtNombre");
		private By txtApellido = By.id("txtApellido");
		private By txtCorreo = By.id("txtCorreo");
		private By txtClave = By.id("txtClave");
		private By btnGuardar = By.id("btnGuardar");
		private By linkVolverInicio = By.linkText("Volver a Inicio");
		private String xpathExitoso = "//span[@class='ui-messages-info-summary']";
		private String xpathFallido = "//span[@class='ui-messages-warn-summary']";
		private String xpathError   = "//span[@class='ui-messages-error-summary']";
		private By lblMensaje = By.xpath(xpathExitoso + "|" + xpathFallido + "|" + xpathError);
		
		private WebDriver driver;
		
		private PaginaLogin paginaLogin;
		
		public PaginaRegistrarUsuario(WebDriver driver) {
			this.driver = driver;
			this.paginaLogin = new PaginaLogin(driver);
		}
		
		public void cargarPagina() {
			paginaLogin.cargarPagina();
			paginaLogin.registrarNuevoUsuario();
		}
		public void registrarNuevoUsuario(String nombre, String apellido, String correo, String clave) {
			driver.findElement(txtNombre).clear();
			driver.findElement(txtApellido).clear();
			driver.findElement(txtCorreo).clear();
			driver.findElement(txtClave).clear();

			driver.findElement(txtNombre).sendKeys(nombre);
			driver.findElement(txtApellido).sendKeys(apellido);
			driver.findElement(txtCorreo).sendKeys(correo);
			driver.findElement(txtClave).sendKeys(clave);
			
			driver.findElement(btnGuardar).click();
		}
		
		public void volverAInicio() {
			driver.findElement(linkVolverInicio).click();
		}
		
		public String getMensajeObtenido() {
			return driver.findElement(lblMensaje).getText();
		}
		
		
}
