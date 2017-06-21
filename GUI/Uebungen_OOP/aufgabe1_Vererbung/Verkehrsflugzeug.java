package aufgabe1_Vererbung;

public class Verkehrsflugzeug extends Flugzeug {
	
	private int anzahlPassagiere;
	
	public Verkehrsflugzeug(String hersteller, int maxSpeed, int anzahlFluegel) {
		super(hersteller, maxSpeed, anzahlFluegel);
	}
	
	public Verkehrsflugzeug(String hersteller, int maxSpeed, String immatNummer, int anzahlPassagiere) {
		super(hersteller, maxSpeed,1);
		setImmatNummer(immatNummer);
		this.setAnzahlPassagiere(anzahlPassagiere);
	}
	
	@Override
	public boolean getLooping() {
		return false;
	}

	public int getAnzahlPassagiere() {
		return anzahlPassagiere;
	}

	public void setAnzahlPassagiere(int anzahlPassagiere) {
		this.anzahlPassagiere = anzahlPassagiere;
	}

}
