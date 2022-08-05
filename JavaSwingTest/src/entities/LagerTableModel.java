/**
 * Individuelles Datenmodell für das Tabellenobjekt im Hauptfenster.
 * Die Darstellung übernimmt die Daten aus dem LagerbarView und erlaubt dem Nutzer
 * die Bearbeitung. Bei Änderungen soll das LagerbarView informiert werden
 * und ein Update von der Verwaltung fordern. 
 * 
 * @author Giuseppe Buccellato
 */

package entities;

import javax.swing.table.AbstractTableModel;

public class LagerTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private String[] spaltennamen;
	private Object[][] daten;
	
	public LagerTableModel(String[] spaltennamen, Object[][] daten) {
		setSpaltennamen(spaltennamen);
		setDaten(daten);
	}
	
	public String[] getSpaltennamen() {
		return spaltennamen;
	}

	private void setSpaltennamen(String[] spaltennamen) {
		this.spaltennamen = spaltennamen;
	}

	public Object[][] getDaten() {
		return daten;
	}

	private void setDaten(Object[][] daten) {
		this.daten = daten;
	}

	@Override
	public int getRowCount() {
		return daten.length;
	}

	@Override
	public int getColumnCount() {
		return spaltennamen.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return daten[rowIndex][columnIndex];
	}

	public String getColumnName(int col) {
        return spaltennamen[col].toString();
    }
	
	public void setValueAt(Object value, int row, int col) {
        daten[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
