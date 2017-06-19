package ThreadRunnable.Ampel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AmpelGui extends JFrame implements Runnable {

	JPanel ampel;
	Ampelphasen phase;

	public AmpelGui() {
		setTitle("Ampel");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension size = new Dimension(280, 400);
		setPreferredSize(size);
		setSize(size);
		setResizable(false);
		ampel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.fillRect(45, 37, 180, 305);
				
				g.setColor(Color.WHITE);
				g.fillOval(90, 45, 90, 90);
				g.fillOval(90, 145, 90, 90);
				g.fillOval(90, 245, 90, 90);
				
				// Draw Colors

				switch (phase) {
				case RED:
					g.setColor(Color.RED);
					g.fillOval(95, 50, 80, 80);
					break;
				case YELLOW:
					g.setColor(Color.YELLOW);
					g.fillOval(95, 150, 80, 80);
					break;
				case GREEN:
					g.setColor(Color.GREEN);
					g.fillOval(95, 250, 80, 80);
					break;
				case RED_YELLOW:
					g.setColor(Color.red);
					g.fillOval(95, 50, 80, 80);
					g.setColor(Color.YELLOW);
					g.fillOval(95, 150, 80, 80);
					break;
				default:
					break;
				}
			}
		};

		add(ampel);
		setVisible(true);

		phase = Ampelphasen.NONE;
		
		Thread tAmpel = new Thread(this);
		tAmpel.start();
	}

	@Override
	public void run() {

		while (isVisible()) {
			try {
				Thread.sleep(phase.duration);
			} catch (InterruptedException except) {
				// TODO Auto-generated catch block
				except.printStackTrace();
			}
			phase = phase.getNextPhase();
			ampel.repaint();
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AmpelGui gui = new AmpelGui();
	}

}
