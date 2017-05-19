package Kap14;

public class Exercise4 
	{
	  public Exercise4()
	  {

		    System.out.println("10111011 ist " + BinaryStringToNumber.parseBinary("10111011"));
		    String s = "10511011";
		    System.out.println(s + " ist " + BinaryStringToNumber.parseBinary(s));

		}

	  public static void main(String[] args)
	  {
		  try{
	    Exercise3 ConvertingBinary = new Exercise3();
	    irgendEineMethode();
		  }
		  catch(NoBinaryNumberException e){
			  System.out.println("Ficken, 3,20€");
		  }
	    
	  }
	  
	  public static void irgendEineMethode() throws NoBinaryNumberException {
		  new Exercise4();
	  }	
}



