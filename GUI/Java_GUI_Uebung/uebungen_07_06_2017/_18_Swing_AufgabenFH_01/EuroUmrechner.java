package uebungen_07_06_2017._18_Swing_AufgabenFH_01;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EuroUmrechner {
	final static JFrame window = new JFrame();
	
	static{
		window.setTitle("Euro Umrechner");
		window.setLayout(new BorderLayout(8,8));

		JTextField eingabe = new JTextField();
		
		JButton eurToDm = new JButton("EUR -> DM");
		JButton dmToEur = new JButton("DM -> EUR");
		JButton cancel = new JButton("Abbrechen");
		
		window.add(eingabe, BorderLayout.NORTH);
		window.add(eurToDm, BorderLayout.LINE_START);
		window.add(dmToEur, BorderLayout.CENTER);
		window.add(cancel, BorderLayout.LINE_END);
		window.pack();
	}
	
	public static void showWindow(){
		window.setVisible(true);
	}
}
