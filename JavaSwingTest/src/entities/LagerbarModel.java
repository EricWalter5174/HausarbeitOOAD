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
	private LoadAndSaveHelper loader;
	
	public LagerbarModel() throws FileNotFoundException {
		loader = new LoadAndSaveHelper();
		//System.out.println(new File(".").getAbsolutePath());
		liste = loader.ladeDaten(new File("src/daten/testdaten.txt"));
	}

	public ArrayList<Lagerbar> getListe() {
		return liste;
	}

	public LoadAndSaveHelper getLoader() {
		return loader;
	}
	
}
