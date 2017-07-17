package ReaderWriterexercises;

import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;

public class MyFilterWriter extends FilterWriter {

		public MyFilterWriter( FileWriter fw ) {
			
			super( fw );
		}
		
		@Override
		public void write( int position ) throws IOException {
			
			if( position <= 47 )
				{position = 42;}
			else if( position >= 58 && position <= 64 )
				 {position = 42;}
			else if( position >= 91 && position <= 96 )
				{position = 42;}
			else if( position >= 123 )
				{position = 42;}
			
			super.write( position );
		}
		
		@Override
		public void write ( char[ ] characterbuffer, int start, int laenge ) throws IOException {
			
			for ( int i = 0; i < laenge; ++i ) {
				write( characterbuffer[ start + i ] );
			}
		}
		
		@Override
		public void write( String s, int start, int laenge ) throws IOException {
			
			write( s.toCharArray( ), start, laenge );			
		}		
}
