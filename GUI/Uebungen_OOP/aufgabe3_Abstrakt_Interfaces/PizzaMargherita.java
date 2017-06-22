package aufgabe3_Abstrakt_Interfaces;

public class PizzaMargherita implements Pizza {
	
	private String zutaten[] = { "Tomate", "K\u00e4se", "Basilikum" };
	private int groesse = 23;
	private double basisPreis = 4.50;
	private double factor = 0;
	private double preis = 0;
	private double preisExtras = 0.80;
	
	public PizzaMargherita(String... zutat) {
		this.preis = basisPreis;
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
		factor = preis / groesse;
	}
	
	public PizzaMargherita(int groesse, String ...zutat) {
		this(zutat);
		setGroesse(groesse);
		this.preis = factor*groesse;
	}
	
	private void setGroesse(int groesse) {
		this.groesse = groesse;
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
