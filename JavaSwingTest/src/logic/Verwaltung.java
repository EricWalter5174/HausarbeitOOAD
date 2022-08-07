/**
 * Verwaltungsklasse als Controller zwischen Datenmodell und View.
 * Verwaltung holt sich die Daten aus dem LagerbarModel und gibt diese für die UI-Ausgabe
 * an das LagerbarView weiter.
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package logic;
import java.io.FileNotFoundException;

import entities.Lagerbar;
import entities.LagerbarModel;
import views.LagerbarView;

public class Verwaltung {
	private LagerbarView lagerView;
	private LagerbarModel lagerbarModel;
	
	public Verwaltung() {
		initModel();
		initView();		
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
	 * Initialisiert View mit Testdaten des Models
	 */
	private void initView() {
		this.lagerView = new LagerbarView(lagerbarModel.getListe(), lagerbarModel.getOrte());
	}
	
	/**
	 * Die Verwaltung gibt dem View den Befehl, die Dialogboxen zu öffnen
	 */
	public void hinzuButtonClick() {
		lagerView.hinzuDialogOeffnen();
	}
	
	public void aendernButtonClick(int id) {
		Lagerbar lb = getLagerbarById(id);
		if(lb != null) {
			lagerView.aendernDialogOeffnen(lb, lagerbarModel.getOrte());
		}
	}
	
	/**
	 * Vermittelt neu erstelltes Lagerbar-Objekt an LagerbarModel
	 * und aktualisiert Datensatz für View.
	 * @param lagerbar
	 */
	public void registriereNeuesLagerbar(Lagerbar lagerbar) {
		lagerbarModel.insert(lagerbar);
		lagerView.updateView(lagerbarModel.getListe());
	}

	private Lagerbar getLagerbarById(int id) {
		for(Lagerbar l : lagerbarModel.getListe()) {
			if(l.getId() == id) {
				return l;
			}
		}
		return null;
	}
	
}
