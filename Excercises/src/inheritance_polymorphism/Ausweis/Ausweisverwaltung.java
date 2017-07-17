package inheritance_polymorphism.Ausweis;

public class Ausweisverwaltung {

	private Ausweis[ ] ausweise;

	public Ausweisverwaltung() {

		ausweise = new Ausweis[ 100 ];
		for ( int i = 0; i < 25; i++ ) {
			String j = String.valueOf( i );
			ausweise[ i ] = new Identitaetskarte( i, j, j, i, j );
			ausweise[ i + 25 ] = new Pass( i, j, j, i, j, j );
			ausweise[ i + 50 ] = new Fahrausweis( i, j, j, j );
			// ausweise[ i + 75 ] = new Ausweis( i, j, j );
		}
		
		System.out.println( "Total Ausweise: " + countAusweise( ausweise ) );
		int [ ] countResult = countAusweisTyp( ausweise );
		System.out.println( "ID - Karten: " + countResult[ 0 ] 
							+ ", Paesse: " + countResult[ 1 ]
							+ ", Fahrausweise: " + countResult[ 2 ] );
		printPaesse( ausweise );
	}

	public int countAusweise( Ausweis[ ] ausweise ) {

		int counter = 0;
		for ( int i = 0; i < ausweise.length; i ++ ) {
			if ( ausweise[ i ] != null ) {
				
				counter++;
			}
		}
		return counter;
	}

	public int[] countAusweisTyp( Ausweis[ ] ausweise ) {

		int[] counter = { 0, 0, 0 };

		for ( int i = 0; i < ausweise.length; i++ ) {

			if ( ausweise[ i ] instanceof Pass && ausweise[ i ] != null ) {

				counter[ 1 ]++;
			}
			else if ( ausweise[ i ] instanceof Identitaetskarte && ausweise[ i ] != null ) {

				counter[ 0 ]++;
			}
			if ( ausweise[ i ] instanceof Fahrausweis && ausweise[ i ] != null ) {

				counter[ 2 ]++;
			}
		}
		return counter;
	}

	public void printPaesse( Ausweis[ ] ausweise ) {
		
		for ( int i = 0; i < ausweise.length; i++ ) {
			
			if ( ausweise[ i ] instanceof Identitaetskarte ) {

				System.out.println( ausweise[ i ].getNummer( ) + ", " + ausweise[ i ].getInhaber( ) + ", " + ausweise[ i ].getAblaufDatum( )
									+ ", " + ( ( Identitaetskarte ) ausweise[ i ] ).getGroesse( ) + ", " 
									+ ( (Identitaetskarte ) ausweise[ i ] ).getBuergerort( ) );
			}
			
			else if ( ausweise[ i ] instanceof Fahrausweis ) {
				
				System.out.println( ausweise[ i ].getNummer( ) + ", " + ausweise[ i ].getInhaber( ) + ", " + ausweise[ i ].getAblaufDatum( )
						+ ", " + ( ( Fahrausweis ) ausweise[ i ] ).getKategorien( ) );
			}
			
			if ( ausweise[ i ] instanceof Pass ) {
				
				System.out.println( ausweise[ i ].getNummer( ) + ", " + ausweise[ i ].getInhaber( ) + ", " + ausweise[ i ].getAblaufDatum( )
						+ ", " + ( ( Pass ) ausweise[ i ] ).getFingerabdruck( ) );
			}
		}
	}

	public static void main( String[ ] args ) {

		new Ausweisverwaltung( );
	}
}