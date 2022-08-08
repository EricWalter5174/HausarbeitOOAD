/**
 * Dialogbox zum Entfernen eines Eintrags.
 * @param modal auf true gesetzt, damit der Fokus auf den Dialog beibehalten wird.
 * 
 * @author Giuseppe Buccellato, Eric Walter
 */

package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Lagerbar;
import views.LagerbarView;

import javax.swing.JLabel;

public class DialogboxEntfernen extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private LagerbarView lagerView = new LagerbarView();

	public DialogboxEntfernen(String title, boolean modal, Lagerbar lagerbar) {
		
		setTitle(title);
		setModal(modal);
		setBounds(0, 0, 450, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblNewLabel = new JLabel("Eintrag '" + lagerbar.getName() + "' wird entfernt. Fortfahren?");
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ja, aber hallo!");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//ID zum Entfernen an View vermitteln
						lagerView.registriereEntfernen(lagerbar.getId());
						dispose();
					}
				});
			}
			{
				JButton cancelButton = new JButton("Moment, lieber nicht!");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//Abbrechen und schließen
						dispose();
					}
				});
			}
		}
	}

}
