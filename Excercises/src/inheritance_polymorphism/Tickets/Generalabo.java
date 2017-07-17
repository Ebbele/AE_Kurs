package inheritance_polymorphism.Tickets;

public class Generalabo extends Ticket {
	
	private String inhaber;
	private String verfallsDatum;
	
	public Generalabo( int preis, String inhaber, String verfallsDatum ) {
		
		super( preis );
		this.inhaber = inhaber;
		this.verfallsDatum = verfallsDatum;
	}
	
	public void entwerten( ){ }
	
	public String gibVerfallsDatum( ) {
		
		return verfallsDatum;
	}
	
	public boolean gueltigInZone( int zone ) {
		
		return true;
	}
	
	public String gibInhaber( ) {
		
		return inhaber;
	}
}
