package Dateien_JE_BK;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Division {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Division();
	}

	
	Division() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = new Container();
		container = frame.getContentPane();
		container.setLayout(new GridLayout(2,2));
		
		JLabel ldividend = new JLabel("dividend");
		container.add(ldividend);
		JTextField txtdividend = new JTextField();
		container.add(txtdividend);
		
		JLabel ldivisor = new JLabel("divisor");
		container.add(ldivisor);
		JTextField txtdivisor = new JTextField();
		txtdivisor.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ae) {
				if (ae.getKeyCode()==KeyEvent.VK_ENTER) {
					integerDivision(txtdividend.getText(),txtdivisor.getText());
					
					
				}
			}
		});
		container.add(txtdivisor);
		
		
		
		
		frame.setSize(200, 100);
		frame.setVisible(true);
		
	}
	
	public void integerDivision(String dividend, String divisor) {
		
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
			double ergebnis = Double.parseDouble(dividend)/Double.parseDouble(divisor);
			System.out.printf("%.2f\n",ergebnis);
		
		} catch (NumberFormatException f) {
			System.out.println("Darf nur Zahlen enthalten");	
		} catch (IllegalArgumentException e) {
			System.out.println("Darf keinen Leerstring enthalten");
		} catch (ArithmeticException g) {
			System.out.println("durch nurr geteilt du Idiot");
		}
		
		
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
