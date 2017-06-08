package uebungen_07_06_2017._18_Swing_AufgabenFH_01;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Palindrom {
	final static JFrame window = new JFrame();

	static {
		window.setTitle("Palindrom");
		GridBagLayout layout = new GridBagLayout();
		window.setLayout(layout);
		JLabel label = new JLabel("Eingabestring:");
		JTextField eingabe = new JTextField("", 24);
		JButton btn = new JButton("Palindrom ?");

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = eingabe.getText();
				if (!str.isEmpty()) {
					JOptionPane.showMessageDialog(window, str + " ist " + isPalindrom(str.toLowerCase()) + " Palindrom !");
				}
			}
		});

		GridBagConstraints constraint = new GridBagConstraints();

		constraint.fill = GridBagConstraints.BOTH;
		constraint.insets = new Insets(8, 8, 8, 8);
		// Layout Label
		constraint.gridx = 0;
		layout.setConstraints(label, constraint);

		// Layout Text Eingabe
		constraint.gridx = 1;
		layout.setConstraints(eingabe, constraint);

		// Layout Button
		constraint.insets = new Insets(0, 0, 0, 0);
		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(btn, constraint);

		window.add(label);
		window.add(eingabe);
		window.add(btn);
		window.pack();
	}

	public static String isPalindrom(String str) {
		
		char src[] = str.toCharArray();
		for(int c = 0, max = str.length()/2; c < max; c++){
			if( !(str.charAt(str.length()-c-1) == src[c]) )
				return "kein";
		}
		
		return "ein";
	}

	public static void showWindow() {
		window.setVisible(true);
	}
}
