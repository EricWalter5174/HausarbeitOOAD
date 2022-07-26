package logic;
import ui.Darstellung;

public class Applikation {

	private Darstellung darstellung;
	private static Applikation instance = new Applikation();
	
	private Applikation() {
		 this.darstellung = new Darstellung();
	}
	
	public static Applikation getInstance() {
		return instance;
	}

}
