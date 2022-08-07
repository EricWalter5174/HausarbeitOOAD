/**
 * Klasse für die Instanziierung der Applikation als Singleton.
 * Die Darstellung sowie die Verwaltung werden hier erzeugt.
 * 
 * @author Eric Walter
 */

package logic;

public class Applikation {

	private Verwaltung verwaltung;
	private static Applikation instance = new Applikation();
	
	
	private Applikation() {
		this.verwaltung = new Verwaltung();
	}
	
	public static Applikation getInstance() {
		return instance;
	}

	public Verwaltung getVerwaltung() {
		return this.verwaltung;
	}
	
}
