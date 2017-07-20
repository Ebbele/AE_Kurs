package cc.zoeller.ae.projekt.game;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cc.zoeller.ae.projekt.game.items.Item;


public class Inventar {
	
	private final int INVENTARGROESSE;
	
	private List< Item > inventar = new ArrayList< >( );
	
	{
		INVENTARGROESSE = 26;
	}
	
	public void initInventarFrame( ) {
		Dimension d = new Dimension( 40, 40 );
		JFrame frame = new JFrame( );
		JPanel panel = new JPanel( new GridLayout( 5, 5 ) );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Iterator< Item > inventarIter = this.inventar.iterator( );
		while( inventarIter.hasNext( ) ) {
			JButton button = new JButton( );
			button.setPreferredSize(d);
			button.setToolTipText( inventarIter.next( ).getItemName( ) );
			panel.add( button );			
		}
		frame.add(panel);
		frame.pack( );
		frame.setVisible( true );
	}
	
	public List< Item > getInventar( ) {
		return this.inventar;
	}
	
	public boolean addItem( final Item item ) {
		if ( item instanceof Item && inventar.size( ) < INVENTARGROESSE ) {
			this.inventar.add( item );
			return true;
		}
		return false;
	}
	
	public boolean removeItem( final Item item ) {
		Iterator< Item > inventarIter = this.inventar.iterator( );
		if( item instanceof Item ) {
			while( inventarIter.hasNext( ) ) {
				if( inventarIter.next().equals( item ) ) {
					inventarIter.remove();
					return true;
				}
			}
		}
		return false;
	}
}
