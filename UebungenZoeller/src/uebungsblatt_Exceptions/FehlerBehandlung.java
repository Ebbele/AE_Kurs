package uebungsblatt_Exceptions;

public class FehlerBehandlung {

	public static void main(String[] args) {
		
		
		try{
			Fehler.fehler1();
			}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Fehler1:" +e);
		}
		try{
			Fehler.fehler2();
		}
		catch(ArithmeticException e){
			System.out.println("Fehler1:" +e);
		}
	}

}
