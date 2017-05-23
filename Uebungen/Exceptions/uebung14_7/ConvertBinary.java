package uebung14_7;

public class ConvertBinary {
	public static int parseBinary(String binStr) {
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
				return -1;
			}
		}
		return pos;
	}
}
