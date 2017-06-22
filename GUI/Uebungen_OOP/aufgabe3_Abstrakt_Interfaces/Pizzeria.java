package aufgabe3_Abstrakt_Interfaces;

import java.util.ArrayList;
import java.util.Arrays;

public class Pizzeria {

	public static void main(String[] args) {
		
		PizzaNapolitana napoli1 = new PizzaNapolitana("Knobi", "Sardellen");
		System.out.println(Arrays.toString(napoli1.getZutaten()) + " Euro: "+ napoli1.getPreis());
		
		PizzaNapolitana napoli2 = new PizzaNapolitana();
		System.out.println(Arrays.toString(napoli2.getZutaten())+ " Euro: "+ napoli2.getPreis());

		PizzaMargherita maggi1  = new PizzaMargherita();
		System.out.println(Arrays.toString(maggi1.getZutaten())+ " Euro: "+ maggi1.getPreis());
		
		PizzaMargherita maggi2  = new PizzaMargherita(36, "Knoblauch");
		System.out.println(Arrays.toString(maggi2.getZutaten())+ " Euro: "+ maggi2.getPreis());
		
		ArrayList<Pizza> pizzen = new ArrayList<Pizza>();
		
		pizzen.add(napoli1);
		pizzen.add(napoli2);
		pizzen.add(maggi1);
		pizzen.add(maggi2);
		
		double sum = .0;
		
		for(Pizza p : pizzen) {
			sum += p.getPreis();
		}
		
		System.out.printf("Summe: %.2f", sum);
		
	}

}
