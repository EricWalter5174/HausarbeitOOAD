/**
 * Viewklasse für Lagerbar-Objekte, um aktualisierte Daten an das UI zur Darstellung weiterzugeben.
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package views;

import java.util.ArrayList;
import java.util.Set;

import entities.Lagerbar;
import entities.Lagerort;

public class LagerbarView {
	
	private ArrayList<Lagerbar> liste;
	private ArrayList<Lagerort> orte;
	
	public LagerbarView(ArrayList<Lagerbar> liste, ArrayList<Lagerort> orte) {
		setListe(liste);
		setOrte(orte);
	}

	public ArrayList<Lagerbar> getListe() {
		return liste;
	}

	private void setListe(ArrayList<Lagerbar> liste) {
		this.liste = liste;
	}

	public ArrayList<Lagerort> getOrte() {
		return orte;
	}

	private void setOrte(ArrayList<Lagerort> orte) {
		this.orte = orte;
	}
	
	
	
}
