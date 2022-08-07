/**
 * Builder-Klasse für Lagerbar-Objekte
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LagerbarBuilder {
	private int id;
	private String name;
	private Lagerort lagerort;
	private double preis;
	private LocalDate mindesthaltbarkeit;
	private Kategorie kategorie;
	
	public LagerbarBuilder() {}
	
	public static LagerbarBuilder createBuilder() {
		return new LagerbarBuilder();
	}
	
	/**
	 * Generiert eine inkrementelle ID für jedes neu erstellte Objekt
	 */
	public LagerbarBuilder setId(int id) {
		this.id = Lagerbar.incrementId();
		return this;
	}
	
	/**
	 * Behält die ID eines zu ändernden Eintrags 
	 * bei ohne zu inkrementieren
	 */
	public LagerbarBuilder preserveId(int id) {
		this.id = id;
		return this;
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
	
	/**
	 * Überladung des Setters für Ordinale
	 *  
	 * @param kat
	 * @return this
	 */
	public LagerbarBuilder setKategorie(int kat) {
		if(kat < 0 || kat >= Kategorie.values().length) {
			this.kategorie = Kategorie.UNDEFINED;
			return this;
		}
		this.kategorie = Kategorie.values()[kat];
		return this;
	}
	
	public Lagerbar build() {
		return new Lagerbar(id, name, lagerort, preis, mindesthaltbarkeit, kategorie);
	}
	
	/**
	 * Hilfsmethoden, um Strings auf verschiedene Datentypen zu prüfen
	 */
	public static boolean isDouble(String str) {
	  	try {
	      	@SuppressWarnings("unused")			//Weil double x nur geprüft wird
	    	double x = Double.parseDouble(str);
	      	return true; 						//String enthält Double
		} catch (NumberFormatException e) {
	    	return false; 						//String enthält keinen Double
		}
	  	
	}
	
	public static boolean isDate(String s) {
		try {
			@SuppressWarnings("unused")	
			LocalDate d = LocalDate.parse(s, DateTimeFormatter.BASIC_ISO_DATE);
			return true;
		} catch(DateTimeParseException e) {
			return false;
		}
	}
	
	public static boolean isInt(String str) {
	  	try {
	      	@SuppressWarnings("unused")
	    	int x = Integer.parseInt(str);
	      	return true;
		} catch (NumberFormatException e) {
	    	return false; 
		}
	  	
	}
}
