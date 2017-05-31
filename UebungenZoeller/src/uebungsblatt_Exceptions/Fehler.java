package uebungsblatt_Exceptions;

public class Fehler {
	
	public static void fehler1() {
		int ai[] = { 0, 1, 2 };
		ai[3] = 4;
	}

	public static void fehler2() {
		int i = 5 / 0;
	}
}