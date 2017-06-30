package Candy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Spielfeld {

	public void FeldGenerieren(int felder) {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		Container container = new Container();
		container = frame.getContentPane();
		container.setLayout(new GridLayout(felder,felder));
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("click");
				
				System.out.println(e.getSource());
				
				
			}
		};
		
		for (int i=1;i<=felder;i++) {
			for (int j=1;j<=felder;j++) {
				//System.out.println(i+" "+j);
				int zahl = (int)((Math.random()) * 7+1);
				System.out.println(zahl);

				JButton a1 = new JButton();
				a1.addActionListener(al);
				switch (zahl) {
				case 1: a1.setBackground(Color.red); break;
				case 2: a1.setBackground(Color.green); break;
				case 3: a1.setBackground(Color.yellow); break;
				case 4: a1.setBackground(Color.blue); break;
				case 5: a1.setBackground(Color.white); break;
				case 6: a1.setBackground(Color.orange); break;
				case 7: a1.setBackground(Color.magenta); break;
				
				}
				a1.setPreferredSize(new Dimension (60,60));
				a1.setOpaque(true);
				a1.setBorderPainted(false);
				
				container.add(a1);
			}
			
			
			
			
		}
		
		/*
		JButton a1 = new JButton();
		a1.setBackground(Color.red);
		a1.setOpaque(true);
		a1.setBorderPainted(false);
		a1.setSize(50, 50);
		container.add(a1);
		
		JButton a2 = new JButton();
		a2.setBackground(Color.green);
		a2.setOpaque(true);
		a2.setBorderPainted(false);
		a2.setSize(50, 50);
		container.add(a2);
		*/
		
		//frame.setSize(felder*60, felder*60);
		frame.pack();
		frame.setVisible(true);
	}
	
}
