package CandyCrushFuerArme.warnix;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayingField {

	private JFrame frame;
	private JPanel panel;
	
	private List< Tile > tileList;
	private char column;
	private int row;
	private final int COMPONENTSCALE;
		
	{
		tileList = new ArrayList< Tile >( );
		column = 'A';
		row = 0;
		COMPONENTSCALE = 40;
	}

	
	PlayingField( int playfieldScale ) {
		
		frame = new JFrame( );
		frame.setTitle( "CandCrush fuer Arme" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				
		panel = new JPanel( );
		GridLayout gl = new GridLayout( playfieldScale, playfieldScale );
		panel.setLayout( gl );
		frame.setContentPane( panel );
		
		for ( int i = 0; i < Math.pow( playfieldScale, 2 ); i++ ) {
			
			tileList.add( createTile( i, playfieldScale ) ); 
		}
		
		createPlayfield( tileList, panel );
		
		frame.addMouseListener( new MouseAdapter( ) {
			
			public void mouseClicked( MouseEvent me ) {
				
				// System.out.println(me.getY( ) + me.getX( ) );
				validateCoordinates( me.getX(), me.getY() );
			}
		});
		frame.setResizable( false );
		frame.setSize( ( playfieldScale * COMPONENTSCALE ), ( playfieldScale * COMPONENTSCALE ) );
		frame.setVisible( true );
	}
	
	public Tile createTile( int position, int playfieldScale ) {
		
		int x = 0;
		int y = 0;
		if ( position < playfieldScale ) {
			
			Tile tile = position != 0 ? new Tile( String.valueOf( row ) ): new Tile( "" );
			row++;
			return tile;
		} else {
			
			Tile tile = ( position % playfieldScale == 0 ) ? new Tile( String.valueOf( column ) ) : new Tile( x, y );
			
			if ( y++ == playfieldScale ) {
				x++;
				y = 0; 
			}
			if ( position % playfieldScale == 0 )
				column++;
			
			return tile;
		}
	}
	
	public JPanel createPlayfield( List< Tile > tileList, JPanel panel ) {
		
		Iterator< Tile > tileListIterator = tileList.iterator( );

		while ( tileListIterator.hasNext( ) ) {
			
			panel.add( ( JLabel ) tileListIterator.next( ).getTile( ) );
		}
		return panel;
	}
	
	public String validateCoordinates( int x, int y ) {

		y =  ( y - COMPONENTSCALE ) / COMPONENTSCALE;
	    y = 'A' + y;
	    x =  x  / COMPONENTSCALE;
	    // todo koordinaten
	    String s = Character.toString( ( char ) y ) + String.valueOf( x );
	    return s;
	}
}