package CandyCrushFuerArme;

import javax.swing.JOptionPane;

public class CandyCrushGo {
	
	CandyCrushGo( ) {
		
		String s = JOptionPane.showInputDialog( "Bitte die Gr��e des Spielfelds eingeben" );
		new PlayingField( Integer.parseInt( s ) );
	}

	public static void main( String[ ] args ) {
		
		new CandyCrushGo( );
	}
}
