/**
 * Verwaltungsklasse als Controller zwischen Datenmodell und View.
 * Verwaltung holt sich die Daten aus dem LagerbarModel und gibt diese für die UI-Ausgabe
 * an das LagerbarView weiter.
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package logic;
import java.io.FileNotFoundException;

import entities.LagerbarModel;
import views.LagerbarView;

public class Verwaltung {
	private LagerbarView lagerView;
	private LagerbarBuilder lagerbarBuilder; //zum Erstellen neuer Objekte durch den User
	private LagerbarModel lagerbarModel;
	
	public Verwaltung() {
		initModel();
		initView();
		this.lagerbarBuilder = new LagerbarBuilder();
		
	}
	
	/**
	 * initialisiert den Datensatz aus dem LagerbarModel
	 */
	private void initModel() {
		try {
			lagerbarModel = new LagerbarModel();
			System.out.println("Testdatendatei geladen!");
		} catch (FileNotFoundException e) {
			System.out.println("Keine Testdatendatei gefunden!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialisiert View mit Daten des Models
	 */
	private void initView() {
		this.lagerView = new LagerbarView(lagerbarModel.getListe(), lagerbarModel.getOrte());
	}
	
	//TODO: update View
}
