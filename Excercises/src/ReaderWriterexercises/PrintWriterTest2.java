package ReaderWriterexercises;

import java.io.*;
import static  java.lang.Math.PI;

class PrintWriterTest2
{
	public static void main(String[] args)
	{

		PrintWriter pw = new PrintWriter(System.out, true);

		pw.println("Ausgabe des Flächeninhalts für Kreise mit");

		for (int r = 1; r <= 100; r++)
		{
			pw.print("Radius r = " + r + ": "); 
			pw.println(PI * r * r); 

			for (int f = 1; f <= 10000000; f++)
			{
				int d = f;
			}
		}
		pw.close();
	}
}

// flush erzwingt ein Schreiben, bevor der Buffer voll ist.