package Candy2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


class Spielfeld {

	int feldgroesse;
	int [][] feld = new int [feldgroesse][feldgroesse];
	JButton[][] buttonFeld;
	
	
	Spielfeld(int feldgroesse) {
		this.feldgroesse = feldgroesse;
		buttonFeld = new JButton [feldgroesse][feldgroesse];
		genFrame(feldgroesse);
		
	}
	
	

	private int[][] setColors(int anzahl) {

		int[][] feld = new int[anzahl][anzahl];
		
		for (int i=0;i<feld.length;i++) {
			for (int j=0;j<feld.length;j++) {
				
				try {
					if (i<2&&j<2) {
						feld[i][j] = (int)((Math.random()) * 7+1);
					} else if (i<2) {
						do {
							feld[i][j] = (int)((Math.random()) * 7+1);
						} while (feld[i][j]==feld[i][j-1] && feld[i][j]==feld[i][j-2]);
					} else if (j<2) {
						do {
							feld[i][j] = (int)((Math.random()) * 7+1);
						} while (feld[i][j]==feld[i-1][j] && feld[i][j]==feld[i-2][j]);
					} else {
						do {
							feld[i][j] = (int)((Math.random()) * 7+1);
						} while ((feld[i][j]==feld[i][j-1] && feld[i][j]==feld[i][j-2])
								|| (feld[i][j]==feld[i-1][j] && feld[i][j]==feld[i-2][j]));
					}
			
				} catch (ArrayIndexOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					System.out.println("ung�ltig");
				}
				
				//System.out.println(feld[i][j]);
				
				
			}
		}
		
		return feld;
	
	}
	
	private void genFrame(int feldgroesse) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		Container con = new Container();
		con = frame.getContentPane();
		con.setLayout(new GridLayout(feldgroesse,feldgroesse));
		
		int[][] colors = new int[feldgroesse][feldgroesse];
		colors = setColors(feldgroesse);
		this.feld= colors;
		for (int i=0;i<feldgroesse;i++) {
			System.out.println("");
			for (int j=0;j<feldgroesse;j++) {
				//JButton b = new JButton();
				//buttonFeld[i][j] = b;
				con.add (new createButton(colors[i][j],i,j));
				System.out.print(colors[i][j]);
			}
		}
		
		frame.pack();
		frame.setVisible(true);
	}
	

	
	private class createButton extends JPanel {
		
		createButton me;
		
		public createButton(int color, int i, int j) {
            
			me = this;
			
			
			
			
            JButton button = new JButton();
           
            buttonFeld[i][j] = button;
            switch (color) {
			case 1: button.setBackground(Color.red); break;
			case 2: button.setBackground(Color.green); break;
			case 3: button.setBackground(Color.yellow); break;
			case 4: button.setBackground(Color.blue); break;
			case 5: button.setBackground(Color.cyan); break;
			case 6: button.setBackground(Color.orange); break;
			case 7: button.setBackground(Color.magenta); break;
			
			}
            Border blackline, empty;
            empty = BorderFactory.createEmptyBorder();
            blackline = BorderFactory.createLineBorder(Color.black);
            
            button.setPreferredSize(new Dimension (60,60));
			button.setOpaque(true);
			button.setBorderPainted(true);
			button.setBorder(empty);
			
            button.addActionListener(new ActionListener(){
            
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                	
                   for (int i=0;i<feldgroesse;i++) {
            			
            			for (int j=0;j<feldgroesse;j++) {
            				if( e.getSource() == buttonFeld[i][j]) {
            					System.out.println(i + " " + j);
            					
            					
            						buttonFeld[i][j].setBorder(blackline);
            						
            					
            					
            				}
            			}
                	}
      
                   //button.setBackground(Color.black);
                  
                }
            });
            add(button);
        }
		
	}
	public int getFeldgroesse() {
		return feldgroesse;
	}



	public void setFeldgroesse(int feldgroesse) {
		this.feldgroesse = feldgroesse;
	}

	
}
