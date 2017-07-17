package inheritance_polymorphism.Mitarbeiter;

public abstract class Mitarbeiter {

	private int personalNr;
	private String name;
	private String datumEintritt;
	private double stundenlohn;
	private double anzahlStunden;
	private double ueberStundenZuschlag;
	private double anzahlUeberstunden;
	
	Mitarbeiter( int personalNr, String name, String datumEintritt, 
			double stundenlohn, double anzahlStunden, double ueberStundenZuschlag, double anzahlUeberstunden ) {
		this.personalNr = personalNr;
		this.name = name;
		this.datumEintritt = datumEintritt;
		this.stundenlohn = stundenlohn;
		this.anzahlStunden = anzahlStunden;
		this.anzahlUeberstunden = anzahlUeberstunden;
		this.ueberStundenZuschlag = ueberStundenZuschlag;
	}
	
	public int getPersonalNr( ) {
		
		return personalNr;
	}
	
	public String getName( ) {
		
		return name;
	}
	
	public String getDatumEintritt( ) {
		
		return datumEintritt;
	}
	
	public double getStundenlohn( ) {
		
		return stundenlohn;
	}

	public double getAnzahlStunden( ) {
		
		return anzahlStunden;
	}

	public double getUeberStundenZuschlag( ) {
		
		return ueberStundenZuschlag;
	}

	public double getAnzahlUeberstunden( ) {
		
		return anzahlUeberstunden;
	}
	
	public abstract double berechneMonatsgehalt( );
}