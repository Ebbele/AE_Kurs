package schwarzeAuge;

import java.util.Objects;

// Ruestungsklasse wird benötigt sowohl zur Komplettierung des Objektgraphen, als auch zur Erstellung der jeweiligen Objektlisten, auf denen wir arbeiten 
// und diese ggfls. über eine Schnittstelle an andere Teams weiterleiten

public class Ruestung {

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
}
