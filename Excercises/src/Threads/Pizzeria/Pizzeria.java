package Threads.Pizzeria;

public class Pizzeria {

	public static void main( String[ ] args ) {
		
		PizzaSync ps = new PizzaSync( );
		Pizzaiolo p = new Pizzaiolo( ps );
		Kurier kurier = new Kurier( ps );
		
		synchronized ( ps ) {
			
			p.start( );
			kurier.start( );		
		}
	}
}
