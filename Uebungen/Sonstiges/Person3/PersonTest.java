package Person3;
public class PersonTest
{		
	public static void main(String[] args)
	{	
		DateiVerarbeitung daten = new DateiVerarbeitung();
		PersonMethoden persTest = new PersonMethoden(daten);

		do
		{
			persTest.menue();
			persTest.menueAusw();			
		}while(true);				
	}
}