package pe.tpidoweb.helper;

public class TpidoHelper {
	
	public static void pausar() {
		try {
			Thread.sleep(2000);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
