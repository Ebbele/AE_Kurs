package _3._1;

import java.awt.Dimension;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import _1.JGUI_1;

public class JGUI_3_1_Test {

	public static void main(String[] args) throws InterruptedException {
		JGUI_1 window = new JGUI_1("Übung 3.1", new Dimension(100,100));
		window.showFrame();
		window.frame.setResizable(false);
		window.frame.setLocationRelativeTo(null);
		
		JGUI_3_1 drawing = new JGUI_3_1(window.frame, new Dimension(100,100));
		drawing.panel.repaint();
		Thread.sleep(3000);
		List<Polygon> polies = new ArrayList<Polygon>(4);
		/*
		 * Dimensions Panel
		 * width 	124
		 * height 	100
		 */
		// Rectangle
		polies.add(new Polygon( new int[]{20,20,104,104}, new int[]{25,75,75,25},4));
		
		// Triangle
		polies.add(new Polygon(new int[]{20,62,104}, new int[]{80,20,80},3));
		Iterator<Polygon> iter = polies.iterator();
		while(iter.hasNext()){
			Polygon current = iter.next();
			drawing.setPoly(current);
			drawing.panel.repaint();
			Thread.sleep(3000);
		}
		
	}

}
