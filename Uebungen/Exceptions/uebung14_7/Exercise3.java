package uebung14_7;

public class Exercise3 {
	public Exercise3() {
		System.out.println("10111011 ist " + BinaryStringToNumber.parseBinary("10111011"));
		String s = "10511011";
		System.out.println(s + " ist " + BinaryStringToNumber.parseBinary(s));
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Exercise3 ConvertingBinary = new Exercise3();
	}
}
