import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LangeZeilen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String puffer;
		int counter = 0;
		int irgendwas = 0;
		
		if (args.length<2) {
			System.out.println("Aufruf:...");
		}
		File file=new File(args[1]);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			while ((puffer=br.readLine())!=null) {
			System.out.println(puffer);	
			irgendwas = puffer.length();
			if (irgendwas>(Integer.parseInt(args[0]))) {
			counter++;	
			}
			}
			
		} catch(FileNotFoundException e) {
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Die Datei "+args[1]+" enthält "+counter+" Zeilen, die länger als "+args[0]+" Zeichen sind.");
		
	}

}
