package schwarzeAuge;

import javax.swing.RowFilter;

public class Filter  extends RowFilter< Object, Object >{

	private String filterValue = "";
	
	public Filter( final String filterValue ) {
		this.filterValue = filterValue.toLowerCase( );
	}

	@Override
	public boolean include( final Entry<? extends Object, ? extends Object> entry ) { // < ? extends ? > Wildcard-Paramter, alle 'unbekannten' Typen, die von Object abgeleitet sind, sind erlaubt
		
		if (filterValue.isEmpty( ) ) // ist der String empty, dann ist natürlich alles true und sollte im table angezeigt werden
			return true;
		
		for ( int i = 0; i < entry.getValueCount( ); i++ ) { // überprüfe bzw. gleiche den übergebenen String mit den Inhalten der einzelnen Zellen ab über contains()
			if ( entry.getStringValue( i ).toLowerCase( ).contains( filterValue) )
				return true;
		}
		return false; // nichts gefunden, dann filtere den Wert heraus
	}
	
	public void setFilterValue( final String filterValue ) { // setze den Filter
		this.filterValue = filterValue.toLowerCase( );
	}
}
