/**
 * Darstellungsklasse für die Verwaltung der UI-Elemente und Dialogboxen
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
	
	private JScrollPane scrollPane;
	
	private LagerbarView lagerView = new LagerbarView();

	public Darstellung(ArrayList<Lagerbar> liste) {
		this.lagerTable = initTabelle(liste);
		this.lagerTable.getModel().addTableModelListener(this);
		
		initDarstellung(this.lagerTable);
		frmDigitalerVorratsschrank.setVisible(true);
	}

	private void initDarstellung(JTable table) {
		frmDigitalerVorratsschrank = new JFrame();
		frmDigitalerVorratsschrank.setTitle("Digitaler Vorratsschrank");
		frmDigitalerVorratsschrank.setBounds(100, 100, 1280, 720);
		frmDigitalerVorratsschrank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDigitalerVorratsschrank.getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBorder(new TitledBorder("Vorrat"));
		frmDigitalerVorratsschrank.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frmDigitalerVorratsschrank.getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		/**
		 * Der Hinzufügen-Button benachrichtigt das LagerbarView 
		 */
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
	
	public JTable initTabelle(ArrayList<Lagerbar> liste) {
		String[] spaltennamen = {"Name", "Lagerort", "Preis", "Verfallsdatum", "Kategorie"};
		Object[][] daten = new Object[liste.size()][spaltennamen.length];
		
		int idCount = 0;
		
		for(int row = 0; row < daten.length; row++) {
			for(int col = 0; col < daten[row].length; col++) {
				
				switch(col) {
				case 0:
					daten[row][col] = liste.get(idCount).getName();
					break;
				case 1:
					daten[row][col] = liste.get(idCount).getLagerort().getName();
					break;
				case 2:
					daten[row][col] = liste.get(idCount).getPreis();
					break;	
				case 3:
					daten[row][col] = liste.get(idCount).getMindesthaltbarkeit();
					break;
				case 4:
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

	public void updateTabelle(JTable table) {
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
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
		
	}
	
}
