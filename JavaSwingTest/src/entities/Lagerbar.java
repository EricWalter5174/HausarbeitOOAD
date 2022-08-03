/**
 * Simple Java-Entität für Lagerbar-Objekte
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package entities;

import java.time.LocalDate;

public class Lagerbar {
	private String name;
	private Lagerort lagerort;
	private double preis;
	private LocalDate mindesthaltbarkeit;
	private Kategorie kategorie;
	
	public Lagerbar(String name, Lagerort lagerort, double preis, LocalDate mhd, Kategorie kategorie) {
		this.name = name;
		this.lagerort = lagerort;
		this.preis = preis;
		this.mindesthaltbarkeit = mhd;
		this.kategorie = kategorie;
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
		return name + " " + lagerort.getName() + " " + preis  + " " + mindesthaltbarkeit + " " + kategorie;
	}
	
	
}
