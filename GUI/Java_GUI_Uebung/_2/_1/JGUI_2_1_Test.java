package _2._1;

import java.awt.Dimension;

public class JGUI_2_1_Test {

	public static void main(String[] args) throws InterruptedException {
		JGUI_2_1 window = new JGUI_2_1("Übung 2.1", new Dimension(0, 0));
		window.drawArea(true, 100, 100);
		window.showFrame();
		window.centerWindow();
	}
}
