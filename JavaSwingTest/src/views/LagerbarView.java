/**
 * Viewklasse für Lagerbar-Objekte, um aktualisierte Daten an das UI zur Darstellung weiterzugeben.
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package views;

import java.util.ArrayList;
import java.util.Set;

import javax.swing.JDialog;

import entities.Lagerbar;
import entities.Lagerort;
import logic.Applikation;
import logic.Verwaltung;
import ui.Darstellung;
import ui.DialogboxAendern;
import ui.DialogboxEntfernen;
import ui.DialogboxHinzu;

public class LagerbarView {
	
	private Darstellung darstellung;
	private JDialog dialogboxHinzu;
	private JDialog dialogboxAendern;
	private JDialog dialogboxEntfernen;
	
	//private Verwaltung verwaltung = new Verwaltung();
	
	private ArrayList<Lagerbar> liste;
	private ArrayList<Lagerort> orte;
	
	public LagerbarView() {}
	
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
	 * Das LagerbarView benachrichtigt die Verwaltung über die
	 * Nutzerinteraktion.
	 * Die bestehende Verwaltung der statischen App-Instanz wird genutzt, 
	 * um ein zusätzliches Verwaltungsobjekt zu vermeiden.
	 */
	public void hinzuButtonClick() {
		Applikation.getInstance().getVerwaltung().hinzuButtonClick();
	}
	
	/**
	 * Öffnet die von der Verwaltung angeordnete Dialogbox zum Hinzufügen
	 * eines neuen Eintrags.
	 */
	public void hinzuDialogOeffnen() {
		this.dialogboxHinzu = new DialogboxHinzu("Eintrag hinzufügen", true, orte);
		this.dialogboxHinzu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.dialogboxHinzu.setVisible(true);
	}
	
	/**
	 * Ein neu erstelltes Lagerbar-Objekt wird an die Verwaltung vermittelt,
	 * die das LagerbarModel über die Änderung informiert.
	 * @param lagerbar
	 */
	public void registriereNeuesLagerbar(Lagerbar lagerbar) {
		Applikation.getInstance().getVerwaltung().registriereNeuesLagerbar(lagerbar);
	}
	
	/**
	 * Bekommt einen aktualisierten Datensatz von der Verwaltung und reicht diesen
	 * zum Hauptdarstellungsfenster weiter.
	 * @param liste
	 */
	public void updateView(ArrayList<Lagerbar> liste) {
		//this.darstellung.initTabelle(liste);
		this.darstellung = new Darstellung(liste);
		//TODO: Bestehende Darstellung ändern oder komplett neu starten und alte verwerfen
	}
	
}
