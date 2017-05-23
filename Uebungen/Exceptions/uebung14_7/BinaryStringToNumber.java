package uebung14_7;

public class BinaryStringToNumber {
	public static int parseBinary(String binStr) throws NoBinaryNumberException {
		int pos = 0;
		char c;
		for (int i = 0, max = binStr.length(); i < max; i++) {
			c = binStr.charAt(i);
			switch (c) {
			case '0':
			case '1':
				pos *= 2;
				if( c == '1'){
					pos++;
				}
				break;
			default:
				throw new NoBinaryNumberException( binStr, ++i);
			}
		}
		return pos;
	}
}
