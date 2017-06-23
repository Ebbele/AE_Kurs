package aufgabe4_Threads;

public class Ziehbrunnen {

	public static void main(String[] args) {
		System.out.println("Starte Ziehbrunnen");

		Schoepfer pumpe = new Schoepfer(0);
		Schoepfer verteiler = new Schoepfer(1);
		pumpe.start();
		verteiler.start();
		
	}

}
