package uebungen_07_06_2017._20_Swing_ErsteAufgaben;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrameMitText {

	public static final String errorProgCall = "java FrameMitText <Titel> <Breite> <Hoehe> <Pfad zur Datei>";
	public static final String errorInt = "Sowohl Breite als auch Hoehe muessen als Ganzzahl angegeben werden.";
	
	public static void main(String[] args) {
		if(args.length != 4){
			System.out.println(errorProgCall);
			System.exit(1);
		}
		
		String frameTitle = args[0];
		int frameHeight = 0;
		int frameWidth = 0;
		try{
			frameHeight = Integer.parseInt(args[1]);
			frameWidth = Integer.parseInt(args[2]);
		}catch(NumberFormatException e){
			System.out.println(errorInt);
			System.exit(1);
		}
		
		try( BufferedReader read = Files.newBufferedReader(Paths.get(args[3]), Charset.forName("UTF-8"))){
			
			JTextArea txt = new JTextArea();
			txt.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(txt);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setPreferredSize(new Dimension(frameWidth, frameHeight));
			String line = "";
			while( null != (line = read.readLine())){
				txt.append(line+System.getProperty("line.separator"));
			}
			
			// Fenster zusammen setzten
			JFrame frame = new JFrame(frameTitle);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(scrollPane);
			frame.pack();
			frame.setVisible(true);
		}catch(IOException e){
			System.out.println("Angegebene Datei nicht gefunden !");
			System.exit(1);
		}
	}

}
