/**
 * Darstellungsklasse für das Applikationsfenster und das UI.
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package ui;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class Darstellung extends JFrame {
	
	private static final long serialVersionUID = 190019651065330528L;

	public Darstellung() {
		
		initialisiereFenster();
		initialisiereContainer();
		//TODO: GridLayout recherchieren und hinzufuegen
	}
	
	private void initialisiereFenster() {
		setTitle("Digitaler Vorratsschrank");
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initialisiereContainer() {
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		JButton beenden = new JButton("Beenden");
		
		beenden.setVisible(true);
		container.add(beenden);
		
	}
	
	
}
