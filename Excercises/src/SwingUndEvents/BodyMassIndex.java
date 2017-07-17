package SwingUndEvents;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings( "serial" )
public class BodyMassIndex extends JFrame implements ActionListener {
	
	// deklariere GUI - Elemente
	private JFrame frame;
	
	private Container contentPane;
	
	private JLabel weightLabel;
	private JTextField weightInput;
	
	private JLabel sizeLabel;
	private JTextField sizeInput;
	
	private JLabel bmiLabel;
	private JTextField bmiOutput;
		
	private JTextField classificationOutput;
	
	private JRadioButton optionMale;
	private JRadioButton optionFemale;
	
	private JButton btnCalculate;
	
	// zum setzen der "Einschränkungen" für die GUI - Elemente (für die "Schreibfaulen")
	static void addComponent ( 	Container cont, 
								GridBagLayout gbl, 
								Component c, 
								int x, int y, 
								int width, int height, 
								double weightx, double weighty )
	{
		GridBagConstraints gbc = new GridBagConstraints( );
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints( c, gbc );
		cont.add( c );
	}
	
	BodyMassIndex( ) {
		
		// baue den JFrame auf
		frame = new JFrame( );
		setTitle( "Body-Mass-Index" );
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
		// erzeuge das (GridBag-)Layout für den Container (im Frame)
		contentPane = frame.getContentPane( );
		GridBagLayout gbl = new GridBagLayout( );
		contentPane.setLayout( gbl );
		
		// erzeuge Objektreferenzen für die einzelnen GUI - Elemente
		
		weightLabel = new JLabel( "Gewicht in kg:" );
		weightInput = new JTextField( );
		
		sizeLabel = new JLabel( "Groesse in m:" );
		sizeInput = new JTextField( );
		
		optionMale = new JRadioButton( "maennlich" );
		optionFemale = new JRadioButton( "weiblich" );
		
		btnCalculate = new JButton( "berechne" );
		btnCalculate.addActionListener( this );
		
		bmiLabel = new JLabel( "BMI:" );
		bmiOutput = new JTextField( );
			
		classificationOutput = new JTextField( );
		
		// baue die GUI auf über die statische addComponent - Methode auf
		// 														x  y  w  h  wx wy
		addComponent( contentPane, gbl, weightLabel, 			0, 0, 1, 1, 1, 0);
		addComponent( contentPane, gbl, weightInput, 			1, 0, 1, 1, 1, 0);
		addComponent( contentPane, gbl, sizeLabel, 				0, 1, 1, 1, 1, 0);
		addComponent( contentPane, gbl, sizeInput, 				1, 1, 1, 1, 1, 0);
		addComponent( contentPane, gbl, optionMale, 			0, 2, 1, 1, 1, 0);
		addComponent( contentPane, gbl, optionFemale, 			1, 2, 1, 1, 1, 0);
		addComponent( contentPane, gbl, btnCalculate, 			0, 3, 2, 1, 1, 0);
		addComponent( contentPane, gbl, bmiLabel, 				0, 4, 1, 1, 1, 0);
		addComponent( contentPane, gbl, bmiOutput, 				1, 4, 1, 1, 1, 0);
		addComponent( contentPane, gbl, classificationOutput, 	0, 5, 2, 1, 1, 0);
		
		add( contentPane );
		setSize(350, 200);
		setVisible( true );
	}
	
	public static void main( String[ ] args ) {

		new BodyMassIndex( );
	}

	@Override
	public void actionPerformed( ActionEvent evt ) {
		
		String buffer = String.valueOf( Double.parseDouble( weightInput.getText( ) ) / ( Double.parseDouble( sizeInput.getText( ) ) * Double.parseDouble( sizeInput.getText( ) ) ) ); 
		bmiOutput.setText( buffer );
		
		if ( Double.parseDouble( buffer ) < 20.0 && optionMale.isSelected( ) ) {
			
			classificationOutput.setText( "Untergewicht" );
		}
		else if ( Double.parseDouble( buffer ) < 19.0 && optionFemale.isSelected( ) ) {
			
			classificationOutput.setText( "Untergewicht" );
		}
		else if ( Double.parseDouble( buffer ) > 20.0 && Double.parseDouble( buffer ) < 25.0 && optionMale.isSelected( ) ) {
			
			classificationOutput.setText( "Normalgewicht" );
		}
		else if ( Double.parseDouble( buffer ) > 19.0 && Double.parseDouble( buffer ) < 24.0 && optionFemale.isSelected( ) ) {
			
			classificationOutput.setText( "Normalgewicht" );
		}
		else if ( Double.parseDouble( buffer ) > 25.0 && Double.parseDouble( buffer ) < 30.0 && optionMale.isSelected( ) ) {
			
			classificationOutput.setText( "Uebergewicht" );
		}
		else if ( Double.parseDouble( buffer ) > 24.0 && Double.parseDouble( buffer ) < 30.0 && optionFemale.isSelected( ) ) {
			
			classificationOutput.setText( "Uebergewicht" );
		}
		else if ( Double.parseDouble( buffer ) > 30.0 && Double.parseDouble( buffer ) < 40.0 && optionMale.isSelected( ) ) {
			
			classificationOutput.setText( "Adipositas" );
		}
		else if ( Double.parseDouble( buffer ) > 30.0 && Double.parseDouble( buffer ) < 40.0 && optionFemale.isSelected( ) ) {
			
			classificationOutput.setText( "Adipositas" );
		}
		else if ( Double.parseDouble( buffer ) > 40.0 && optionMale.isSelected( ) || optionFemale.isSelected( ) ) {
			
			classificationOutput.setText( "massive Adipositas" );
		}
		else if ( !optionMale.isSelected( ) && !optionFemale.isSelected( ) ) {
			
			classificationOutput.setText( "Bitte Geschlecht auswaehlen" );
		}
	}
}
