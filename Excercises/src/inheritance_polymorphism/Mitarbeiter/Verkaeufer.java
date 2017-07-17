package inheritance_polymorphism.Mitarbeiter;

public class Verkaeufer implements MitarbeiterInterface {

	private int personalNr;
	private String name;
	private String datumEintritt;
	private double fixGehalt;
	private double umsatz;
	private double provision;
	
	Verkaeufer( int personalNr,	String name, String datumEintritt, double fixGehalt,
				double umsatz, double provision ) {
		
		this.personalNr = personalNr;
		this.name = name;
		this.datumEintritt = datumEintritt;
		this.fixGehalt = fixGehalt;
		this.umsatz = umsatz;
		this.provision = provision;
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
	
	public double getFixgehalt( ) {
		
		return fixGehalt;
	}

	public double getUmsatz( ) {
		
		return umsatz;
	}

	public double getProvision( ) {
		
		return provision;
	}
	
	public double berechneMonatsLohn( ) {
		
		return getFixgehalt( ) + ( getUmsatz( ) * ( getProvision( ) / 100 ) );
	}	
}