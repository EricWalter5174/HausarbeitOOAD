package entities;

import java.util.Date;

import utility.Kategorie;

public class Lagerbar {
	private String name;
	private Lagerort lagerort;
	private double preis;
	private Date mindesthaltbarkeit;
	private Kategorie kategorie;
	
	public Lagerbar(String name, Lagerort lagerort, double preis, Date mhd, Kategorie kategorie) {
		this.name = name;
		this.lagerort = lagerort;
		this.preis = preis;
		this.mindesthaltbarkeit = mhd;
		this.kategorie = kategorie;
	}
	
	
}
