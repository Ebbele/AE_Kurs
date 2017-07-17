package inheritance_polymorphism.Tickets;

public class Kontrolleur {

	public int kontrolliere( String[ ] namen, Ticket[ ] tickets, int zone, String datum ) {
		
		int schwarzFahrer = 0;
		
		if( namen.length != tickets.length ) {
			
			throw new IllegalArgumentException( );
		}
		
		for ( int i = 0; i < tickets.length; i++ ) {
						
			if ( tickets[ i ].getClass( ).getName( ).equals( "inheritance_polymorphism.Generalabo" ) ) {
				
				if ( ( ( Generalabo ) tickets[ i ] ).gibVerfallsDatum( ).compareTo( datum ) < 0 ) {
					
					schwarzFahrer++;
				}
				else if ( !tickets[ i ].gueltigInZone( zone ) ) {
					
					schwarzFahrer++;
				}
				else if ( !( ( Generalabo ) tickets[ i ] ).gibInhaber( ).equals( namen[ i ] ) ) {
					
					schwarzFahrer++;
				}
			}
			
			else if ( tickets[ i ].getClass( ).getName( ).equals( "inheritance_polymorphism.Mehrfahrtenkarte" ) ) {
				
				if( !tickets[ i ].isEntwertet( ) ) {
					
					tickets[ i ].entwerten( );
				}
				if ( !tickets[ i ].gueltigInZone( zone ) ) {
					
					schwarzFahrer++;
				}
			}
			
			else if ( tickets[ i ].getClass( ).getName( ).equals( "inheritance_polymorphism.Einzelticket" ) ) {
				
				if( !tickets[ i ].isEntwertet( ) ) {
					
					tickets[ i ].entwerten( );
				}
				if ( !tickets[ i ].gueltigInZone( zone ) ) {
					
					schwarzFahrer++;
				}
				else if ( ( ( Einzelticket ) tickets[ i ] ).gibVerfallsDatum( ).compareTo( datum ) < 0 ) {
					
					schwarzFahrer++;
				}
			}
		}
		return schwarzFahrer;
	}
}