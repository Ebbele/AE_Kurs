package SwingUndEvents;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Editor extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JMenuBar mbar;
	private JMenu menu1;
	private JMenu menu2;
	private JMenu menu3;
	
	Editor( ) { // Die Menus durch Methoden zu 'füllen' ist natürlich schöner
		
		frame = new JFrame( );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		//erzeuge Obermenu s
		mbar = new JMenuBar( );
		menu1 = new JMenu( "Datei" );
		menu2 = new JMenu( "Bearbeiten" );
		menu3 = new JMenu( "Senden an" );
		mbar.add( menu1 );
		mbar.add( menu2 );
		//*******************************
		
		// fuelle das erste Menu(Datei) mit Eintraegen
		menu1.add( new JMenuItem( "Neu..." ) );
		menu1.add( "Öffnen..." );
		menu1.add( "Schließen" );
		menu1.addSeparator( );
		menu1.add( "Speichern" );
		menu1.add( "Speichern unter..." );
		menu1.add( "Als Webseite speichern..." );
		menu1.add( "Suchen..." );
		menu1.addSeparator( );
		menu1.add( "Versionen" );
		menu1.addSeparator( );
		menu1.add( "Seite einrichten..." );
		menu1.add( "Seitenansicht" );
		menu1.add( "Drucken..." );
		menu1.addSeparator( );
		menu1.add( menu3 ); //erzeuge Untermenu
		menu1.add( "Eigenschaften" );
		menu1.addSeparator( );
		menu1.add( "Beenden" );
		// ***********************************************
		
		//fuelle das zweite Menu(Bearbeiten) mit Eintraegen
		menu2.add( "Rückgaengig" );
		menu2.add( "Wiederholen" );
		menu2.addSeparator( );
		menu2.add( "Auschneiden" );
		menu2.add( "Kopieren" );
		menu2.add( "Office-Zwischenablage" );
		menu2.addSeparator( );
		menu2.add( "Einfügen" );
		menu2.add( "Inhalt einfügen" );
		menu2.add( "Als Hyperlink einfügen" );
		menu2.addSeparator( );
		menu2.add( "Löschen" );
		menu2.add( "Alles markieren" );
		menu2.addSeparator( );
		menu2.add( "Suchen..." );
		menu2.add( "Ersetzen..." );
		menu2.add( "Gehe zu..." );
		menu2.addSeparator( );
		menu2.add( "Verknüpfungen..." );
		menu2.add( "Objekt" );
		
		//fülle das Untermenu(Senden an) mit Eintraegen
		menu3.add( "E-Mail-Empänger" );
		menu3.add( "E-Mail-Empänger(zur Überarbeitung)..." );
		menu3.addSeparator( );
		menu3.add( "E-Mail-Empänger(als Anlage)..." );
		menu3.add( "Verteilerempfänger..." );
		menu3.add( "Onlinebesprechungsteilnehmer" );
		menu3.add( "Exchange-Ordner..." );
		menu3.add( "Fax-Empfänger..." );
		menu3.addSeparator( );
		menu3.add( "Microsoft Powerpoint" );
		//************************************************
		
		//füge die Menubar in den Frame ein, initialisere selbigen
		frame.setJMenuBar( mbar );
		frame.setSize( 500, 500 );
		frame.setVisible( true );		
		//***************************************************
	}

	public static void main( String[ ] args ) {

		new Editor( );
	}

}
