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
	private LagerbarBuilder lagerbarBuilder;
	private LagerbarModel lagerbarModel;
	
	public Verwaltung() {
		lagerView = new LagerbarView();
		lagerbarBuilder = new LagerbarBuilder();
		try {
			lagerbarModel = new LagerbarModel();
			//Testausgabe
			System.out.println("Testdatendatei geladen!");
			System.out.println(lagerbarModel.getListe());
		} catch (FileNotFoundException e) {
			System.out.println("Keine Testdatendatei gefunden!");
			e.printStackTrace();
		}
	}
}
