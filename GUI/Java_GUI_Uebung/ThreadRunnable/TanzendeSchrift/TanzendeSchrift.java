package ThreadRunnable.TanzendeSchrift;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TanzendeSchrift extends JFrame implements Runnable{

	static final String tanz = "Tobias Ebbers"; 
	static final Font font = new Font("Arial", Font.BOLD, 28);
	private int charData[][] = new int[tanz.length()][4];
	
	public TanzendeSchrift() {
		setTitle("Tanzende Schrift");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel drawing = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				g.setFont(font);
				for(int c = 0, max = tanz.length(); c < max; c++) {
					g.drawString(String.valueOf(tanz.charAt(c)), charData[c][0], 64);
				}
			}
		};
				
		
		FontMetrics metrics = drawing.getFontMetrics(font);
		
		Rectangle2D bounds = metrics.getStringBounds(tanz, drawing.getGraphics());
		
		int x = 0;
		
		for(int c = 0, max = tanz.length(); c < max; c++) {
			charData[c][0] = x;
			x += metrics.charWidth(tanz.charAt(c));
		}
		
		drawing.setPreferredSize( new Dimension((int)bounds.getWidth()*2,(int) bounds.getHeight()*4));
		add(drawing);
		pack();
		setVisible(true);
		
		System.out.println(drawing.getSize());
		
	}
	
	@Override
	public void run() {
		while(isVisible()) {
			//System.out.println("RUN");
		}
	}

	public static void main(String[] args) {
		TanzendeSchrift schrift = new TanzendeSchrift();
		Thread tanz = new Thread(schrift);
		tanz.start();
	}

}

