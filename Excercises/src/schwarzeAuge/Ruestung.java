package schwarzeAuge;

import java.util.Objects;

// Ruestungsklasse wird benötigt sowohl zur Komplettierung des Objektgraphen, als auch zur Erstellung der jeweiligen Objektlisten, auf denen wir arbeiten 
// und diese ggfls. über eine Schnittstelle an andere Teams weiterleiten

public class Ruestung extends Item{

	private String bezeichnung;
	private int ruestungsWert;
	
	public String getBezeichnung( ) {
		return bezeichnung;
	}

	public void setBezeichnung( String bezeichnung ) {
		this.bezeichnung = Objects.requireNonNull( bezeichnung, "NULL - var: bezeichnung klasse: Ruestung.java" );
	}

	public int getRuestungsWert( ) {
		return ruestungsWert;
	}

	public void setRuestungsWert( int ruestungsWert ) {
		this.ruestungsWert = Objects.requireNonNull( ruestungsWert, "NULL - var: ruestungsWert klasse: Ruestung.java" );
	}
	
	@Override
	public String toString( ) {
		return "Bezeichnung: " + getBezeichnung( ) + 
				" " +
				"Ruestungswert: " + getRuestungsWert( );
	}
	
	@Override
	public boolean equals( final Object other ) {
		if( other == null ) // Null-Akzeptanz
			return false;
		if( this == other ) // Reflexivität
			return true;
		if( this.getClass( ) != other.getClass( ) ) // Typgleichheit sicherstellen
			return false;
		final Ruestung otherRuestung = ( Ruestung ) other; // Attribute pruefen
		return compareAttributes( otherRuestung );
	}
	
	private boolean compareAttributes( final Ruestung otherRuestung ) { // Hilfsmethode für equals
		return this.getBezeichnung( ).equals( otherRuestung.getBezeichnung( ) ) &&
				this.getRuestungsWert( ) == otherRuestung.getRuestungsWert( );
	}
}
