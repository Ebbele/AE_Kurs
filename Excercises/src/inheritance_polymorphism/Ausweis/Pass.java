package inheritance_polymorphism.Ausweis;

public class Pass extends Identitaetskarte {
	
	String fingerabdruck;
	
	Pass( int nummer, String inhaber, String ablaufDatum, int groesse, String buergerort, String fingerabdruck ) {
		
		super( nummer, inhaber, ablaufDatum, groesse, buergerort );
		this.fingerabdruck = fingerabdruck;
	}
	
	public String getFingerabdruck( ) {
		
		return this.fingerabdruck;
	}
}
