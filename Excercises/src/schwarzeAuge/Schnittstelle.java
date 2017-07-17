package schwarzeAuge;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXB;

public class Schnittstelle {

	public static List< Ruestung > getRuestung ( ) {
		File file = new File( "ruestung.xml" );
		Item item = JAXB.unmarshal( file, Item.class );
		List< Ruestung > ruestung = new ArrayList<Ruestung>(item.getRuestung( ) );
		return ruestung;
	}
	public static void main( String[ ] args ) {
		
		List< Ruestung > test = new ArrayList< Ruestung >( getRuestung( ) );
		Iterator<Ruestung> iter = test.iterator( );
		
		while( iter.hasNext( ) ) {
			System.out.println(iter.next().getBezeichnung());
		}
	}

}
