package schwarzeAuge;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // Unser Wurzelelement f�r unsere XML-Dateien, ben�tigt f�r die Erstellung des Objektgraphen
public class Item {
	
  private List< Ruestung > ruestung = new ArrayList< Ruestung >( ); // Item 'kennt' alle Itemkategorien(ruestung, waffen, schilde)
  private List< Waffen > waffen = new ArrayList< Waffen >( );		// k�nnte als Schnittstelle fungieren f�r die anderen 'Teams' bzw. unser Inventarsystem
  private List< Schilde > schilde = new ArrayList< Schilde >( );	// eine neue Klasse mit den ensprechenden methoden w�rde sich da anbieten

  @XmlElement( name = "Ruestung" ) // Untergeordnetes XML-Element, ben�tigt f�r die Erstellung des Objektgraphen
  public List<Ruestung> getRuestung( ) {
    return ruestung;
  }

  public void setRuestung( List< Ruestung > ruestung ) {
    this.ruestung = ruestung;
  }
  
  @XmlElement( name = "Waffen" ) // Untergeordnetes XML-Element, ben�tigt f�r die Erstellung des Objektgraphen
  public List< Waffen > getWaffen( ) {
    return waffen;
  }

  public void setWaffe( List< Waffen > waffen ) {
    this.waffen = waffen;
  }
  
  @XmlElement( name = "Schilde" ) // Untergeordnetes XML-Element, ben�tigt f�r die Erstellung des Objektgraphen
  public List< Schilde > getSchilde( ) {
    return schilde;
  }

  public void setSchilde( List< Schilde > schilde ) {
    this.schilde = schilde;
  }
}
