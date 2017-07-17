package utils;

import java.util.Random;

public class Messwert {
	
	private int messNummer;
	private int messReihe;
	private int messwert;
	
	Random rd = new Random( );
	
	Messwert( int messNummer, int messReihe ) {
		
		setMessNummer(messNummer);
		setMessReihe(messReihe);
		this.messwert = erzeugeZufallszahl( );
	}
	
	public int getMessNummer( ) {
	
		return this.messNummer;
	}
	
	private void setMessNummer( int messNummer ) {
		
		this.messNummer = messNummer;
	}
	
	public int getMessReihe( ) {
		
		return this.messReihe;
	}
	
	private void setMessReihe( int messReihe ) {
		
		this.messReihe = messReihe;
	}
	
	public int getMesswert( ) {
		
		return messwert;
	}
	
	private int erzeugeZufallszahl( ) {
		
		int zufallszahl = rd.nextInt( 16 ) + 20;
		return zufallszahl;		
	}

}
