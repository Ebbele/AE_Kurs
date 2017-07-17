package inheritance_polymorphism.Mitarbeiter;

public interface MitarbeiterInterface {

	public abstract String getName( );
	public abstract int getPersonalNr( );
	public abstract String getDatumEintritt( );
	public abstract double berechneMonatsLohn( );
	public abstract double getFixgehalt();
	public abstract double getUmsatz( );
	public abstract double getProvision( );
}
