/**
 * Simple Java-Entität für Lagerbar-Objekte
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package entities;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Lagerbar {
	private static final AtomicInteger count = new AtomicInteger(0); //inkrementelle ID für jeden Eintrag, Threadsafe
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

	public static int incrementId() {
		return count.incrementAndGet();
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
	
	private String formatDateString(String str) {
		return str.replace("-", "");
	}
	
}
