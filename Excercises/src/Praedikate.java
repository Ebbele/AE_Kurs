import java.util.function.Predicate;

public class Praedikate {
	public static void main( String[ ] args ) {
		final Predicate<String> isNull = str -> str == null;
		final Predicate<String> isEmpty = String::isEmpty;
		
		System.out.println("isNull('')	" + isNull.test(""));
		System.out.println("isEmpty('')	" + isEmpty.test(""));
		
	}
}
