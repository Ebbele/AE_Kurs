package inheritance_polymorphism;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AttentionScrollbar extends Scrollbar {

	private static final long serialVersionUID = 1L;
	
	public int critical;
	static int oldValue;
	
	{
		critical = 0;
		oldValue = 0;
	}

	public void incCritical( ) {
		
		critical++;
	}
	
	public int getCritical( ) {
		
		return this.critical;
	}
	
	public static void main( String[ ] args ) {

		Frame f = new Frame( );
		f.addWindowListener(new WindowAdapter() {
			
			public void windowClosing( WindowEvent windowEvent ){
				
				System.exit( 0 );
	        }        
	    });
		
		Panel panel = new Panel( );
		AttentionScrollbar att = new AttentionScrollbar( );
		Label lbl = new Label( );
		Color colorOrigin = att.getBackground( );
		Color colorCritical = new Color( 255, 0, 0 );
		AdjustmentListener Listener = new AdjustmentListener( ) {
			
			@Override
			public void adjustmentValueChanged( AdjustmentEvent event ) {
				
				
				if ( event.getValue( ) == ( att.getMaximum( ) / 2) && oldValue == ( event.getValue( ) - 1 ) ) {

					att.setBackground( colorCritical );	
					att.incCritical( );	
				}
				
				if ( event.getValue( ) < ( ( att.getMaximum( ) / 2 ) - 1 ) ) {
					
					att.setBackground( colorOrigin );	
				}
				lbl.setText("Current Adjustmentvalue: " + event.getValue( ) + " - " + "Critical: " +  String.valueOf( att.getCritical( ) ) );
				oldValue = event.getValue( );
			}
		};		
		att.addAdjustmentListener( Listener );
		
		panel.setLayout( new GridLayout( 1, 1 ) );
		panel.add( att );
		panel.add( lbl );
		
		f.add( panel );
		f.setSize( 500, 200 );
		f.setVisible( true );
	}
}
