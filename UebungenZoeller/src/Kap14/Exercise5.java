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
    Exercise3 ConvertingBinary = new Exercise3();
  }
  
 void excpectionweiterreichen (String s)	throws NoBinaryNumberException
 {
	 try{
		 BinaryStringToNumber.parseBinary(s);
	 }
	 catch(NoBinaryNumberException e){
		 System.out.println("Kein Binärzahl");
		 
	 }
 }
}

