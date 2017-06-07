package uebungen_07_06_2017._18_Swing_AufgabenFH_01;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Quersumme {
	final static JFrame window = new JFrame();
	
	static{
		window.setTitle("Quersumme");
		window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel eingabeLabel = new JLabel("Eingabe:");
		JLabel quersummeLabel = new JLabel("Quersumme:");
		JTextField eingabeField = new JTextField(12);
		JTextField quersummeField = new JTextField(12);
	
		JPanel eingabePanel = new JPanel();
		JPanel quersummePanel = new JPanel();
		
		eingabePanel.add(eingabeLabel);
		eingabePanel.add(eingabeField);
		
		quersummePanel.add(quersummeLabel);
		quersummePanel.add(quersummeField);

		window.add(eingabePanel);
		window.add(quersummePanel);
		window.pack();
	}
	
	public static void showWindow(){
		window.setVisible(true);
	}
}
