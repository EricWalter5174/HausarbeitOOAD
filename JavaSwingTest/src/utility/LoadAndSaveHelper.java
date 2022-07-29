package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Lagerbar;
import logic.LagerbarBuilder;

public class LoadAndSaveHelper {
	private Scanner scanner;
	private ArrayList<Lagerbar> liste;
	
	public LoadAndSaveHelper(){
	}
	
	public ArrayList<Lagerbar> ladeDaten(File f) throws FileNotFoundException {
		scanner = new Scanner(f);
		while(scanner.hasNextLine()) {
			liste.add(new LagerbarBuilder()
					.setName(scanner.next())
					.setLagerort(scanner.next())
					.setPreis(scanner.nextDouble())
					.setMindesthaltbarkeit(scanner.next())
					.setKategorie(scanner.next())
					.build());
		}
		return liste;
	}
	
	public void speichereDaten() throws IOException {
		FileWriter fw = new FileWriter(new File("daten/testdaten.txt"));
		for(Lagerbar l : liste) {
			fw.write(l.toString());
		}
		fw.close();
	}
}
