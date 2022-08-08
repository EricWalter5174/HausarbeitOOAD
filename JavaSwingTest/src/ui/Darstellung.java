/**
 * Darstellungsklasse für die Verwaltung der UI-Elemente und Dialogboxen.
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package ui;

import javax.swing.*;
import javax.swing.table.TableModel;

import entities.LagerTableModel;
import entities.Lagerbar;
import views.LagerbarView;

import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Darstellung implements TableModelListener {

	private JFrame frmDigitalerVorratsschrank;
	private LagerTableModel lagerTableModel;
	private JTable lagerTable;
	
	private JPanel panel, panel_1;
	private JScrollPane scrollPane;
	
	private LagerbarView lagerView = new LagerbarView();

	public Darstellung(ArrayList<Lagerbar> liste) {
		this.lagerTable = initTabelle(liste);
		this.lagerTable.getModel().addTableModelListener(this);
		
		initDarstellung(this.lagerTable);
		frmDigitalerVorratsschrank.setVisible(true);
	}

	/**
	 * Initialisiert die Darstellung mit dem Frame, den Panels 
	 * und den darin angezeigten Komponenten und Buttons.
	 * Durch ActionListener werden Nutzerinteraktionen interpretiert.
	 * 
	 * @param table
	 */
	private void initDarstellung(JTable table) {
		frmDigitalerVorratsschrank = new JFrame();
		frmDigitalerVorratsschrank.setTitle("Digitaler Vorratsschrank");
		frmDigitalerVorratsschrank.setBounds(0, 0, 800, 600);
		frmDigitalerVorratsschrank.setLocationRelativeTo(null);
		frmDigitalerVorratsschrank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDigitalerVorratsschrank.getContentPane().setLayout(new BorderLayout(0, 0));
				
		panel = new JPanel();
		frmDigitalerVorratsschrank.getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBorder(new TitledBorder("Vorrat"));
		frmDigitalerVorratsschrank.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JButton btnHinzu = new JButton("Hinzufügen");
		panel_1.add(btnHinzu);
		btnHinzu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lagerView.hinzuButtonClick();
			}
		});

		JButton btnAendern = new JButton("Ändern");
		panel_1.add(btnAendern);
		btnAendern.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int selected = lagerTable.getSelectedRow();
				if(lagerTable.getSelectedRowCount() != 1) {
					JOptionPane.showMessageDialog(frmDigitalerVorratsschrank, 
							"Es kann nur eine Zeile zum Bearbeiten gewählt werden.");
				}else {
					lagerView.aendernButtonClick(getIdColumn(selected));		
				}
			}
		});
		
		JButton btnEntfernen = new JButton("Entfernen");
		panel_1.add(btnEntfernen);
		btnEntfernen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selected = lagerTable.getSelectedRow();
				if(lagerTable.getSelectedRowCount() != 1) {
					JOptionPane.showMessageDialog(frmDigitalerVorratsschrank, 
							"Es kann nur eine Zeile zum Entfernen gewählt werden.");
				}else {
					lagerView.entfernenButtonClick(getIdColumn(selected));		
				}
			}
		});
	}
	
	/**
	 * Befüllt ein 1D-Array mit Strings der Spaltennamen
	 * und ein 2D-Array mit der Datenmatrix der aus der "Datenbank"
	 * eingelesen Lagerbarobjekte.
	 * Erstellt und initialisiert ein TableModel mit den erfassten Daten.
	 * Gibt eine JTable mit dem TableModel als Basis zurück.
	 * 
	 * @param liste
	 * @return Eine neue JTable, die zur Darstellung genutzt wird
	 */
	public JTable initTabelle(ArrayList<Lagerbar> liste) {
		String[] spaltennamen = {"ID", "Name", "Lagerort", "Preis", "Verfallsdatum", "Kategorie"};
		Object[][] daten = new Object[liste.size()][spaltennamen.length];
		
		int idCount = 0;
		
		for(int row = 0; row < daten.length; row++) {
			for(int col = 0; col < daten[row].length; col++) {
				
				switch(col) {
				case 0:
					daten[row][col] = liste.get(idCount).getId();
					break;
				case 1:
					daten[row][col] = liste.get(idCount).getName();
					break;
				case 2:
					daten[row][col] = liste.get(idCount).getLagerort().getName();
					break;
				case 3:
					daten[row][col] = liste.get(idCount).getPreis();
					break;	
				case 4:
					daten[row][col] = liste.get(idCount).getMindesthaltbarkeit();
					break;
				case 5:
					daten[row][col] = liste.get(idCount).getKategorie();
					break;
				default:
					daten[row][col] = "-";
				}
			}
			idCount++;
		}
		
		this.lagerTableModel = new LagerTableModel(spaltennamen, daten);
		return new JTable(lagerTableModel);
	}

	/**
	 * Aktualisiert die angezeigte Tabelle im Hauptfenster nachdem
	 * Änderungen durchgeführt wurden.
	 * 
	 * @param table			
	 */
	public void updateTabelle(JTable table) {
		scrollPane.remove(lagerTable);
		this.lagerTable = table;
		this.lagerTableModel.fireTableDataChanged();
		scrollPane.setViewportView(lagerTable);
		lagerTable.setFillsViewportHeight(true);
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        @SuppressWarnings("unused")
        String columnName = model.getColumnName(column);
        @SuppressWarnings("unused")
        Object data = model.getValueAt(row, column);
	}
	
	/**
	 * Ermittelt die ID des ausgewählten Eintrags 
	 * durch das Auslesen der Spalte ID an der übergebenen Zeile.
	 * 
	 * @param selected 				Index der ausgewählten Zeile 
	 */
	private int getIdColumn(int selected) {
		return (int) lagerTableModel.getValueAt(selected, 0);
	}
}
