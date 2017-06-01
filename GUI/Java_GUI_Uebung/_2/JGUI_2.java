package _2;

import java.awt.Dimension;
import java.awt.Toolkit;

import _1.JGUI_1;

public class JGUI_2 extends JGUI_1{

	public JGUI_2(String winTitle, Dimension d) {
		super(winTitle, d);
	}
	
	public void centerWindow(){
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX =(int)(((int)screenDim.width * 0.5) - (frame.getWidth() *0.5));
		int centerY =(int)(((int)screenDim.height * 0.5) - (frame.getHeight()*0.5));
		frame.setLocation( centerX, centerY);
	}
}
