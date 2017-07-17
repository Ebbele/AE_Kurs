package inheritance_polymorphism.Ausweis;

public class Fahrausweis extends Ausweis {
	
	public String kategorien;
	
	public Fahrausweis( int nummer, String inhaber, String ablaufDatum, String kategorien ) {
		
		super( nummer, inhaber, ablaufDatum );
		this.kategorien = kategorien;
	}
	
	public String getKategorien( ) {
		
		return this.kategorien;
	}
}
