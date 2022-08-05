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
import ui.Darstellung;

public class LagerbarView {
	
	private Darstellung darstellung;
	
	private ArrayList<Lagerbar> liste;
	private ArrayList<Lagerort> orte;
	
	public LagerbarView(ArrayList<Lagerbar> liste, ArrayList<Lagerort> orte) {
		setListe(liste);
		setOrte(orte);
		this.darstellung = new Darstellung(liste);
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
	
	/**
	 * Bekommt von der Verwaltung die Daten des LagerbarModels,
	 * um die Darstellung im UI zu aktualisieren.
	 * @param liste
	 * @param orte
	 */
	public void initDarstellung(ArrayList<Lagerbar> liste, ArrayList<Lagerort> orte) {
		
	}
	
}
