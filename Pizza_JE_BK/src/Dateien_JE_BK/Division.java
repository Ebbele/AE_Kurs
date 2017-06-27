package Dateien_JE_BK;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Division {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Division();
	}

	
	Division() {
		JFrame frame = new JFrame("Zahlenteiler2000");
		frame.setSize(400, 100);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setLocation((int) ((d.getWidth() - frame.getWidth()) / 2), (int) ((d.getHeight() - frame.getHeight()) / 2));
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = new Container();
		container = frame.getContentPane();
		container.setLayout(new GridLayout(3,2));
		
		JLabel ldividend = new JLabel("dividend");
		container.add(ldividend);
		JTextField txtdividend = new JTextField();
		
		container.add(txtdividend);
		
		JLabel ldivisor = new JLabel("divisor");
		container.add(ldivisor);
		JTextField txtdivisor = new JTextField();
		container.add(txtdivisor);
		JLabel txtErgebnis = new JLabel("");
		container.add(txtErgebnis);
		
		
		
		//Rechnung bei Return ausführen und zurücksetzen
		txtdivisor.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ae) {
				if (ae.getKeyCode()==KeyEvent.VK_ENTER) {
					txtErgebnis.setText(integerDivision(txtdividend.getText(),txtdivisor.getText()));
					
					
					txtdividend.requestFocusInWindow();
					txtdivisor.setText("");
					txtdividend.setText("");
					
					
				}
			}
		});
		
		
		//Cursor Zurücksetzen
		txtdividend.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ae) {
				if (ae.getKeyCode()==KeyEvent.VK_ENTER) {
					txtdivisor.requestFocusInWindow();
					
				}
			}
		});
	
		
		
		
		frame.setVisible(true);
		
	}
	
	public String integerDivision(String dividend, String divisor) {
		double ergebnis=0;
		String rueck = new String("");
		try {
			if (dividend.equals("")||divisor.equals("")) {
				throw new IllegalArgumentException();
			}
			if (!isNumeric(dividend)||!isNumeric(divisor)) {
				throw new NumberFormatException();
			}
			if (divisor.equals("0")) {
				throw new ArithmeticException();
			}
			ergebnis = Double.parseDouble(dividend)/Double.parseDouble(divisor);
			DecimalFormat df = new DecimalFormat("0.00");
			rueck = dividend+" : "+divisor+" = "+String.valueOf(df.format(ergebnis));
			System.out.println(ergebnis);
			
		
		} catch (NumberFormatException f) {
			rueck = "Keine Zahl!";
			System.out.println("Darf nur Zahlen enthalten");	
		} catch (IllegalArgumentException e) {
			rueck = "Keine Eingabe!";
			System.out.println("Darf keinen Leerstring enthalten");
		} catch (ArithmeticException g) {
			rueck = "Durch Null geteilt!";
			System.out.println("durch nurr geteilt du Idiot");
		}
		return rueck;
		
		
	}
	public static boolean isNumeric( String string )
	  {
	    if ( string == null || string.length() == 0 )
	      return false;

	    for ( int i = 0; i < string.length(); i++ )
	      if ( ! Character.isDigit( string.charAt( i ) ) )
	        return false;

	    return true;
	  }
}
