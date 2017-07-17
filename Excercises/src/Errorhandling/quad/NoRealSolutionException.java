package Errorhandling.quad;

public class NoRealSolutionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	NoRealSolutionException( ) {
		super( );
		System.out.println( " Diskriminate ist < 0 -> keine reelle Lösung" );
	}

}
