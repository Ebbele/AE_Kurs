package uebung14_7;

public class ConvertBinaryTest {
	public ConvertBinaryTest() {
		System.out.println("10111011 ist " + ConvertBinary.parseBinary("10111011"));
		String s = "10511011";
		System.out.println(s + " ist " + ConvertBinary.parseBinary(s));
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConvertBinaryTest ConvertingBinary = new ConvertBinaryTest();
	}
}
