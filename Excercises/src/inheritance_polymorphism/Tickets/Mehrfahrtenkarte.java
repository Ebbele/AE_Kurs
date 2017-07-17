package inheritance_polymorphism.Tickets;

public class Mehrfahrtenkarte extends Ticket {
	
	private int fahrten;
	private int zone;
	
	public Mehrfahrtenkarte( int preis, int fahrten, int zone ) {
		
		super( preis );
		this.fahrten = fahrten;
		this.zone = zone;
	}
	
	public void entwerten( ) {
		
		if ( fahrten == 0 ) 
			return;
					
		fahrten -= 1;
	}
	
	public boolean isEntwertet( ) {
		
		return fahrten == 0;
	}
	
	public boolean gueltigInZone( int zone ) {
		
		return zone == this.zone;
	}
}
