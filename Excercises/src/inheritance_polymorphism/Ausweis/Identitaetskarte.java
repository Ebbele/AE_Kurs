package inheritance_polymorphism.Ausweis;

public class Identitaetskarte extends Ausweis {

	public int groesse;
	public String buergerort;
	
	public Identitaetskarte( int nummer, String inhaber, String ablaufDatum, int groesse, String buergerort ) {
		
		super( nummer, inhaber, ablaufDatum );
		this.groesse = groesse;
		this.buergerort = buergerort;
	}
	
	public int getGroesse( ) {
		
		return groesse;
	}

	public String getBuergerort( ) {
		
		return buergerort;
	}	
}
