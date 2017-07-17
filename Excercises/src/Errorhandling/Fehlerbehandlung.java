package Errorhandling;

// Aufgabe 23
public class Fehlerbehandlung {

	public static void main ( String [ ] args) {
		
		try {
			Fehler.fehler();
			Fehler.fehler2();
		} catch ( ArrayIndexOutOfBoundsException e1 ) {
			System.out.println( "Fehler1: " + e1.toString( ) );
		} catch ( ArithmeticException e2 ) {
			System.out.println( "Fehler2: " + e2.toString( ) );
		}
	}
	
}
