package logic;

import java.util.Date;

import entities.Lagerbar;
import entities.Lagerort;
import utility.Kategorie;

public class LagerbarBuilder {
	private String name;
	private Lagerort lagerort;
	private double preis;
	private Date mindesthaltbarkeit;
	private Kategorie kategorie;
	
	public LagerbarBuilder() {}
	
	public static LagerbarBuilder createBuilder() {
		return new LagerbarBuilder();
	}
	
	public LagerbarBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public LagerbarBuilder setLagerort(Lagerort lagerort) {
		this.lagerort = lagerort;
		return this;
	}

	public LagerbarBuilder setPreis(double preis) {
		this.preis = preis;
		return this;
	}
	
	public LagerbarBuilder setMindesthaltbarkeit(Date date) {
		this.mindesthaltbarkeit = date;
		return this;
	}
	
	public LagerbarBuilder setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
		return this;
	}
	
	public Lagerbar build() {
		return new Lagerbar(name, lagerort, preis, mindesthaltbarkeit, kategorie);
	}
}
