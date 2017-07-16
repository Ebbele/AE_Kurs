package schwarzeAuge;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.xml.bind.JAXB;

@SuppressWarnings("serial")
public class XMLTableModel_Waffen extends AbstractTableModel {

	// erzeuge String-Array f�r die Spaltenschriften(Default w�re A,B,C,...)
	private static final String[ ] COLUMN_NAMES = { "Bezeichnung", "Trefferpunkte" }; // <- muss angepasst werden, wenn sich der Objektgraph �ndert
	
	// zur 'Objektisierung' der Spalten, falls der Objekttyp gebraucht wird
	private static final Class< ? >[ ] COLUMN_CLASSES = { String.class, Integer.class }; // <- muss angepasst werden, wenn sich der Objektgraph �ndert
	
	// indexiere die Spalten
	private static final int COLUMN_ID_BEZEICHNUNG = 0;  // <- muss angepasst werden, wenn sich der Objektgraph �ndert
	private static final int COLUMN_ID_TREFFERPUNKTE = 1; // ^s.o.
	
	//erzeuge FileObjekt mit Verweis auf die zugeh�rige XML-Datei
	private final File file = new File( "waffen.xml" );
	
	// ListReferenz f�r die im Konstruktur �bergebene Liste
	private final List< Waffen > waffen;
	
	public XMLTableModel_Waffen( final List< Waffen > waffen ) { // Konstruktor
		this.waffen = new ArrayList< >( waffen );
	}
	
	@Override
	public String getColumnName( final int columnIndex ) { // hole 'alternativen' Spaltenname
		return COLUMN_NAMES[ columnIndex ];
	}
	
	@Override
	public int getColumnCount( ) {  // hole anzahl der ben�tigten Spalten �ber das COLUMN_NAMES - Array
		return COLUMN_NAMES.length;
	}
	
	@Override
	public int getRowCount( ) {  // hole anzahl der ben�tigen Spalten �ber die L�nge der Liste
		return waffen.size( );
	}
	
	@Override
	public Class<?> getColumnClass( final int columnIndex ) {  // hole Objekttyp der jeweiligen Spalte
		return COLUMN_CLASSES[ columnIndex ];
	}
	
	@Override
	public boolean isCellEditable( final int rowIndex, final int columnIndex) {  // da alle Zellen editierbar sein sollen, einfach nur true zur�ckgeben
		return true;
	}
	
	@Override
	public void setValueAt( final Object value, final int rowIndex, final int columnIndex ) {  // wurde eine Zelle editiert 
		final Waffen Waffenteil = waffen.get( rowIndex ); // hole anhand des Spaltenindex den ensprechenden Eintrag aus der Liste
		
		if ( columnIndex == COLUMN_ID_BEZEICHNUNG)  // Gleiche ab in welcher Spalte die �nderung stattfinden muss
			Waffenteil.setBezeichnung( (String) value );
		else if ( columnIndex == COLUMN_ID_TREFFERPUNKTE)
			Waffenteil.setTp( (int) value );
		
		fireTableCellUpdated( rowIndex, columnIndex );	// teile den 'Listenern' mit, dass sich an Position x,y etwas ge�ndert hat
		
		// erzeuge neues Item Objekt und ersetze die neuen Daten in der Liste, dann schreibe(marshal()) den neuen Objektgraphen in das XML-File
		Item item = new Item();
		item.setWaffe( waffen );
		JAXB.marshal( item , file );
	}
	
	@Override
	public Object getValueAt( final int rowIndex, final int columnIndex ) {	// hole den Wert an Position x,y im table
		final Waffen Waffenteil = waffen.get( rowIndex );
		
		if( columnIndex == COLUMN_ID_BEZEICHNUNG ) 
			return Waffenteil.getBezeichnung( );
		if( columnIndex == COLUMN_ID_TREFFERPUNKTE )
			return Waffenteil.getTp();
		
		throw new IllegalArgumentException( "Falscher Spaltenwert!" + columnIndex );
	}
	/*public void addEntry(  ) { // Nur schon mal exemplarisch zum einf�gen eines neuen Eintrages, erfordert leichten Umbau der UI wie z.b. das einf�gen eines Buttons
	// neuen Eintrag in die Liste einf�gen
	final int newRowIndex = waffen.size( ) - 1;
	fireTableRowsInserted( newRowIndex, newRowIndex );
	}*/
}