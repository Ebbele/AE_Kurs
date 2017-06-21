package aufgabe1_Vererbung;

public final class Doppeldecker extends Flugzeug {

	private static final int LOOPINGSPEED = 320;
	private final boolean offenesCockpit;

	public Doppeldecker(String hersteller, int maxSpeed, int anzahlFluegel) {
		super(hersteller, maxSpeed, 2);
		offenesCockpit = true;
	}

	public Doppeldecker(String hersteller, int maxSpeed, String immatNummer, boolean offenesCockpit) {
		super(hersteller, maxSpeed, 2);
		setImmatNummer(immatNummer);
		this.offenesCockpit = offenesCockpit;
	}
	
	public Doppeldecker(String hersteller, int maxSpeed, String immatNummer ) {
		this(hersteller, maxSpeed, immatNummer, true);
	}
	
	
	public boolean isOffenesCockpit() {
		return offenesCockpit;
	}

	@Override
	public boolean getLooping() {
		return getMaxSpeed() > LOOPINGSPEED;
	}

}
