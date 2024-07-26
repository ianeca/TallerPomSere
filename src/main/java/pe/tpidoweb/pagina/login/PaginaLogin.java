package pe.tpidoweb.pagina.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.tpidoweb.helper.TpidoHelper;

public class PaginaLogin {
	
	//Atributos
	private By txtUsuario = By.id("txtUsuario");
	private By txtClave = By.id("txtClave");
	private By btnIniciarSesion = By.id("btnIniciarSesion");
	private By linkNuevoUsuario = By.linkText("Registrar nuevo usuario");
	
	private WebDriver driver;
	
	public PaginaLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void cargarPagina() {
		driver.get("http://localhost:8080/TPidoWeb/index.xhtml");
	}
	
	public void iniciarSesion(String usuario, String clave) {
		driver.findElement(txtUsuario).clear();
		driver.findElement(txtUsuario).sendKeys(usuario);
		
		driver.findElement(txtClave).clear();
		driver.findElement(txtClave).sendKeys(clave);
		
		driver.findElement(btnIniciarSesion).click();
		
	}
	public void registrarNuevoUsuario() {
		driver.findElement(linkNuevoUsuario).click();
	}
	
	public String getMensajeBienvenida() {
		return driver.findElement(By.xpath("//span[@class='ui-panel-title']")).getText();
	}
}
