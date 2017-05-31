package Kap14;

public class Exercise5 
{
  public Exercise5()
  {

	    System.out.println("10111011 ist " + BinaryStringToNumber.parseBinary("10111011"));
	    String s = "10511011";
	    System.out.println(s + " ist " + BinaryStringToNumber.parseBinary(s));

	}

  public static void main(String[] args)
  {
	try{
	    Exercise5 ConvertingBinary = new Exercise5();
	    irgendEineMethode();
	}
	catch(NoBinaryNumberException e){
		  System.out.println("Keine Binärzahl");
	}
	finally{
		  System.out.println("Bitte Binärzahl eingeben or what?!");
	}
    
  }
  
  public static void irgendEineMethode() throws NoBinaryNumberException {
	  new Exercise5();
  }	
}


