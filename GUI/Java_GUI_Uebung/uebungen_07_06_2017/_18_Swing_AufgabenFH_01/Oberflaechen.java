package uebungen_07_06_2017._18_Swing_AufgabenFH_01;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Oberflaechen extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Fenster auswählen");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout( frame.getContentPane(),BoxLayout.Y_AXIS));
		
		// Palindrom Fenter Button
		JButton palindrom = new JButton("Palindrom");
		palindrom.setAlignmentX(Component.CENTER_ALIGNMENT);
		palindrom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Palindrom.showWindow();
			}
		});
		frame.add(palindrom);
		
		JButton quersumme = new JButton("Quersumme");
		quersumme.setAlignmentX(Component.CENTER_ALIGNMENT);
		quersumme.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Quersumme.showWindow();
			}
		});
		frame.add(quersumme);
		
		JButton euroUmrechner = new JButton("Euro Umrechner");
		euroUmrechner.setAlignmentX(Component.CENTER_ALIGNMENT);
		euroUmrechner.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EuroUmrechner.showWindow();
			}
		});
		frame.add(euroUmrechner);
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}
