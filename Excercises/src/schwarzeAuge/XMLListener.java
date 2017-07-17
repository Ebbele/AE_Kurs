package schwarzeAuge;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.bind.JAXB;

public class XMLListener implements ActionListener {

	// Deklaration
	private final File file;
	private final JFrame frame;
	private TableModel tableModel;
	private final JMenuBar menu;
	
	// Übergabe des XML-Filenamens als auch des in XML_Editor.java erzeugten JFrames und die MenuBar
	XMLListener( File file, JFrame frame, JMenuBar menueLeiste ) {  
		this.menu = Objects.requireNonNull( menueLeiste, "Null - Referenz (var: menu - Klasse: XMLListener.java)" );
		this.file = Objects.requireNonNull( file, "Null - Referenz (var: item - Klasse: XMLListener.java)" );
		this.frame = Objects.requireNonNull( frame, "Null - Referenz (var:frame - Klasse: XMLListener.java)" );
	}
	
	@Override
	public void actionPerformed( ActionEvent evt ) { // was passiert, wenn ein Menupunkt in der Klasse XML_Editor geklickt wird
			
			// erzeuge den Objektgraphen(unmarshal()) aus der übergebener XML-Filereferenz, als auch Itemklasse,  und weise diesem dem neu erzeugten Objekt Item hinzu(Item kennt Waffen, Schilde und Ruestung) 
			Item item = JAXB.unmarshal( file, Item.class );
			
			switch ( file.getName() ) { // Abgleich des benötigten TableModels über den Namen der XML-File
			
			case "ruestung.xml":
				tableModel = new XMLTableModel_Ruestung( item.getRuestung( ) ); // bei Erzeugung des Tablemodels wird eine Referenz der benötigen Items( ruestung, waffen oder schilde)
				break;															// als Liste mit übergeben
			case "waffen.xml":
				tableModel = new XMLTableModel_Waffen( item.getWaffen( ) );		// ^s.o.
				break;
			case "schilde.xml":
				tableModel = new XMLTableModel_Schilde( item.getSchilde( ) );	// ^s.o.
				break;
			default:
				JOptionPane.showMessageDialog( null, "Tablemodel konnte nicht zugeordnet werden" ); // <- sollte nicht passieren
			}
			
			// erzeuge eine Tabelle und übergebe das zuvor erzeugte/abgeglichene tablemodel dem Konstruktor der Klasse
			final JTable table = new JTable( tableModel ); 

			// automatische Spaltensortierung
			table.setAutoCreateRowSorter( true );
			
			//erzeuge ein Objekt der Klasse TableRowSorter für unsere abgeleitete Filter.java(RowFilter< Object, Object >) Klasse
			final TableRowSorter< TableModel > tableRowSorter = new TableRowSorter<>( table.getModel( ) );
			
			// erzeuge ein Objekt der Filterklasse
			final Filter filter = new Filter( "" );
			
			// uebergebe die Referenz des Filterobjekt an das Objekt tableRowSorter
			tableRowSorter.setRowFilter( filter );
			
			// und letztendlich wird der tableRowSorter unseren Table übergeben, jetzt können wir die Filtermethoden der Filter.java Klasse auf unsere Tabelle anwenden
			table.setRowSorter( tableRowSorter );
			
			// erzeuge Textfeld für den FilterString
			final JTextField filterTextField = new JTextField( );
			filterTextField.addActionListener( new ActionListener( ) { // anonyme innere Klasse zum Überschreiben der actionPerformed Methode, die einen String über getText()
				@Override												// aus unseren zuvor erzeugten Textfeld einlesen kann und an die filtermethode unserer Filterklasse übergibt
				public void actionPerformed( ActionEvent evt2 ) {		// Da es keine direkte Verbindung zwischen Filter und Tabelle gibt, sondern nur eine Indirektion über 
					filter.setFilterValue( filterTextField.getText( ) );// RowFilter(filter.java) -> TableRowSorter -> JTable muss noch die sort() methode von tablerowsorter
					tableRowSorter.sort( );								// aufgerufen werden, die dann unser Ergebnis sowohl filtert, als auch sortiert
				}
			});

			// fuege unser Textfeld den JFrame hinzu
			frame.add( filterTextField, BorderLayout.NORTH );
			
			// fuege den Container SCrollPane mit all seinen darin enthalten Gui-Elementen(table, model) dem Frame hinzu
			frame.add( new JScrollPane( table ), BorderLayout.CENTER );
			
			// entferne das Menu
			frame.remove( menu );
			
			// validiere, da eine Neuausführung des Layout erforderlich ist( durch hinzufügen neuer Gui-Elemente) nach setVisible(true)
			frame.validate( );	
	}
}
