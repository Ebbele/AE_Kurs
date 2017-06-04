package _2._2;

import java.awt.Dimension;

import javax.swing.JOptionPane;

public class JGUI_2_2_Test {

	public static void main(String[] args) {
		JGUI_2_2 window = new JGUI_2_2("Übung 2.2", new Dimension(100,100));
		Dimension sizes = new Dimension(100,100);
		window.filledCircle(window.frame, sizes);
		window.showFrame();
		window.centerWindow();
		JOptionPane.showMessageDialog(window.frame, "Mit Klick auf \"OK\" wird ein farbliches Quadrat angezeigt");
		window.btnClicked = true;
		window.filledCircle(window.frame, sizes);
		window.frame.repaint(0);
	}

}
