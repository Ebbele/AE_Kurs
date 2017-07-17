package inheritance_polymorphism.Flugzeug;

public final class Doppeldecker extends Flugzeug {

	final static int LOOPINGSPEED;
	boolean offenesCockpit;

	static {
		
		LOOPINGSPEED = 250;
	}
	
	Doppeldecker( String hersteller, int maxSpeed, int anzahlFluegel, String immatNummer, boolean offenesCockpit ) {
		
		super( hersteller, maxSpeed, anzahlFluegel );
		setImmatNummer( immatNummer );
		setOffenesCockpit( offenesCockpit );
	}
	
	Doppeldecker( String hersteller, int maxSpeed, int anzahlFluegel, String immatNummer ) {
		
		super( hersteller, maxSpeed, anzahlFluegel );
		setImmatNummer( immatNummer );
		setOffenesCockpit( true );
	}
	
	public boolean isOffenesCockpit() {
		return offenesCockpit;
	}

	protected void setOffenesCockpit(boolean offenesCockpit) {
		this.offenesCockpit = offenesCockpit;
	}
	
	@Override
	public boolean getLooping( ) {
		
		if ( getMaxSpeed( ) > LOOPINGSPEED ) {
			
			return true;
		}
		else {
			
			return false;
		}
	}
}
