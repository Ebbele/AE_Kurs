package schwarzeAuge;

import java.util.Objects;

//Schildeklasse wird benötigt sowohl zur Komplettierung des Objektgraphen, als auch zur Erstellung der jeweiligen Objektlisten, auf denen wir arbeiten 
//und diese ggfls. über eine Schnittstelle an andere Teams weiterleiten

public class Schilde extends Item {

	String bezeichnung;
	int parade;
	
	public String getBezeichnung( ) {
		return bezeichnung;
	}
	
	public void setBezeichnung( String bezeichnung ) {
		this.bezeichnung = Objects.requireNonNull( bezeichnung, "NULL - var: bezeichnung klasse: Schilde.java" );
	}
	
	public int getParade( ) {
		return parade;
	}
	
	public void setParade( int parade ) {
		this.parade = Objects.requireNonNull( parade, "NULL - var: parade klasse: Schilde.java" );
	}	
	
	@Override
	public String toString( ) {
		return "Bezeichnung: " + getBezeichnung( ) + 
				" " +
				"Parade: " + getParade( );
	}
	
	@Override
	public boolean equals( final Object other ) {
		if( other == null ) // Null-Akzeptanz
			return false;
		if( this == other ) // Reflexivität
			return true;
		if( this.getClass( ) != other.getClass( ) ) // Typgleichheit sicherstellen
			return false;
		final Schilde otherSchild = ( Schilde ) other; // Attribute pruefen
		return compareAttributes( otherSchild );
	}
	
	private boolean compareAttributes( final Schilde otherSchild ) { // Hilfsmethode für equals
		return this.getBezeichnung( ).equals( otherSchild.getBezeichnung( ) ) &&
				this.getParade( ) == otherSchild.getParade( );
	}
}
