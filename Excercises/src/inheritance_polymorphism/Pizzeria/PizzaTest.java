package inheritance_polymorphism.Pizzeria;

import java.util.ArrayList;
import java.util.Iterator;

public class PizzaTest {

	public static void main(String[] args) {
		
		double gesamtpreis=0.0;
				
		ArrayList <Pizza> pizza = new ArrayList <Pizza>();
		
		pizza.add ((Pizza) new PizzaNapolitana());
		pizza.add ((Pizza) new PizzaMargherita(30));
		
		Iterator <Pizza> itaPi = pizza.iterator();
		
		while (itaPi.hasNext()) {
				
			gesamtpreis+= itaPi.next().getPreis();
		}
		System.out.println(gesamtpreis);
	}
}
