package SwingUndEvents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Buecherverwaltung implements ActionListener, Serializable {
	
	private JFileChooser fc;
	private File file;
	
	private JFrame frame;
	private Container contentPane;
	
	private JLabel lblAuthor;
	private JLabel lblTitle;
	private JLabel lblYear;
	private JLabel lblPublisher;
	private JLabel lblSort;
	
	private JTextField txtAuthor;
	private JTextField txtTitle;
	private JTextField txtYear;
	private JTextField txtPublisher;
	
	private JButton btnSave;
	private JButton btnSortByAuthor;
	private JButton btnSortByTitle;
	private JButton btnSortByYear;
	private JButton btnSortByPublisher;	
	
	private static final long serialVersionUID = 1L;
	private List< Book > books;
	private ObjectInputStream ois;
	private FileInputStream fis;
	private String buffer;
	
	Buecherverwaltung( ) {

		buildFrame( );
	}
	
	class Book implements Serializable {

		private static final long serialVersionUID = 1L;
		private String author;
		private String title;
		private String year;
		private String publisher;	
		
		Book ( String author, String title, String year, String publisher ) {
			
			setAuthor( author );
			setTitle( title );
			setYear( year );
			setPublisher( publisher );
		}
		
		public String getAuthor( ) {
			
			return author;
		}
		public void setAuthor( String author ) {
			
			this.author = author;
		}
		public String getTitle( ) {
			
			return title;
		}
		public void setTitle( String title ) {
			
			this.title = title;
		}
		public String getYear( ) {
			
			return year;
		}
		public void setYear( String year ) {
			
			this.year = year;
		}
		public String getPublisher( ) {
			
			return publisher;
		}
		public void setPublisher( String publisher ) {
			
			this.publisher = publisher;
		}

		
	}
	
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
	
	public void buildFrame( ) {
		
		frame = new JFrame( );
		frame.setTitle( "Buecherverwaltung" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
		contentPane = frame.getContentPane( );
		GridBagLayout gbl = new GridBagLayout( );
		contentPane.setLayout( gbl );
		
		lblAuthor = new JLabel( "Author:      " );
		lblAuthor.setHorizontalAlignment(JLabel.RIGHT);		
		txtAuthor = new JTextField( );
		
		
		lblTitle = new JLabel( "Titel:       " );
		lblTitle.setHorizontalAlignment( JLabel.RIGHT );	
		txtTitle = new JTextField( );
		
		lblYear = new JLabel( "Jahr:      " );
		lblYear.setHorizontalAlignment( JLabel.RIGHT );	
		txtYear = new JTextField( );
		
		lblPublisher = new JLabel( "Verlag:      " );
		lblPublisher.setHorizontalAlignment( JLabel.RIGHT );	
		txtPublisher = new JTextField( );
		
		btnSave = new JButton( "Eintrag speichern" );
		btnSave.addActionListener( this );
		
		lblSort= new JLabel( "Ausgabe sortiert nach:" );
		
		btnSortByAuthor = new JButton( "Autor" );
		btnSortByAuthor.addActionListener( this );
		
		btnSortByTitle = new JButton( "Titel" );
		btnSortByTitle.addActionListener( this );
		
		btnSortByYear = new JButton( "Jahr" );
		btnSortByYear.addActionListener( this );
		
		btnSortByPublisher = new JButton( "Verlag" );
		btnSortByPublisher.addActionListener( this );
		
												//			x  y  w  h  wx wy
		addComponent( contentPane, gbl, lblAuthor, 			0, 0, 1, 1, 1, 0);
		addComponent( contentPane, gbl, txtAuthor, 			1, 0, 4, 1, 1, 0);
		addComponent( contentPane, gbl, lblTitle, 			0, 1, 1, 1, 1, 0);
		addComponent( contentPane, gbl, txtTitle, 			1, 1, 4, 1, 1, 0);
		addComponent( contentPane, gbl, lblYear, 			0, 2, 1, 1, 1, 0);
		addComponent( contentPane, gbl, txtYear, 			1, 2, 4, 1, 1, 0);
		addComponent( contentPane, gbl, lblPublisher, 		0, 3, 1, 1, 1, 0);
		addComponent( contentPane, gbl, txtPublisher, 		1, 3, 4, 1, 1, 0);
		addComponent( contentPane, gbl, btnSave, 			2, 4, 2, 1, 1, 0);
		addComponent( contentPane, gbl, lblSort, 			0, 5, 1, 1, 1, 0);
		addComponent( contentPane, gbl, btnSortByAuthor, 	1, 5, 1, 1, 1, 0);
		addComponent( contentPane, gbl, btnSortByTitle, 	2, 5, 1, 1, 1, 0);
		addComponent( contentPane, gbl, btnSortByYear, 		3, 5, 1, 1, 1, 0);
		addComponent( contentPane, gbl, btnSortByPublisher, 4, 5, 1, 1, 1, 0);
		
		frame.setSize( 510, 160 );
		frame.setResizable( false );
		frame.setVisible( true );
	}
	
	public void writeInFile( File file ) {
		
		Book book = new Book( txtAuthor.getText( ), txtTitle.getText( ), txtYear.getText( ), txtPublisher.getText( ) ); 
		
		try ( ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( file, true ) ) )  {
			
			oos.writeObject( book );			
		} catch ( NotSerializableException e ) {
			
			System.err.println( e );
		} catch ( IOException e ) {
			
			System.err.println( e.toString( ) );
		} 
	}
	
	public List< Book > readOutOfFile( File file ) {
		 
		books = new ArrayList< Book >( );
	
		try {
			fis = new FileInputStream( file );
			
		} catch ( IOException e ) {
			
			System.err.println( e.toString( ) );
		}
		
		while(true){
			
			try {
				ois = new ObjectInputStream( fis );  
				books.add( (Book) ois.readObject( ) );
			} catch ( EOFException e ) {
				
				break; // EOF - break out of Loop
			}   catch ( ClassNotFoundException e ) {
			
				System.err.println( e.toString( ) );
			} catch ( IOException e ) {
				
				System.err.println( e.toString( ) );
			} 
		}
		try {
			
			ois.close( );
		} catch ( IOException e ) {
			
			System.err.println( e.toString( ) );
		} 
		return books;
	}
	
	public File selectFile( ) {
		
		
		fc = new JFileChooser( );
		int option = fc.showOpenDialog( null );
				
		if ( option == JFileChooser.APPROVE_OPTION ) { 
					
			file = fc.getSelectedFile( );
					
		} else {
					
			System.out.println( "Auswahl abgebrochen" );
			System.exit( 0 );
		}
		return file;
	}
	
	public void sortBy( List< Book > bookSort, String sortWhat ) {
		
		Book bookOut;
		Iterator< Book > bookIter;
		buffer = "";
		
		switch (sortWhat) {
		
		case "author":
			
			bookSort.sort( ( object1, object2) -> object1.getAuthor( ).compareTo( object2.getAuthor( ) ) );
			bookIter = bookSort.iterator( );
			while ( bookIter.hasNext( ) ) {

				bookOut = bookIter.next( );
				buffer += bookOut.getAuthor( ) + " " + bookOut.getTitle( ) + " " +  bookOut.getYear( ) + " " +  bookOut.getPublisher( ) + "\n";
			}
			JOptionPane.showMessageDialog( null, buffer );
			buffer = "";
			break;
		case "title":
			
			bookSort.sort( ( object1, object2) -> object1.getTitle( ).compareTo( object2.getTitle( ) ) );
			bookIter = bookSort.iterator( );
			while ( bookIter.hasNext( ) ) {

				bookOut = bookIter.next( );
				buffer += bookOut.getTitle( ) + " " + bookOut.getAuthor( ) + " " +  bookOut.getYear( ) + " " +  bookOut.getPublisher( ) + "\n";
			}
			JOptionPane.showMessageDialog( null, buffer );
			buffer = "";
			break;
		case "year":
			
			bookSort.sort( ( object1, object2) -> object1.getYear( ).compareTo( object2.getYear( ) ) );
			bookIter = bookSort.iterator( );
			while ( bookIter.hasNext( ) ) {

				bookOut = bookIter.next( );
				buffer += bookOut.getYear( ) + " " + bookOut.getAuthor( ) + " " +  bookOut.getTitle( ) + " " +  bookOut.getPublisher( ) + "\n";
			}
			JOptionPane.showMessageDialog( null, buffer );
			buffer = "";
			break;
		case "publisher":
			
			bookSort.sort( ( object1, object2) -> object1.getPublisher( ).compareTo( object2.getPublisher( ) ) );
			bookIter = bookSort.iterator( );
			while ( bookIter.hasNext( ) ) {

				bookOut = bookIter.next( );
				buffer += bookOut.getPublisher( ) + " " + bookOut.getAuthor( ) + " " +  bookOut.getYear( ) + " " +  bookOut.getAuthor( ) + "\n";
			}
			JOptionPane.showMessageDialog( null, buffer );
			buffer = "";
			break;
		default:
			
			System.out.println( "Fehler beim Sortieren." );
		}
	}

	@Override
	public void actionPerformed( ActionEvent evt ) {
		
		if ( evt.getActionCommand( ).equals( "Eintrag speichern" ) ) {
			
			file = selectFile( );
			writeInFile( file );
		}
		if ( evt.getActionCommand( ).equals( "Autor" ) ) {
			
			file = selectFile( );
			sortBy( readOutOfFile( file ), "author");			
		}
		if ( evt.getActionCommand( ).equals( "Titel" ) ) {
			
			file = selectFile( );
			sortBy( readOutOfFile( file ), "title");			
		}
		if ( evt.getActionCommand( ).equals( "Jahr" ) ) {
			
			file = selectFile( );
			sortBy( readOutOfFile( file ), "year");			
		}
		if ( evt.getActionCommand( ).equals( "Verlag" ) ) {
			
			file = selectFile( );
			sortBy( readOutOfFile( file ), "publisher");			
		}
	}
	
	public static void main( String[ ] args) {
			
		new Buecherverwaltung( );
	}
}