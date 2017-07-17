package inheritance_polymorphism.Tickets;

abstract class Ticket {

	private int preis;
	private boolean entwertet;
	
	public Ticket( int preis ) {
		this.preis = preis;
		entwertet = false;
	}
	
	public int gibPreis( ) {
		
		return preis;
	}
	
	public void entwerten( ) {
		
		entwertet = true;
	}
	
	public boolean isEntwertet( ) {
		
		return entwertet;
	}
	
	public abstract boolean gueltigInZone( int Zone );
}
