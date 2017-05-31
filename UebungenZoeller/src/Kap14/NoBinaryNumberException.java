package Kap14;

public class NoBinaryNumberException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoBinaryNumberException(){
		
	}
	
	public NoBinaryNumberException(String msg){
		super(msg);
	}
	
	public NoBinaryNumberException(String bZahl, int pos){
		super(bZahl+" Ist keine Binaerzahl("+ pos+ ". Stelle)");
			
		}
	
	

}

