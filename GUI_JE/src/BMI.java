import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BMI extends JFrame 
{
	private JPanel contentPane;
	private JTextField txtKg;
	private JTextField txtGroesse;
	private JTextField txtBMI;
	private JTextField txtAus;
	
	public static void main(String[] args) 
	{
		BMI frame = new BMI();
		frame.setVisible(true);		
	}
	
	public BMI() 
	{
		setTitle("Body-Mass-Index");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 216, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGewichtInKg = new JLabel("Gewicht in kg:");
		lblGewichtInKg.setBounds(10, 11, 90, 14);
		contentPane.add(lblGewichtInKg);
		
		txtKg = new JTextField();
		txtKg.setBounds(110, 8, 86, 20);
		contentPane.add(txtKg);
		txtKg.setColumns(10);
		
		JLabel lblGreInM = new JLabel("Gr\u00F6\u00DFe in m:");
		lblGreInM.setBounds(10, 52, 90, 14);
		contentPane.add(lblGreInM);
		
		txtGroesse = new JTextField();
		txtGroesse.setColumns(10);
		txtGroesse.setBounds(110, 49, 86, 20);
		contentPane.add(txtGroesse);
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton rdbtnM = new JRadioButton("m\u00E4nnlich");
		rdbtnM.setBounds(10, 76, 90, 23);
		bg.add(rdbtnM);
		contentPane.add(rdbtnM);
		
		JRadioButton rdbtnW = new JRadioButton("weiblich");
		rdbtnW.setBounds(120, 76, 76, 23);
		bg.add(rdbtnW);
		contentPane.add(rdbtnW);
		
		JButton btnNewButton = new JButton("berechne");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				double kg = Double.parseDouble(txtKg.getText());
				double groesse = Double.parseDouble(txtGroesse.getText());
				txtBMI.setText(String.valueOf(kg / (Math.pow(groesse, 2))));				
				txtAus.setText(auswahl(rdbtnM.isSelected(), txtBMI.getText()));
			}
		});
		btnNewButton.setBounds(64, 103, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblBmi = new JLabel("BMI:");
		lblBmi.setBounds(10, 140, 38, 14);
		contentPane.add(lblBmi);
		
		txtBMI = new JTextField();
		txtBMI.setBounds(58, 137, 138, 20);
		contentPane.add(txtBMI);
		txtBMI.setColumns(10);
		
		txtAus = new JTextField();
		txtAus.setBounds(10, 168, 186, 20);
		contentPane.add(txtAus);
		txtAus.setColumns(10);
	}
	
	String auswahl(boolean m, String bmi)
	{		
		String erg = "";
		Double bmiD = Double.parseDouble(bmi);
		
		if(m)
		{
			if(bmiD < 20)
			{
				erg = "Untergewicht";
			}
			else
			{
				if(bmiD < 25)
				{
					erg = "Normalgewicht";
				}
				else
				{
					if(bmiD < 30)
					{
						erg = "Übergewicht";
					}
					else
					{
						if(bmiD < 40)
						{
							erg = "Adipositas";
						}
						else
						{
							erg = "massive Adipositas";
						}
					}
				}
			}
		}
		else
		{
			if(bmiD < 19)
			{
				erg = "Untergewicht";
			}
			else
			{
				if(bmiD < 24)
				{
					erg = "Normalgewicht";
				}
				else
				{
					if(bmiD < 30)
					{
						erg = "Übergewicht";
					}
					else
					{
						if(bmiD < 40)
						{
							erg = "Adipositas";
						}
						else
						{
							erg = "massive Adipositas";
						}
					}
				}
			}
		}
		return erg;
	}
}
