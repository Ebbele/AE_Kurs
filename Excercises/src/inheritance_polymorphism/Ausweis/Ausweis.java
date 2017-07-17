package inheritance_polymorphism.Ausweis;

public class Ausweis {

	protected int nummer;
	protected String inhaber;
	protected String ablaufDatum;
	
	public Ausweis( int nummer, String inhaber, String ablaufDatum ) {
		
		this.nummer = nummer;
		this.inhaber = inhaber;
		this.ablaufDatum = ablaufDatum;
	}
	
	public int getNummer( ) {
		
		return nummer;
	}

	public String getInhaber( ) {
		
		return inhaber;
	}

	public String getAblaufDatum( ) {
		
		return ablaufDatum;
	}
}
