package Kap14;

public class NoBinaryNumberException extends RuntimeException {
	
	public NoBinaryNumberException(){
		
	}
	
	public NoBinaryNumberException(String msg){
		super(msg);
	}
	
	public NoBinaryNumberException(String bZahl, int pos){
		super(bZahl+" Ist keine Bin�rzahl("+ pos+ ". Stelle)");
			
		}
	
	public void wirf(){
		
	}

}

