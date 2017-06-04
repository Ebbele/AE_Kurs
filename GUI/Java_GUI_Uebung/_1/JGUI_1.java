package _1;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class JGUI_1 {
	public JFrame frame = null;
	
	public JGUI_1(String winTitle, Dimension d){
		this.frame = newWindow(winTitle, d);
		//this.frame.setVisible(true);
	}
	
	public JFrame newWindow(String winTitle, Dimension d){
		JFrame frame = new JFrame(winTitle);
		frame.setSize(d);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		return frame;
	}
	
	public void showFrame(){
		frame.pack();
		frame.setVisible(true);
	}
}
