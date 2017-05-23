package Kap16;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class Dateien {
	
	public static void main(String []args){
		
		Path file= Paths.get("C:\\Java Fun\\DateienIO\\Alphabet.txt");
		String s="Das umgekehrte Alphabet";
		byte data[]=s.getBytes();
		
		byte zeichen[]=new byte[26];
		int j;
		
		ByteBuffer insert= ByteBuffer.wrap(data);
		ByteBuffer move = ByteBuffer.allocate(26);
		ByteBuffer out;
		
		
		if(Files.exists(file)){
			System.out.format(file.toString()+" existiert.");
		}
		else{
			try{
				Files.createDirectories(file.getParent());
				Files.createFile(file);
				try(FileChannel fc = (FileChannel.open(file, READ,WRITE))){
					fc.position(0);
					
				}
				catch(IOException x)
				{
					System.out.println("I/= Exception: "+x);
				}
				
			}
			catch(IOException ex){
				System.err.ptintln(ex);
			}
		}
	}
}
