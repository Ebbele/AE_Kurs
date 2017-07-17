package ReaderWriterexercises;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilterCharacters {

	public static void main( String[ ] args ) {
		
		Scanner scanner = new Scanner( System.in );
		
		try  (PrintWriter pw = new PrintWriter( new MyFilterWriter( new FileWriter( "filter.dat" ) ) ) ) {
			pw.write( scanner.next( ) );
		} catch ( IOException e ) {
			
			e.printStackTrace();
		}
		scanner.close();
	}
}
