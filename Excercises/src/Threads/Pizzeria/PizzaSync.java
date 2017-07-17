package Threads.Pizzeria;

public class PizzaSync {
	
	private int pizza;
	Kurier k;
	Pizzaiolo p;
	
	public synchronized void lieferePizza( int pizza ) {
		
		this.pizza = pizza;
		System.out.println( "Pizza " + getPizza( ) + " an Kurier übergeben" );
		
		try {
			
			wait( );
		} catch (InterruptedException e) {
			
			System.out.println( "Exception" );
		}
	}
	
	public synchronized int getPizza( ) {
		
		return pizza;
	}
	
	public synchronized void pizzaGeliefert( ) {
		
		System.out.println( this.pizza + " Pizza ausgeliefert." );
		notifyAll( );
	}
	
}
