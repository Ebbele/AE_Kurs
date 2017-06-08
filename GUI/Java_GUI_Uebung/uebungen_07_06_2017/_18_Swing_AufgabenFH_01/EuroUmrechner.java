package uebungen_07_06_2017._18_Swing_AufgabenFH_01;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class ButtonActions implements ActionListener {
	double factor;
	JTextField entry;

	public ButtonActions(Double factor, JTextField entry) {
		this.factor = factor;
		this.entry = entry;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((entry.getText().isEmpty() || !EuroUmrechner.isDecimal(entry.getText()))
				&& !e.getActionCommand().equals("cancel")) {
			entry.setText("Fehlerhafte Eingabe ! Dezimal Trenner ist \".\"");
		} else {
			switch (e.getActionCommand()) {
			case "multiply":
				entry.setText(String.valueOf(Double.parseDouble(entry.getText()) * factor));
				break;
			case "divide":
				entry.setText(String.valueOf(Double.parseDouble(entry.getText()) / factor));
				break;
			default:
				((JFrame)entry.getTopLevelAncestor()).dispose();
			}
		}
	};

}

public class EuroUmrechner {
	final static JFrame window = new JFrame();
	final static double factor = 1.95583;

	static {
		window.setTitle("Euro Umrechner");
		window.setLayout(new BorderLayout(8, 8));

		JTextField eingabe = new JTextField();

		ButtonActions btnAction = new ButtonActions(factor, eingabe);

		JButton eurToDm = new JButton("EUR -> DM");
		JButton dmToEur = new JButton("DM -> EUR");
		JButton cancel = new JButton("Abbrechen");

		eurToDm.setActionCommand("multiply");
		eurToDm.addActionListener(btnAction);

		dmToEur.setActionCommand("divide");
		dmToEur.addActionListener(btnAction);

		cancel.setActionCommand("cancel");
		cancel.addActionListener(btnAction);

		window.add(eingabe, BorderLayout.NORTH);
		window.add(eurToDm, BorderLayout.LINE_START);
		window.add(dmToEur, BorderLayout.CENTER);
		window.add(cancel, BorderLayout.LINE_END);
		window.pack();
	}

	public static boolean isDecimal(String str) {
		boolean decimal = true;
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException e) {
			decimal = false;
		}

		return decimal;
	}

	public static void showWindow() {
		window.setVisible(true);
	}

}
