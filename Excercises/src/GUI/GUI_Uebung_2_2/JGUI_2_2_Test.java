package GUI.GUI_Uebung_2_2;

import javax.swing.JOptionPane;

import GUI.GUI_Uebung_2_2.JGUI_2_2;

public class JGUI_2_2_Test {
	
	public static void main ( String[ ] args ) {
			
		JGUI_2_2 uebung_2_2 = new JGUI_2_2( );
		uebung_2_2.newWindow( );	
		uebung_2_2.reply = JOptionPane.showConfirmDialog( null, uebung_2_2.nachricht, uebung_2_2.titel, JOptionPane.YES_NO_OPTION );
		uebung_2_2.newWindow( );		
	}
}
