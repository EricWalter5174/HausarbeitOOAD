package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.GridLayout;


public class Darstellung {

	private JFrame frmDigitalerVorratsschrank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Darstellung window = new Darstellung();
					window.frmDigitalerVorratsschrank.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Darstellung() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		
		JButton btnAendern = new JButton("Ändern");
		panel_1.add(btnAendern);
		
		JButton btnEntfernen = new JButton("Entfernen");
		panel_1.add(btnEntfernen);
	}

}
