package aufgabe2_Dateien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Dateien {
	
	public static String paramError(){
		String err = "Aufruf: java <Programm> <n> <Datei>"
				+ "\nn     : Ganzzahl, gibt an wieviele Zeichen die Ziele enthalten muss"
				+ "\nDatei : Pfad der einzulesenden Datei";
		return err;
	}

	public static void main(String[] args) {
		if( args.length != 2){
			System.out.println(paramError());
			System.exit(0);
		}
		
		int n = Integer.parseInt(args[0]);
		Path path = Paths.get(args[1]);
	
		try(BufferedReader buf = new BufferedReader(new FileReader(path.toString()))){
			int count = 0;
			String line = null;
			while(null != (line = buf.readLine())){
				if(line.length() > n)
					count++;
			}
			System.out.println("Die Datei \""+path.getFileName()+"\" enth\u00e4lt "+count+" Zeilen, die l\u00e4nger als " + n +" Zeichen sind." );
		}catch(IOException e){
			e.printStackTrace();
		};
	}

}
