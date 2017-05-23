package uebung14_7;

public class Exercise4 {
	public static void binTest(){
		System.out.println("10111011 ist " + BinaryStringToNumber.parseBinary("10111011"));
		String s = "10511011";
		System.out.println(s + " ist " + BinaryStringToNumber.parseBinary(s));
	}
	
	public Exercise4() {
		try{
			binTest();
		}
		catch(NoBinaryNumberException except){
			//System.out.println(except.getMessage());
			throw except;
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Exercise4 ConvertingBinary = new Exercise4();
	}
}
