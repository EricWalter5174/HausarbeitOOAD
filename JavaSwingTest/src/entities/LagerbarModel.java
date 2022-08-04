/**
 * Datenmodel für Lagerbar-Objekte, die aus Testdaten initialisiert
 * und von der Verwaltung abgerufen werden.
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import utility.LoadAndSaveHelper;

public class LagerbarModel {
	private ArrayList<Lagerbar> liste;
	private ArrayList<Lagerort> orte;
	private LoadAndSaveHelper loader;
	
	public LagerbarModel() throws FileNotFoundException {
		loader = new LoadAndSaveHelper();
		liste = loader.ladeDaten(new File("src/daten/testdaten.txt"));
		initOrte();
	}

	public ArrayList<Lagerbar> getListe() {
		return liste;
	}
	
	public ArrayList<Lagerort> getOrte(){
		return orte;
	}

	public LoadAndSaveHelper getLoader() {
		return loader;
	}
	
	//TODO: Lagerorte Duplikate filtern, evtl mit Set?
	private void initOrte() {
		this.orte = new ArrayList<>();
		
		for(Lagerbar l : this.liste) {
			orte.add(l.getLagerort());
		}
//		for(Lagerort o : orte) {
//			System.out.println(o.getName());
//		}
	}
	
}
