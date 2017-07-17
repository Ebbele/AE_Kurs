package inheritance_polymorphism.Pizzeria;

public class PizzaNapolitana extends Pizza {

	static String[ ] zutaten={ "Mozarella","Tomaten" };
	static double preis = 3.00;
		
	public String[ ] getZutaten( ) {
		
		return zutaten;
	}
	
	public double getPreis( ){
		
		return preis;
	}	
}
