package Candy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Spielfeld {

	
	
	
	public void FeldGenerieren(int felder) {
		
		//Array mit Zahlenwerten für Farben
		int[][] feld = new int[felder][felder];
		
		for (int i=0;i<feld.length;i++) {
			for (int j=0;j<feld.length;j++) {
				
				
				try {
					do {
						feld[i][j] = (int)((Math.random()) * 7+1);
					} while ((feld[i][j]==feld[i][j-1] && feld[i][j]==feld[i][j-2])
							|| (feld[i][j]==feld[i-1][j] && feld[i][j]==feld[i-2][j]) );
				} catch (ArrayIndexOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					System.out.println("ungültig");
				}
				
				System.out.println(feld[i][j]);
				
				
			}
		}
		
		// Fenster Erstellen
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		Container container = new Container();
		container = frame.getContentPane();
		
		// Grid mit übergebener Größe erstellen
		
		container.setLayout(new GridLayout(felder,felder));
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("click");
				
				System.out.println(e.getSource());
				
				
			}
		};
		
		//Buttons erstellen und Farbe anhand des Arrays wählen
		for (int i=0;i<feld.length;i++) {
			for (int j=0;j<feld.length;j++) {

				
				container.add(new createButton(feld[i][j]));
				frame.pack();
				
				/*
				JButton a1 = new JButton();
				a1.addActionListener(al);
				
				switch (feld[i][j]) {
				case 1: a1.setBackground(Color.red); break;
				case 2: a1.setBackground(Color.green); break;
				case 3: a1.setBackground(Color.yellow); break;
				case 4: a1.setBackground(Color.blue); break;
				case 5: a1.setBackground(Color.cyan); break;
				case 6: a1.setBackground(Color.orange); break;
				case 7: a1.setBackground(Color.magenta); break;
				
				}
				a1.setPreferredSize(new Dimension (60,60));
				a1.setOpaque(true);
				a1.setBorderPainted(false);
				
				
				container.add(a1);
				*/
			}
			
			
			
			
			
		}
		
		
		
		//frame.setSize(felder*60, felder*60);
		frame.pack();
		frame.setVisible(true);
	}
	
	private class createButton extends JPanel {
		
		createButton me;
		
		public createButton(int color) {
            
			me = this;
			
			
			
            JButton button = new JButton();
            switch (color) {
			case 1: button.setBackground(Color.red); break;
			case 2: button.setBackground(Color.green); break;
			case 3: button.setBackground(Color.yellow); break;
			case 4: button.setBackground(Color.blue); break;
			case 5: button.setBackground(Color.cyan); break;
			case 6: button.setBackground(Color.orange); break;
			case 7: button.setBackground(Color.magenta); break;
			
			}
            button.setPreferredSize(new Dimension (60,60));
			button.setOpaque(true);
			button.setBorderPainted(false);
            
            button.addActionListener(new ActionListener(){
            
                @Override
                public void actionPerformed(ActionEvent e) {
                   System.out.println(me.getParent());
                 
                }
            });
            add(button);
        }
		
	}
	
}
