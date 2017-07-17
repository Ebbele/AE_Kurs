package schwarzeAuge;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;

public class Schnittstelle {

	public static List< Ruestung > getRuestungAlsListe ( ) {
		File file = new File( "ruestung.xml" );
		Item item = JAXB.unmarshal( file, Item.class );
		List< Ruestung > ruestung = new ArrayList<Ruestung>(item.getRuestung( ) );
		return ruestung;
	}
	
	public static List< Schilde > getSchildeAlsListe ( ) {
		File file = new File( "schilde.xml" );
		Item item = JAXB.unmarshal( file, Item.class );
		List< Schilde > schilde = new ArrayList< Schilde >( item.getSchilde( ) );
		return schilde;
	}
	
	public static List< Waffen > getWaffenAlsListe ( ) {
		File file = new File( "waffen.xml" );
		Item item = JAXB.unmarshal( file, Item.class );
		List< Waffen > waffen = new ArrayList< Waffen >( item.getWaffen( ) );
		return waffen;
	}
	
	// weiter mögliche Beispielmethoden für unsere Schnittstelle
/*	public static int getTpVonWaffe( Waffen waffe ) {	
		
	}
	
	public static String getNameVonWaffe( Waffen waffe ) {
		
	}
	
	public static int getParadeVonSchild( Schilde schild ) {
		
	}
	
	public static String getNameVonSchild( Schilde schild ) {
		
	}
	
	public static int getRwVonRuestung( Ruestung ruestung ) {
		
	}
	
	public static String getNameVonRuestung( Ruestung ruestung ) {
		
	}*/
}
