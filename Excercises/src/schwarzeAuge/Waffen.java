package schwarzeAuge;

import java.util.Objects;

//Waffenklasse wird benötigt sowohl zur Komplettierung des Objektgraphen, als auch zur Erstellung der jeweiligen Objektlisten, auf denen wir arbeiten 
//und diese ggfls. über eine Schnittstelle an andere Teams weiterleiten

public class Waffen {

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
	
}
