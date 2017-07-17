package Threads.Schoepfer;

public class Ziehbrunnen {

	public static void main( String[ ] args ) {
		
		Schoepfer pumpe, verteiler;
		
		pumpe = new Schoepfer( "pumpe" );
		verteiler = new Schoepfer( "verteiler" );
		
		pumpe.start();
		verteiler.start();
	}
}
