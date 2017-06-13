import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

class First2DDemo extends JFrame
{
  public void paint( Graphics g )
  {
    super.paint( g );

    Graphics2D g2 = (Graphics2D) g;

    g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON);

    g2.draw( new Line2D.Double( 10, 40, getWidth()-10, 70 ) );
  }

  public static void main( String args[] )
  {
    JFrame f = new First2DDemo();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.setSize( 200, 100 );
    f.setVisible( true );
  }
}

