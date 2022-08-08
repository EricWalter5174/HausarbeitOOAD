/**
 * Datenmodel für Lagerbar-Objekte, die aus Testdaten initialisiert
 * und von der Verwaltung abgerufen werden.
 * Änderungen seitens der NutzerInnen werden vom View 
 * über die Verwaltung geleitet und hier konkret bearbeitet.
 * 
 * Das LagerbarModel hält sowohl eine Liste aller Lagerbar-Objekte
 * als auch eine Liste von dynamisch erzeugten Lagerorten, die 
 * in späteren Implementationen von Nutzenden individuell hinzugefügt werden sollen.
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
	 * Insert-Methode für Datensatz des Models. Hier prototypisch ohne "richtige" Datenbank
	 * oder DAO-Interface, aber mit simpler Speichermethode für die Outputdatei.
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
	
	/**
	 * Aktualisiert einen gewählten Eintrag in der Liste mit einem neuen Objekt.
	 * Die mitgelieferte ID muss in set() um 1 verringert werden,
	 * da set() einen Index für die Liste verlangt 
	 * und die generierten IDs in der Tabelle bei 1 beginnen.
	 * 
	 * @param id
	 * @param lagerbar
	 */
	public void update(int id, Lagerbar lagerbar) {
		this.liste.set(id - 1, lagerbar);
		
		try {
			loader.speichereDaten();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param id
	 */
	public void remove(int id) {
		this.liste.remove(id - 1);
		Lagerbar.setCount(this.liste.size());
		
		for(int i = id - 1; i < this.liste.size(); i++) {
			this.liste.get(i).setId(id);
			id++;
		}

		try {
			loader.speichereDaten();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
