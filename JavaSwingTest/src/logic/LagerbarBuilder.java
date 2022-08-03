/**
 * Builder-Klasse für Lagerbar-Objekte
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package logic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import entities.Kategorie;
import entities.Lagerbar;
import entities.Lagerort;

public class LagerbarBuilder {
	private String name;
	private Lagerort lagerort;
	private double preis;
	private LocalDate mindesthaltbarkeit;
	private Kategorie kategorie;
	
	public LagerbarBuilder() {}
	
	public static LagerbarBuilder createBuilder() {
		return new LagerbarBuilder();
	}
	
	public LagerbarBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public LagerbarBuilder setLagerort(String name) {
		this.lagerort = new Lagerort(name);
		return this;
	}

	public LagerbarBuilder setPreis(double preis) {
		this.preis = preis;
		return this;
	}
	
	public LagerbarBuilder setMindesthaltbarkeit(String s) {
		//https://www.baeldung.com/java-string-to-date
		//Das Datum besitzt BASIC ISO DATE Form JAHR-MONAT-TAG 
		//Bsp: 20231230 = 30.12.2023
		this.mindesthaltbarkeit = LocalDate.parse(s, DateTimeFormatter.BASIC_ISO_DATE);
		return this;
	}
	
	public LagerbarBuilder setKategorie(String s) {
		if(s != null) {
			if(!isInt(s)) { 								//wenn kein Integer, setze Kategorie auf Defaultwert
				this.kategorie = Kategorie.UNDEFINED;
				return this;
			}
			int x = Integer.parseInt(s);
			if (x >= 0 && x <= Kategorie.values().length) { //Wert ist ein gültiges Ordinal
				this.kategorie = Kategorie.values()[x];
			}else {
				this.kategorie = Kategorie.UNDEFINED;
			}
		}
		return this;
	}
	
	public Lagerbar build() {
		return new Lagerbar(name, lagerort, preis, mindesthaltbarkeit, kategorie);
	}
	
	/**
	 * Hilfsmethode, um String auf Integer zu prüfen
	 */
	public boolean isInt(String str) {
	  	try {
	      	@SuppressWarnings("unused")			//Weil int x nur geprüft wird
	    	int x = Integer.parseInt(str);
	      	return true; 						//String enthält Integer
		} catch (NumberFormatException e) {
	    	return false; 						//String enthält keinen Integer
		}
	  	
	}
}
