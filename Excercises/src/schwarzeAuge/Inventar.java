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
	
	public boolean addItem( final Item item ) {
		boolean add = false;
		if ( item instanceof Ruestung ) {
			add = addRuestung( ( Ruestung ) item);
			return add;
		}
		else if( item instanceof Schilde ) {
			add = addSchild( ( Schilde ) item );
			return add;
		}
		else if( item instanceof Waffen ) {
			add = addWaffe( ( Waffen ) item );
			return add;
		}
		/*else if( item instanceof Trank ) {
			deleted = addTrank( (Trank) item );
			return add;
		}*/
		return add;
	}
	
	public boolean removeItem( final Item item ) {
		boolean deleted = false;
		if ( item instanceof Ruestung ) {
			deleted = removeRuestung( ( Ruestung ) item);
			return deleted;
		}
		else if( item instanceof Schilde ) {
			deleted = removeSchild( ( Schilde ) item );
			return deleted;
		}
		else if( item instanceof Waffen ) {
			deleted = removeWaffe( ( Waffen ) item );
			return deleted;
		}
		/*else if( item instanceof Trank ) {
			deleted = removeTrank( (Trank) item );
			return deleted;
		}*/
		return deleted;
	}
	
	private boolean addRuestung( final Ruestung ruestung ) {
		if ( inventar.size( ) < INVENTARGROESSE ) {
			this.inventar.add( ruestung );
			return true;
		}
		return false;
	}
	
	private boolean addSchild( final Schilde schild ) {
		if ( inventar.size( ) < INVENTARGROESSE ) {
			this.inventar.add( schild );
			return true;
		}
		return false;
	}
	
	private boolean addWaffe( final Waffen waffe ) {
		if ( inventar.size( ) < INVENTARGROESSE ) {
			this.inventar.add( waffe );
			return true;
		}
		return false;
	}
	
	/*private boolean addTrank(  Trank trank  ) {
		if ( inventar.size( ) < INVENTARGROESSE ) {
			this.inventar.add( trank );
			return true;
		}
		return false;
	}*/
	
	private boolean removeRuestung( final Ruestung ruestung ) {
		Iterator< Item > ruestungsIter = this.inventar.iterator( );
		while( ruestungsIter.hasNext( ) ) {
			if ( ruestungsIter.next( ).equals( ruestung ) ) {
				ruestungsIter.remove( );
				return true;
			}
		}
		return false;
	}
	
	private boolean removeSchild( final Schilde schild ) {
		Iterator< Item > schildIter = this.inventar.iterator( );
		while( schildIter.hasNext( ) ) {
			if ( schildIter.next( ).equals( schild ) ) {
				schildIter.remove( );
				return true;
			}
		}
		return false;
	}
	
	private boolean removeWaffe( final Waffen waffe ) {
		Iterator< Item > waffenIter = this.inventar.iterator( );
		while( waffenIter.hasNext( ) ) {
			if ( waffenIter.next( ).equals( waffe ) ) {
				waffenIter.remove( );
				return true;
			}
		}
		return false;
	}
	
	/*private boolean removeTrank( final Trank trank ) {
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
	
	public void printWaffen( ) {
		Iterator< Item > invIter = this.inventar.iterator( );
		while( invIter.hasNext( ) ) {
			if ( invIter.next( ) instanceof Waffen )
				System.out.println( invIter.toString( ) );
		}
	}
	
	public void printSchilde( ) {
		Iterator< Item > invIter = this.inventar.iterator( );
		while( invIter.hasNext( ) ) {
			if ( invIter.next( ) instanceof Schilde )
				System.out.println( invIter.toString( ) );
		}
	}
	
	public void printRuestung( ) {
		Iterator< Item > invIter = this.inventar.iterator( );
		while( invIter.hasNext( ) ) {
			if ( invIter.next( ) instanceof Waffen )
				System.out.println( invIter.toString( ) );
		}
	}
	
	/*public void printTrank( ) {
		Iterator< Item > invIter = this.inventar.iterator( );
		while( invIter.hasNext( ) ) {
			if ( invIter.next( ) instanceof Trank )
				System.out.println( invIter.toString( ) );
		}
	}*/
}
