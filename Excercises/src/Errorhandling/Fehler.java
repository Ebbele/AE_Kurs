package Errorhandling;

public class Fehler {
	
	public static void fehler ( ) {
		int ai[] = { 0, 1, 2 };
		ai[ 3 ] = 4; // ArrayIndexOutOfBounds
	}
	
	public static void fehler2 ( ) {
		int i = 5 / 0; // ArithmeticException
	}
	
}
