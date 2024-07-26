package pe.tpidoweb.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.tpidoweb.helper.TpidoHelper;
import pe.tpidoweb.pagina.pedido.PaginaRegistrarPedido;

public class MenuPrincipal {

	private By menuHamburguesa = By.xpath("//div[@class='menu']/div");
	private By menuPedido = By.xpath("//span[contains(.,'Pedido ')]");
	private By menuRegistrarPedido = By.linkText("Registrar Pedido");

	private WebDriver driver;

	public MenuPrincipal(WebDriver driver) {
		this.driver = driver;
	}


	public PaginaRegistrarPedido cargarPaginaRegistrarPedido() {
		TpidoHelper.pausar();
		driver.findElement(menuHamburguesa).click();

		TpidoHelper.pausar();
		driver.findElement(menuPedido).click();

		TpidoHelper.pausar();
		driver.findElement(menuRegistrarPedido).click();

		return new PaginaRegistrarPedido(driver);
	}

}
