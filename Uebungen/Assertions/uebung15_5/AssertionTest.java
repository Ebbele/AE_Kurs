package uebung15_5;

public class AssertionTest {

	public static void main(String[] args) {
		assert (args.length == 2) : "Programmaufruf muss mit 2 Parametern erfolgen!";
		//System.out.println("Arg 1: "+ args[0]);
		//System.out.println("Arg 2: "+ args[1]);
		System.out.println("Assertion Test gelaufen");
	}

}
