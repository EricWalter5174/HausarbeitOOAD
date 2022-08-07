/**
 * Datenmodel für Lagerbar-Objekte, die aus Testdaten initialisiert
 * und von der Verwaltung abgerufen werden.
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
	
	/**
	 * Filtert mit HashSet Duplikate und befüllt dann
	 * die Lagerort-Liste mit einzigartigen Einträgen
	 */
	private void initOrte() {
		this.orte = new ArrayList<>();
		Set<String> tmp= new HashSet<>();
		
		for(Lagerbar l : this.liste) {
			tmp.add(l.getLagerort().getName());
		}
		
		for(String name : tmp) {
			orte.add(new Lagerort(name));
		}
	}
	
	/**
	 * Insert-Methode für Datensatz des Models. Hier prototypisch ohne richtige Datenbank/DAO.
	 * @param lagerbar
	 */
	public void insert(Lagerbar lagerbar) {
		this.liste.add(lagerbar);
		
		try {
			loader.speichereDaten();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
