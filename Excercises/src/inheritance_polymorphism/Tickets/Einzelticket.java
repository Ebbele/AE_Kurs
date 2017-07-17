package inheritance_polymorphism.Tickets;

public class Einzelticket extends Ticket {
	
	private int zone;
	private String verfallsDatum;
	
	public Einzelticket( int preis, String verfallsDatum, int zone ) {
		
		super( preis );
		this.verfallsDatum = verfallsDatum;
		this.zone = zone;
	}
	
	public String gibVerfallsDatum( ) {
		
		return verfallsDatum;
	}
	
	public boolean gueltigInZone( int zone ) {
		
		return zone == this.zone;
	}
}
