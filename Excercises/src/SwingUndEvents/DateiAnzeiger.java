package SwingUndEvents;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class DateiAnzeiger {
	
	private JFileChooser fc;
	private JFrame frame;
	private JTextArea tarea;
	private JPanel panel;
	private JScrollPane scrollPane;
	
	private int option;
	//
	private void erzeugeFensterUndLeseDateiAus( File file ) {
		
		String inputString = "";
		int counter = 0;
		
		frame = new JFrame( );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		panel = new JPanel( );

		panel.setLayout( new GridLayout() );
		tarea = new JTextArea( );

		scrollPane = new JScrollPane( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		scrollPane.setViewportView( tarea );
				
		try (BufferedReader br = new BufferedReader( new FileReader( file.getAbsolutePath( ) ) ) ) {
			
			while ( ( inputString = br.readLine( ) ) != null || counter < 10) {
				
				inputString += "\n";
				counter++;
				tarea.append( inputString );
				tarea.setRows( counter + 1 );
				
			}
		} catch ( FileNotFoundException e ) {
			
			System.err.println( e.toString( ) );
		} catch ( IOException e ) {
			
			System.err.println( e.toString( ) );
		}

		panel.add( scrollPane );
		frame.add( panel );
		frame.setSize( 100, 100);
		frame.setVisible( true );
	}
	
	public static void main( String[ ] args ) {
		
		//erzeuge Referenz auf 'DateiAnzeiger'
		DateiAnzeiger da = new DateiAnzeiger( );
		
		// erzeuge ein Dateiauswahldialog und übergebe den returnstate an 'option'
		da.fc = new JFileChooser( );
		da.option = da.fc.showOpenDialog( null );
		
		if ( da.option == JFileChooser.APPROVE_OPTION ) { // ging alles glatt ?
			
			//erzeuge FileObjekt und übergebe den zuvor ausgewählten Dateinamen
			File file = da.fc.getSelectedFile( );
			da.erzeugeFensterUndLeseDateiAus( file );
		} else { // falls nicht
			
			System.out.println( "Auswahl abgebrochen" );
			System.exit( 0 );
		}
	}
}
