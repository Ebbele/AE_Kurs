package uebungen_07_06_2017._20_Swing_ErsteAufgaben;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class SwingGrundkomponenten extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public SwingGrundkomponenten(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Einige Grundkomponenten");
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("JLabel");
		panel.add(label);
		
		JTextField txtField = new JTextField("JTextField");
		panel.add(txtField);
		
		JPasswordField passField = new JPasswordField("JPasswordField");
		panel.add(passField);
		
		JButton btn = new JButton("JButton");
		btn.setToolTipText("<html><body>Diese ist ein Tool Tip zum <em>JButton</em></body></html>");
		panel.add(btn);
		
		JToggleButton tglBtn = new JToggleButton("JToggleButton");
		panel.add(tglBtn);
		
		JCheckBox chkBx = new JCheckBox("JCheckBox");
		panel.add(chkBx);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("JComboBox 1");
		comboBox.addItem("JComboBox 2");
		comboBox.addItem("JComboBox 3");
		
		panel.add(comboBox);
		
		JRadioButton radio1 = new JRadioButton("Radio-Button-1");
		JRadioButton radio2 = new JRadioButton("Radio-Button-2");
		JRadioButton radio3 = new JRadioButton("Radio-Button-3");
		
		panel.add(radio1);
		panel.add(radio2);
		panel.add(radio3);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(radio1);
		btnGroup.add(radio2);
		btnGroup.add(radio3);
		
		radio2.setSelected(true);
		
		add(panel);
		pack();
		setVisible(true);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		SwingGrundkomponenten components = new SwingGrundkomponenten();
	}

}
