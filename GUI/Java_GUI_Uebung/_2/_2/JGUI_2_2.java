package _2._2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

import _2.JGUI_2;

public class JGUI_2_2 extends JGUI_2{
	boolean btnClicked = false;
	public JGUI_2_2(String winTitle, Dimension d) {
		super(winTitle, d);
	}
	
	public void filledCircle(JFrame frame,Dimension d){
		JPanel panel = new JPanel(){
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.setColor(Color.YELLOW);
				int centerX = (this.getWidth()/2) - ((d.width/2) / 2);
				int centerY = (this.getHeight()/2) - ((d.height/2) / 2);
				int width = d.width/2;
				int height = d.height/2;
				if(btnClicked){
					g.fillRect(centerX,centerY, width, height);
				}else{
					g.fillOval(centerX,centerY, width, height);
				}
			}
		};
		panel.setPreferredSize(d);
		panel.setSize(d);
		frame.add(panel);
	}

}
