package inheritance_polymorphism.Pizzeria;

public class PizzaMargherita extends Pizza {
	
	static String[] zutaten={"Käse","Tomaten"};
	double preis=4.5;
	int groesse;
	final int BASISGROESSE = 23;
	
	PizzaMargherita(int groesse) {
		
		setGroesse( groesse );
		this.preis = getPreis( ) / ( Math.PI*( BASISGROESSE / 2 )*( BASISGROESSE / 2 ) ) * ( Math.PI*( getGroesse( ) / 2 )*( getGroesse( )/ 2 ) );
		}
	
	public int getGroesse( ) {
		
		return groesse;
	}
	public void setGroesse( int groesse ) {
		
		this.groesse = groesse;
	}
	public String[ ] getZutaten( ) {
		
		return zutaten;
	}
	public double getPreis( ){
		
		return preis;
	}
}