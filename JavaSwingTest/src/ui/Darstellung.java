/**
 * Darstellungsklasse für die Verwaltung der UI-Elemente und Dialogboxen
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package ui;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.EventQueue;
import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Darstellung {

	private JFrame frmDigitalerVorratsschrank;

	public Darstellung() {
		initialize();
		frmDigitalerVorratsschrank.setVisible(true);
	}

	private void initialize() {
		frmDigitalerVorratsschrank = new JFrame();
		frmDigitalerVorratsschrank.setTitle("Digitaler Vorratsschrank");
		frmDigitalerVorratsschrank.setBounds(100, 100, 1280, 720);
		frmDigitalerVorratsschrank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDigitalerVorratsschrank.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder("Vorrat"));
		frmDigitalerVorratsschrank.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JPanel panel = new JPanel();
		frmDigitalerVorratsschrank.getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnHinzu = new JButton("Hinzufügen");
		panel_1.add(btnHinzu);
		btnHinzu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new DialogboxHinzu("Eintrag hinzufügen", true);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});

		JButton btnAendern = new JButton("Ändern");
		panel_1.add(btnAendern);
		btnAendern.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new DialogboxAendern("Eintrag ändern", true);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);		
			}
		});
		
		JButton btnEntfernen = new JButton("Entfernen");
		panel_1.add(btnEntfernen);
		btnEntfernen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new DialogboxEntfernen("Eintrag entfernen", true);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});

	}
	
	//TODO: Daten aus View darstellen!
	
}
