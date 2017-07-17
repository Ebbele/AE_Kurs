package ReaderWriterexercises;

public class Person {
	
	private String name;
	private String geschlecht;
	private int groesse;
	private int gewicht;
	
	Person(String name, String geschlecht, int groesse, int gewicht) {
		setName(name);
		setGeschlecht(geschlecht);
		setGroesse(groesse);
		setGewicht(gewicht);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGeschlecht() {
		return geschlecht;
	}
	
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	public int getGroesse() {
		return groesse;
	}
	
	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}
	
	public int getGewicht() {
		return gewicht;
	}
	
	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}

}
