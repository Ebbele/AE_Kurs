package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MeasurementsAverage {
	
	static Messwert erzeugeMesswert( int messNummer, int messReihe ) {
		
		Messwert messwert = new Messwert( messNummer, messReihe );
		return messwert;		
	}
	
	public static void main( String[ ] args ) {
		
		List< Messwert > messwerte = new ArrayList< Messwert >( );
		
		for( int messNummer = 0; messNummer < 10; messNummer++ ) {
			
			for( int messReihe = 0; messReihe < 14; messReihe++ ) {
				
				messwerte.add( erzeugeMesswert( messNummer, messReihe ) );				
			}			
		}
		
		List< Messwert > copyMesswerte = new CopyOnWriteArrayList< Messwert >( messwerte );
		Iterator< Messwert > messwertIter = copyMesswerte.iterator( );
		
		int anzahlMessungen = 0;
		int durchschnitt = 0;
		int gesamtdurchschnitt = 0;
		int puffer = 0;
		
		System.out.println( "Temperaturen in Grad Celsius" );
		System.out.println( "----------------------------" );
		
		while( messwertIter.hasNext( ) ) {
			
			puffer = messwertIter.next( ).getMesswert( );
			anzahlMessungen++;
			durchschnitt += puffer;
			
			System.out.print( puffer + " " );
			
			if ( anzahlMessungen % 10 == 0 ) {
				
				System.out.print( "- Durchschnitts-Temperatur: " + ( durchschnitt / 10 ) + System.lineSeparator( ) );
				gesamtdurchschnitt += durchschnitt;	
				durchschnitt = 0;
			}			
		}
		System.out.print( "Gesamt-Durchschnitts-Temperatur: " + ( gesamtdurchschnitt / anzahlMessungen ) );
	}
}
