package ui;
import javax.swing.*;

public class Darstellung {
	private JFrame fenster;
	
	
	public Darstellung() {
		initialisiereFenster();
		//TODO: GridLayout recherchieren und hinzufuegen
	}
	
	private void initialisiereFenster() {
		this.fenster = new JFrame("Digitaler Vorratsschrank");
		fenster.setSize(1280, 720);
		initialisiereKomponenten();
		fenster.setLayout(null);
		fenster.setVisible(true);
	}
	
	private void initialisiereKomponenten() {
		JButton b = new JButton("Anus");
		b.setBounds(50, 50, 80, 40);
		fenster.add(b);
	}
	
}
