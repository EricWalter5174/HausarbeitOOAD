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
		this.kategorie = new Kategorie(s);
		return this;
	}
	
	public Lagerbar build() {
		return new Lagerbar(name, lagerort, preis, mindesthaltbarkeit, kategorie);
	}
}
