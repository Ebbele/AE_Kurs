package schwarzeAuge;

import java.util.Objects;

//Waffenklasse wird benötigt sowohl zur Komplettierung des Objektgraphen, als auch zur Erstellung der jeweiligen Objektlisten, auf denen wir arbeiten 
//und diese ggfls. über eine Schnittstelle an andere Teams weiterleiten

public class Waffen extends Item {

	String bezeichnung;
	int tp;
	
	public String getBezeichnung( ) {
		return bezeichnung;
	}
	
	public void setBezeichnung( String bezeichnung ) {
		this.bezeichnung = Objects.requireNonNull( bezeichnung, "NULL - var: bezeichnung klasse: Waffen.java" );
	}
	
	public int getTp( ) {
		return tp;
	}
	
	public void setTp( int tp ) {
		this.tp = Objects.requireNonNull( tp, "Null - var: tp klasse: Waffen.java" );
	}
	
	@Override
	public String toString( ) {
		return "Bezeichnung: " + getBezeichnung( ) + 
				" " +
				"Trefferpunkte: " + getTp( );
	}	
	
	@Override
	public boolean equals( final Object other ) {
		if( other == null ) // Null-Akzeptanz
			return false;
		if( this == other ) // Reflexivität
			return true;
		if( this.getClass( ) != other.getClass( ) ) // Typgleichheit sicherstellen
			return false;
		final Waffen otherwaffe = ( Waffen ) other; // Attribute pruefen
		return compareAttributes( otherwaffe );
	}
	
	private boolean compareAttributes( final Waffen otherwaffe ) { // Hilfsmethode für equals
		return this.getBezeichnung( ).equals( otherwaffe.getBezeichnung( ) ) &&
				this.getTp( ) == otherwaffe.getTp( );
	}
}
