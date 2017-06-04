package _2._1;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import _2.JGUI_2;

public class JGUI_2_1 extends JGUI_2 {

	public JGUI_2_1(String winTitle, Dimension d) {
		super(winTitle, d);
	}

	public JPanel drawArea(boolean addToFrame, int width, int height) {
		JPanel panel = new JPanel(){

			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				int circleWidth = (int)width/2;
				int circleHeight = (int)height/2;
				int centerX = (this.getWidth()/2) - (circleWidth / 2);
				int centerY = (this.getHeight()/2) - (circleHeight / 2);
				g.drawOval(centerX, centerY, circleWidth, circleHeight);
			}
		};
		panel.setPreferredSize(new Dimension(width, height));
		panel.setSize(width, height);

		if (addToFrame) {
			frame.add(panel);
		}
		return panel;
	}

}
