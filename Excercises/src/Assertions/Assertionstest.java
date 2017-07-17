package Assertions;

public class Assertionstest {

	public static void main ( String [ ] args ) {
		System.out.println( args[ 0 ] + " - " + args[ 1 ] );
		assert args.length == 2 : "Es wurden " + args.length + " Parameter übergeben. Es sind aber nur 2 erlaubt!";
	}
	
}
