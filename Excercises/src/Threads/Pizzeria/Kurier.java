package Threads.Pizzeria;

public class Kurier extends Thread {

	private PizzaSync ps;
	
	public Kurier( PizzaSync ps ) {
		
		this.ps = ps;
	}
	
	public void run( ) {
		
		int nummer = 1;
		while ( true ) {
			
			try {
				
				if ( ps.getPizza( ) == nummer ) {
					
					System.out.println( "Kurier: liefere Pizza Nr." + ps.getPizza( ) + " aus..." );
					Thread.sleep ( 15000 );
					ps.pizzaGeliefert( );
					nummer++;
				}
			} catch ( InterruptedException ie ) {
				
				System.err.println( "Exception" );
			}
		}
	}
}
