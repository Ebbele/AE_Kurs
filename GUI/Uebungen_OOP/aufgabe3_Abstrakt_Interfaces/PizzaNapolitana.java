package aufgabe3_Abstrakt_Interfaces;

public class PizzaNapolitana implements Pizza {

	private String zutaten[] = { "Tomate", "Mozzarella", "Parmesan", "Oliven", "Basilikum" };
	private double preis = 5.90;
	private double preisExtras = 0.80;

	public PizzaNapolitana(String... zutat) {
		if (zutat.length != 0) {
			String tmp[] = new String[zutat.length + zutaten.length];
			for (int c = 0; c < zutaten.length; c++) {
				tmp[c] = zutaten[c];
			}

			for (int j = 0; j < zutat.length; j++) {
				tmp[zutaten.length + j] = zutat[j];
				preis += preisExtras;
			}

			zutaten = tmp;
		}
	}

	@Override
	public String[] getZutaten() {
		return zutaten;
	}

	@Override
	public double getPreis() {
		return preis;
	}

}
