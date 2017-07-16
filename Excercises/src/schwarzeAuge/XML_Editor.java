package schwarzeAuge;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class XML_Editor {
	
	// Deklaration der GUI - Elemente
	private final JFrame frame;
	private final JMenuBar menueLeiste;
	private final JMenu xml;
	private final JMenuItem ruestung;
	private final JMenuItem waffen;
	private final JMenuItem schilde;
	
	XML_Editor( ) { // Initialiserung der GUI-Elemente im Konstruktor
		
		// erzeuge JFrame 
		frame = new JFrame( "XML-Editor" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		//erzeuge eine Menuleiste
		menueLeiste = new JMenuBar( );
		
		//erzeuge einen Menupunkt in der Menuleiste
		xml = new JMenu("XML-Tables");
		
		//erzeuge Untermenupunkte(elemente) im Menupunkt xml-tables
		ruestung = new JMenuItem( "oeffne ruestung.xml" );
		waffen = new JMenuItem( "oeffne waffen.xml" );
		schilde = new JMenuItem( "oeffne schilde.xml" );
		
		// fuege Menupunkt xml zur menuleiste hinzu
		menueLeiste.add( xml );
		
		// fuege untermenupunkte zum menupunkt xml hinzu
		xml.add( ruestung );
		xml.add( waffen );
		xml.add( schilde );
		
		//fuege XMLListener(ActionListener) den einzelnen Untermenupunkten hinzu
		ruestung.addActionListener( new XMLListener( new File( "ruestung.xml" ), frame, menueLeiste ) );
		waffen.addActionListener( new XMLListener( new File( "waffen.xml" ), frame, menueLeiste ) );
		schilde.addActionListener( new XMLListener( new File( "schilde.xml" ), frame, menueLeiste ) );
		
		// fuege menueleiste dem frame(contentpane) hinzu
		frame.add( menueLeiste, BorderLayout.SOUTH);
		
		// setze Größe und Sichtbarkeit
		frame.setSize( 500, 200 );
		frame.setVisible( true );
		
	}

	public static void main( String[ ] args ) {
		
		new XML_Editor( ); // erzeuge Instanz der eigenen Klasse zum Starten
	}
}
