package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import utility.LoadAndSaveHelper;

public class LagerbarModel {
	private ArrayList<Lagerbar> liste;
	private LoadAndSaveHelper loader;
	
	public LagerbarModel() throws FileNotFoundException {
		loader = new LoadAndSaveHelper();
		liste = loader.ladeDaten(new File("daten/testdaten.txt"));
	}
	
}
