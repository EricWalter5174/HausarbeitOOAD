/**
 * Dialogbox zum Ändern eines Eintrags.
 * @param modal auf true gesetzt, damit der Fokus auf den Dialog beibehalten wird.
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entities.Kategorie;
import entities.Lagerbar;
import entities.LagerbarBuilder;
import entities.Lagerort;
import views.LagerbarView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DialogboxAendern extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private LagerbarView lagerView = new LagerbarView();
	private Lagerbar geaendertesLagerbar;
	
	private JTextField nameTextField;
	private JTextField preisTextField;
	private JTextField verfallTextField;
	private JComboBox<Object> comboBoxLagerort;
	private JComboBox<Kategorie> comboBoxKategorie;

	public DialogboxAendern(String title, boolean modal, ArrayList<Lagerort> orte, Lagerbar lagerbar) {
		setTitle(title);
		setModal(modal);
		setBounds(0, 0, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(6, 3, 0, 0));
		{
			JLabel lblNewLabel = new JLabel("Neuer Name");
			contentPanel.add(lblNewLabel);
		}
		{
			nameTextField = new JTextField();
			contentPanel.add(nameTextField);
			nameTextField.setColumns(10);
			nameTextField.setToolTipText("Name");
			nameTextField.setText(lagerbar.getName());
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Neuer Lagerort");
			contentPanel.add(lblNewLabel_1);
		}
		{
			comboBoxLagerort = new JComboBox<>();
			comboBoxLagerort.setModel(new DefaultComboBoxModel<>(orte.toArray()));
			contentPanel.add(comboBoxLagerort);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Neuer Preis");
			contentPanel.add(lblNewLabel_2);
		}
		{
			preisTextField = new JTextField();
			contentPanel.add(preisTextField);
			preisTextField.setColumns(10);
			preisTextField.setToolTipText("Preis");
			preisTextField.setText("" + lagerbar.getPreis());
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Neues Verfallsdatum");
			contentPanel.add(lblNewLabel_3);
		}
		{
			verfallTextField = new JTextField();
			contentPanel.add(verfallTextField);
			verfallTextField.setColumns(10);
			verfallTextField.setToolTipText("Verfallsdatum");
			verfallTextField.setText(Lagerbar.formatDateString(lagerbar.getMindesthaltbarkeit().toString()));
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Neue Kategorie");
			contentPanel.add(lblNewLabel_4);
		}
		{
			comboBoxKategorie = new JComboBox<>();
			comboBoxKategorie.setModel(new DefaultComboBoxModel<>(Kategorie.values()));
			contentPanel.add(comboBoxKategorie);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {						
						//Änderungen einlesen und verarbeiten
						if(aenderungenVerarbeiten(lagerbar.getId(),
												nameTextField.getText(),
												comboBoxLagerort.getSelectedItem(),
												preisTextField.getText(),
												verfallTextField.getText(),
												comboBoxKategorie.getSelectedIndex()))
						{
							//Geändertes Lagerbar-Objekt über View an Verwaltung vermitteln
							lagerView.registriereAenderungAnEintrag(geaendertesLagerbar);
							dispose();
						}
					}
						
				});
			}
			{
				JButton cancelButton = new JButton("Abbrechen");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//Abbrechen und Dialog schließen
						dispose();
					}
				});
			}
		}
	
	}
	
	/**
	 * Diese Methode liest und verarbeitet alle Nutzereingaben im Ändern-Dialog.
	 * Sind alle Eingaben als gültig befunden, wird mithilfe des Builders ein neues Lagerbar 
	 * erzeugt und zum Aktualisieren an die Verwaltung gereicht.
	 * 
	 * @param id				Die ursprüngliche ID soll beibehalten werden.
	 * @param name 				Sollte mindestens ein Zeichen umfassen
	 * @param ort 				wird als Object übergeben und später zu Lagerort gecastet
	 * @param preis 			Als String gelesen und später als Double geparsed
	 * @param verfallsdatum 	Als String gelesen und im Builder zu LocalDate geparsed
	 * @param kat				
	 * @return					true, wenn alle Eingaben gültig
	 */
	private boolean aenderungenVerarbeiten(int id, String name, Object ort, String preis, String verfallsdatum, int kat) {
			
		if(name == null || name.isEmpty()) {
			JOptionPane.showMessageDialog(this, 
					"Name darf nicht leer sein.");
			return false;
		}
		
		if(ort == null) {
			ort = new Lagerort("undefined");
		}
		
		if(preis == null || preis.isEmpty()) {
			preis = "0.00";	
		}else if(!LagerbarBuilder.isDouble(preis)) {
			JOptionPane.showMessageDialog(this, 
					"Preis bitte im Format '0.00' oder das Feld leer lassen.");
			return false;
		}
		
		if(verfallsdatum == null || verfallsdatum.isEmpty()) {
			verfallsdatum = "00000101";
		}else if(!LagerbarBuilder.isDate(verfallsdatum)) {
			JOptionPane.showMessageDialog(this, 
					"Datum bitte im Format 'YYYYMMDD' oder das Feld leer lassen.");
			return false;
		}
		
		if(kat < 0 || kat >= Kategorie.values().length) {
			kat = 0;
		}
		
		//Akzeptierte Eingaben nutzen, um neues Lagerbar zu bauen
		this.geaendertesLagerbar = new LagerbarBuilder()
								.preserveId(id)
								.setName(name)
								.setLagerort(((Lagerort) ort).getName())
								.setPreis(Double.parseDouble(preis))
								.setMindesthaltbarkeit(verfallsdatum)
								.setKategorie(kat)
								.build();
		
		return true;
	}
}
