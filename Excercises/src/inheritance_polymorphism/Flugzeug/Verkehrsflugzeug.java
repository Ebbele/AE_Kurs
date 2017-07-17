package inheritance_polymorphism.Flugzeug;

public class Verkehrsflugzeug extends Flugzeug {

	int anzahlPassagiere;
	
	Verkehrsflugzeug( String hersteller, int maxSpeed, int anzahlFluegel ) {
		
		super( hersteller, maxSpeed, anzahlFluegel );
	}
	
	@Override
	final public boolean getLooping( ) {
		
		return false;
	}
	
	public int getAnzahlPassagiere( ) {
		
		return anzahlPassagiere;
	}

	protected void setAnzahlPassagiere( int anzahlPassagiere ) {
		
		this.anzahlPassagiere = anzahlPassagiere;
	}	
}
