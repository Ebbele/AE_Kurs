package uebungen_07_06_2017._18_Swing_AufgabenFH_01;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Oberflaechen extends JFrame {

	private static final long serialVersionUID = 1L;

	public Oberflaechen(String title) {
		//JFrame = new JFrame("Fenster auswählen");
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		// Palindrom Fenter Button
		JButton palindrom = new JButton("Palindrom");
		palindrom.setAlignmentX(Component.CENTER_ALIGNMENT);
		palindrom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Palindrom.showWindow();
			}
		});
		add(palindrom);

		JButton quersumme = new JButton("Quersumme");
		quersumme.setAlignmentX(Component.CENTER_ALIGNMENT);
		quersumme.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Quersumme.showWindow();
			}
		});
		add(quersumme);

		JButton euroUmrechner = new JButton("Euro Umrechner");
		euroUmrechner.setAlignmentX(Component.CENTER_ALIGNMENT);
		euroUmrechner.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EuroUmrechner.showWindow();
			}
		});
		add(euroUmrechner);

		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Oberflaechen oberflaeche = new Oberflaechen("Auswahl des Mini Programms");
	}

}
