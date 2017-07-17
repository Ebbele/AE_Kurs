package inheritance_polymorphism.Mitarbeiter;

public class Hilfsarbeiter extends Mitarbeiter {
	
	Hilfsarbeiter( int personalNr, String name, String datumEintritt, 
			double stundenlohn, double anzahlStunden, double ueberStundenZuschlag, double anzahlUeberstunden ) {
		
		super( personalNr, name, datumEintritt, stundenlohn, anzahlStunden, 
				ueberStundenZuschlag, anzahlUeberstunden );
	}
	
	public double berechneMonatsgehalt( ) {
		
		return ( getStundenlohn( )* getAnzahlStunden( ) ) 
				+ ( getUeberStundenZuschlag( ) * getUeberStundenZuschlag( ) );
	}
}
