import java.awt.*;
import java.awt.event.*;

public class Biene extends Frame
{
  public Biene()
  {
    setSize( 500, 100 );
    
    addWindowListener( new WindowAdapter() {
          public void windowClosing ( WindowEvent e ) { System.exit(0); }
        });
  }
  
  public void paint( Graphics g )
  {
    g.drawString( "\"Maja, wo bist du?\" (Willy)", 120, 60 );
  }
  
  public static void main( String args[] )
  {
    new Biene().setVisible( true );
  }
}
