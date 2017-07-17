package schwarzeAuge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventar {

	private final int INVENTARGROESSE;
	private List< Item > inventar = new ArrayList< Item >( );
	
	{
		INVENTARGROESSE = 26;
	}
	
	public boolean addRuestung( final Ruestung ruestung ) {
		if ( inventar.size( ) < INVENTARGROESSE ) {
			this.inventar.add( ruestung );
			return true;
		}
		return false;
	}
	
	public boolean addSchild( final Schilde schild ) {
		if ( inventar.size( ) < INVENTARGROESSE ) {
			this.inventar.add( schild );
			return true;
		}
		return false;
	}
	
	public boolean addWaffe( final Waffen waffe ) {
		if ( inventar.size( ) < INVENTARGROESSE ) {
			this.inventar.add( waffe );
			return true;
		}
		return false;
	}
	
	/*public boolean addTrank(  Trank trank  ) {
		if ( inventar.size( ) < 26 ) {
			this.inventar.add( trank );
			return true;
		}
		return false;
	}*/
	
	public boolean removeRuestung( final Ruestung ruestung ) {
		Iterator< Item > ruestungsIter = this.inventar.iterator( );
		while( ruestungsIter.hasNext( ) ) {
			if ( ruestungsIter.next( ).equals( ruestung ) ) {
				ruestungsIter.remove( );
				return true;
			}
		}
		return false;
	}
	
	public boolean removeSchild( final Schilde schild ) {
		Iterator< Item > schildIter = this.inventar.iterator( );
		while( schildIter.hasNext( ) ) {
			if ( schildIter.next( ).equals( schild ) ) {
				schildIter.remove( );
				return true;
			}
		}
		return false;
	}
	
	public boolean removeWaffe( final Waffen waffe ) {
		Iterator< Item > waffenIter = this.inventar.iterator( );
		while( waffenIter.hasNext( ) ) {
			if ( waffenIter.next( ).equals( waffe ) ) {
				waffenIter.remove( );
				return true;
			}
		}
		return false;
	}
	
	/*public boolean removeTrank( final Trank trank ) {
		Iterator< Item > trankIter = this.inventar.iterator( );
		while( trankIter.hasNext( ) ) {
			if ( trankIter.next( ).equals(  trank  ) ) {
				trankIter.remove( );
				return true;
			}
		}
		return false;
	}*/
	
	public List< Item > getInventarAlsListe( ) {
		return this.inventar;
	}
	
	public void printInventar( ) {
		Iterator< Item > invIter = this.inventar.iterator( );
		while( invIter.hasNext( ) ) {
			System.out.println( invIter.next( ).toString( ) );
		}
	}
}
