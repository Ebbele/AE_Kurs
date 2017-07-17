package schwarzeAuge;

import java.util.Objects;

//Schildeklasse wird benötigt sowohl zur Komplettierung des Objektgraphen, als auch zur Erstellung der jeweiligen Objektlisten, auf denen wir arbeiten 
//und diese ggfls. über eine Schnittstelle an andere Teams weiterleiten

public class Schilde {

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
}
