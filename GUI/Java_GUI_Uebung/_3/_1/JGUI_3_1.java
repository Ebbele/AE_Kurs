package _3._1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JGUI_3_1 {
	JFrame frame = null;
	JPanel panel = null;
	public Polygon poly = null;
	public Dimension dimension;

	public JGUI_3_1(JFrame frame, Dimension dimension) {
		this.frame = frame;
		this.dimension = dimension;
		this.panel = drawArea();
		this.frame.add(panel);
		this.frame.pack();
	}

	public void setPoly(Polygon poly) {
		this.poly = poly;
	}
	
	public Point getCenters(){
		return new Point(panel.getWidth()/2, panel.getHeight() / 2);
	}
	
	public JPanel drawArea() {
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.CYAN);
				if (null != poly) {
					g.fillPolygon(poly);
				} else {
					g.setColor(Color.YELLOW);
					int centerX = (this.getWidth() / 2) - ((dimension.width / 2) / 2);
					int centerY = (this.getHeight() / 2) - ((dimension.height / 2) / 2);
					int width = dimension.width / 2;
					int height = dimension.height / 2;

					g.fillOval(centerX, centerY, width, height);
				}
			}
		};
		
		panel.setPreferredSize(dimension);
		panel.setSize(dimension);
		return panel;

	}
}
