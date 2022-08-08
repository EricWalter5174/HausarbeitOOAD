/**
 * Simple Java-Entität für Lagerbar-Objekte
 * Enthält einen static AtomicInteger, um hinzugefügte Objekte jeweils mit
 * inkrementierenden IDs zu versehen.
 * Neue Objekte werden mithilfe des LagerbarBuilder neu erzeugt
 * und vom LagerbarModel verwaltet.
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package entities;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Lagerbar {
	private static AtomicInteger count = new AtomicInteger(0); //inkrementelle ID für jeden Eintrag, Threadsafe
	private int id;
	private String name;
	private Lagerort lagerort;
	private double preis;
	private LocalDate mindesthaltbarkeit;
	private Kategorie kategorie;
	
	public Lagerbar(int id, String name, Lagerort lagerort, double preis, LocalDate mhd, Kategorie kategorie) {
		this.id = id;
		this.name = name;
		this.lagerort = lagerort;
		this.preis = preis;
		this.mindesthaltbarkeit = mhd;
		this.kategorie = kategorie;
	}

	/**
	 * Automatisch inkrementierender static Counter für Einträge.
	 */
	public static int incrementId() {
		return count.incrementAndGet();
	}
	
	/**
	 * Methode, um bei Löschung von Objekten den Counter zu aktualisieren.
	 * @param newCount
	 */
	public static void setCount(int newCount) {
		Lagerbar.count.set(newCount);
	}
	
	/**
	 * Individueller Setter, um bei Änderung eines Eintrags die
	 * bereits vorhandene ID zu bewahren.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Lagerort getLagerort() {
		return lagerort;
	}

	public double getPreis() {
		return preis;
	}

	public LocalDate getMindesthaltbarkeit() {
		return mindesthaltbarkeit;
	}

	public Kategorie getKategorie() {
		return kategorie;
	}

	@Override
	public String toString() {
		return name + " " + lagerort.getName() + " " + preis  + " " + formatDateString(mindesthaltbarkeit.toString()) + " " + kategorie.ordinal();
	}
	
	/**
	 * Generiert einen Datum-String ohne Bindestriche.
	 * Für das Abspeichern in der Outputdatei, damit das gleiche
	 * Format wie beim Input bewahrt bleibt. 
	 * @param str
	 */
	public static String formatDateString(String str) {
		return str.replace("-", "");
	}
	
}
