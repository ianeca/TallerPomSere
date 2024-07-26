package pe.tpidoweb.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TpidoDriver {
	
	public enum NavegadorWeb { CHROME, FIREFOX }
	
	public static WebDriver getInstancia(NavegadorWeb navegadorWeb) {
		if(navegadorWeb == NavegadorWeb.FIREFOX)
			return getFirefoxDriver();
		return getChromeDriver();
	}
	
	public static WebDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
		
	}
	
	public static WebDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}

}
