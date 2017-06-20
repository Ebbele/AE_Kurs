package ThreadRunnable.TanzendeSchrift;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TanzendeSchrift extends JFrame implements Runnable{

	static final String tanz = "Dieser Text Tanz so vor sich hin"; 
	static final Font font = new Font("Arial", Font.BOLD, 32);
	// charData[][0] = x pos
	// charData[][1] = y pos
	// charData[][2] = direction : -1 up , 1 down
	private int charData[][] = new int[tanz.length()][3];
	private Color colData[] = new Color[tanz.length()];
	public int fontHeight = 0;
	public int fontAscent = 0;
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
					g.setColor(colData[c]);
					g.drawString(String.valueOf(tanz.charAt(c)), charData[c][0], charData[c][1]);
				}
			}
		};
				
		
		FontMetrics metrics = drawing.getFontMetrics(font);
		
		Rectangle2D bounds = metrics.getStringBounds(tanz, drawing.getGraphics());
		fontHeight = (int)bounds.getHeight();
		fontAscent = metrics.getDescent();
		int x = (int) bounds.getWidth() * 2 - (int)(bounds.getWidth() * 1.75);
		int y = (int) bounds.getHeight() * 2 + (int) bounds.getHeight() / 4;
		Random randomizeY = new Random(System.currentTimeMillis());
		for(int c = 0, max = tanz.length(); c < max; c++) {
			charData[c][0] = x ;
			charData[c][1] = randomizeY.nextInt(y) + fontHeight;
			charData[c][2] = (randomizeY.nextInt(2)-1 == 0) ? 1 : -1;
			randomizeY.setSeed(randomizeY.nextLong());
			x += metrics.charWidth(tanz.charAt(c))+ randomizeY.nextInt(20);
		}
		
		drawing.setPreferredSize( new Dimension((int)bounds.getWidth()*2,(int) bounds.getHeight()*4));
		add(drawing);
		pack();
		setResizable(false);
		setVisible(true);
		
	}
	
	@Override
	public void run() {
		int min = fontHeight ;
		int max = getComponent(0).getHeight()- fontAscent;
		while(isVisible()) {
			try {
				Thread.sleep(17);
			} catch (InterruptedException except) {
				except.printStackTrace();
			}
		
			for(int c = 0, maxChar = charData.length; c < maxChar; c++){
				charData[c][1] += charData[c][2];
				if(charData[c][1] >= max || charData[c][1] <= min){
					charData[c][2] = ~(charData[c][2] - 1);
					colData[c] = new Color( new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
				}
			}
			getComponent(0).repaint();
		}
	}

	public static void main(String[] args) {
		TanzendeSchrift schrift = new TanzendeSchrift();
		Thread tanz = new Thread(schrift);
		tanz.start();
	}

}

