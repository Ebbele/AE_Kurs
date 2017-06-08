package uebungen_07_06_2017._18_Swing_AufgabenFH_01;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Quersumme {
	final static JFrame window = new JFrame();

	static {
		window.setTitle("Quersumme");
		window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));

		JLabel eingabeLabel = new JLabel("Eingabe:");
		JLabel quersummeLabel = new JLabel("Quersumme:");
		JTextField eingabeField = new JTextField(12);
		JTextField quersummeField = new JTextField(12);
		
		eingabeField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					try{
						String eingabeStr = eingabeField.getText();
						int len = eingabeStr.length();
						Integer.parseInt(eingabeStr);
						char zahlen[] = eingabeStr.toCharArray();
						int sum = 0;
						for(int c = 0; c < len; c++){
							 sum += Integer.parseInt(String.valueOf(zahlen[c]));
						}
						quersummeField.setText(String.valueOf(sum));
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(window, "Keine Ganzzahl eingegeben", "Fehler", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

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

	public static void showWindow() {
		window.setVisible(true);
	}
}
