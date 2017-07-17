package inheritance_polymorphism.Flugzeug;

abstract class Flugzeug {

	private String hersteller;
	private int maxSpeed;
	private String immatNummer;
	private int anzahlFluegel;
	
	{
		setAnzahlFluegel( 1 );
	}
	
	public Flugzeug( String hersteller, int maxSpeed, int anzahlFluegel ) {
		
	}
	
	public String getHersteller( ) {
		return hersteller;
	}

	protected void setHersteller( String hersteller ) {
		this.hersteller = hersteller;
	}

	public int getMaxSpeed( ) {
		return maxSpeed;
	}

	protected void setMaxSpeed( int maxSpeed ) {
		this.maxSpeed = maxSpeed;
	}

	public String getImmatNummer( ) {
		return immatNummer;
	}

	protected void setImmatNummer( String immatNummer ) {
		this.immatNummer = immatNummer;
	}

	public int getAnzahlFluegel() {
		return anzahlFluegel;
	}

	protected void setAnzahlFluegel( int anzahlFluegel ) {
		this.anzahlFluegel = anzahlFluegel;
	}
	
	abstract public boolean getLooping( );
}
