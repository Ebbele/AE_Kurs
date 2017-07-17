package Threads.Schoepfer;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Schoepfer extends Thread {

	String aufgabe;
	Random rd;
	int zulauf, ablauf;
	
	private static volatile int trog;
	
	private static final Lock lock = new ReentrantLock();
	private static final Condition c = lock.newCondition();
	
	static {
		
		trog = 0;
	}
	
	Schoepfer( String aufgabe ) {
		
		setAufgabe( aufgabe );
	}
	
	public String getAufgabe() {
		
		return aufgabe;
	}

	public void setAufgabe(String aufgabe) {
		
		this.aufgabe = aufgabe;
	}
	
	public int getTrog() {
	
		return trog;
	}
	
	public static void incrementTrog( int zulauf ) {
		
		lock.lock( );
		
		try {
			
			Schoepfer.trog += zulauf;
			c.signalAll( );
		} finally {
			
			lock.unlock( );
		}
	}
	
	public static void decrementTrog( int ablauf ) {
		
		lock.lock( );
		
		try {
			
			while ( trog < ablauf ) {			
				
				try {
					
					c.await();
				} catch ( InterruptedException e ) {

					System.err.println( e.toString( ) );
				}
			}
			
			Schoepfer.trog -= ablauf;			
		} finally {
			
			lock.unlock( );
		}
	}
	
	public int erzeugeZufallsMenge( ) {
		
		rd = new Random( );
		int zufallszahl = rd.nextInt( 20 );
		return zufallszahl;		
	}
	
	@Override
	public void run( ) {
		
		switch ( getAufgabe( ) ) {
		
			case "pumpe":
				
				while( true ) {
					
					try {

						zulauf = erzeugeZufallsMenge( );
						incrementTrog( zulauf );
						System.out.println( "Pumpe: " + zulauf + " Liter Wasser hinzugefügt -> Neue Gesamtmenge: " + getTrog( ) );
						sleep( 1000 );
							
					} catch ( InterruptedException e ) {
					}
				}
					
			case "verteiler":

				while( true ) {
					
					try {
						
						ablauf = erzeugeZufallsMenge( );
						decrementTrog( ablauf );
						System.out.println( "Verteiler: " + ablauf + " Liter Wasser abgeschöpft -> Neue Gesamtmenge: " + getTrog( ) );
						sleep( 1000 );
						
					} catch ( InterruptedException e ) {
					}
				}
					
			default:
				System.out.println( "Es konnte keine Aufgabe zugeordnet werden. - Thread beendet!" );
		}
	}
}