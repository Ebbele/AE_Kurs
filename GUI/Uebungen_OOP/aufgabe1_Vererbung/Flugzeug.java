package aufgabe1_Vererbung;

public abstract class Flugzeug {
	@SuppressWarnings("unused")
	private String hersteller;
	private int maxSpeed;
	private String immatNummer;
	@SuppressWarnings("unused")
	private int anzahlFluegel = 1;
	
	public Flugzeug(String hersteller, int maxSpeed, int anzahlFluegel) {
		this.hersteller = hersteller;
		this.maxSpeed = maxSpeed;
		this.anzahlFluegel = anzahlFluegel;
	}
	
	public String getImmatNummer() {
		return immatNummer;
	}
	
	protected void setImmatNummer(String immatNummer) {
		this.immatNummer = immatNummer;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	abstract public boolean getLooping();
}
