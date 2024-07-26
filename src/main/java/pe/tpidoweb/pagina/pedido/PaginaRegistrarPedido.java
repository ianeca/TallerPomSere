package pe.tpidoweb.pagina.pedido;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pe.tpidoweb.menu.MenuPrincipal;

public class PaginaRegistrarPedido {

	private By spCantidad = By.id("spCantidad_input");
	private By cboProducto = By.id("cboProducto_label");
	
	private String xpathExitoso = "//span[@class='ui-messages-info-summary']";
	private By lblMensaje = By.xpath(xpathExitoso);
	private By btnAgregar = By.id("j_idt25");
	private By btnGuardar =	By.id("j_idt41");

	private WebDriver driver;
	private MenuPrincipal menuPrincipal;

	public PaginaRegistrarPedido(WebDriver driver) {
		this.driver = driver;
		this.menuPrincipal = new MenuPrincipal(driver);
	}

	public void cargarPagina() {
		menuPrincipal.cargarPaginaRegistrarPedido();
	}

	public void agregarProducto(String producto, String cantidad) {
		
		WebElement cbProducto = driver.findElement(cboProducto);
		cbProducto.click();
		cbProducto.findElement(By.xpath("//li[@data-label='"+ producto +"']")).click();
		
		driver.findElement(spCantidad).sendKeys(cantidad);
		
		driver.findElement(btnAgregar).click();
	}
	
	public void guardarPedido() {
		driver.findElement(btnGuardar).click();
	}
	
	public String getMensajeObtenido() {
		return driver.findElement(lblMensaje).getText();
	}

}
