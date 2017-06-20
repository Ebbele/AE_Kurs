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

	private int charData[][] = new int[tanz.length()][4];
	
	public TanzendeSchrift() {
		setTitle("Tanzende Schrift");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel drawing = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				
			
			}
		};
		
		Font f = new Font("Arial", Font.BOLD, 18);
		FontMetrics metrics = drawing.getFontMetrics(f);
		
		Rectangle2D bounds = metrics.getStringBounds(tanz, drawing.getGraphics());
		
		drawing.setPreferredSize( new Dimension((int)bounds.getWidth()*2,(int) bounds.getHeight()*6));
		add(drawing);
		pack();
		setVisible(true);
		
		
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

