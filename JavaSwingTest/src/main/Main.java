/**
 * Main-Klasse zum Instanziieren der Applikation.
 * 
 * Diese App stellt ein UI zur Verfügung, um 
 * verschiedene Vorräte als Einträge in einer Tabelle zu verwalten.
 * Es können sowohl neue Einträge hinzugefügt als auch 
 * bestehende Einträge bearbeitet oder entfernt werden.
 * 
 * Die Konzipierung und Umsetzung dieses Prototyps erfolgte 
 * im Rahmen einer Projektarbeit des Moduls "Objektorientierte Analyse und Design"
 * an der Hochschule Osnabrück.
 * Siehe Dokumentation für weitere Informationen.
 * 
 * Dozent: Prof. Dr. rer. nat. Stephan Kleuker
 * Semester: SoSe 2022
 * Abgabe: 08. August 2022
 *  
 * @author Giuseppe Buccellato, Eric Walter
 */

package main;
import logic.Applikation;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Applikation app = Applikation.getInstance();
	}

}
