/**
 * Klasse für die Instanziierung der Applikation als Singleton.
 * Die Darstellung sowie die Verwaltung werden hier erzeugt.
 * 
 * @author Eric Walter
 */

package logic;
import ui.Darstellung;

public class Applikation {

	private Darstellung darstellung;
	private Verwaltung verwaltung;
	private static Applikation instance = new Applikation();
	
	
	private Applikation() {
		this.verwaltung = new Verwaltung();
		 this.darstellung = new Darstellung();
	}
	
	public static Applikation getInstance() {
		return instance;
	}

}
