package uebung14_7;
public class NoBinaryNumberException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoBinaryNumberException() {
		super();
	}

	public NoBinaryNumberException(String message) {
		super(message);
	}
	
	public NoBinaryNumberException(String binary, int position) {
		super("Binaer String: \""+ binary + "\" fehlerhaft an Stelle: "+position);
	}


}
