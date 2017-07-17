package Threads.Pizzeria;

import java.util.Random;

public class Pizzaiolo extends Thread {

	private PizzaSync ps;
	Random rand = new Random( );
	
	public Pizzaiolo( PizzaSync ps ) {
		
		this.ps = ps;
	}
	public void run( ) {
		
		int nummer = 0;
		
		while ( true ) {
			
			try {
				
				Thread.sleep( 3000 + rand.nextInt( 10001 ) );
			} catch ( InterruptedException ie ) {
				
				System.err.println( "Exception" );
			}
			++nummer;
			System.out.println( "Pizza " + nummer + " bestellt" );
			
			try {
				Thread.sleep( 7000 );
			} catch ( InterruptedException ie ) {
				
				System.err.println( "Exception" );
			}
			System.out.println( "Pizza "  + nummer + " zubereitet" );
			ps.lieferePizza( nummer );
		}
	}
}
