package utils;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.*;

public class Kalender {
	
	public static void main( String[ ] args ) {
		
		ZonedDateTime zdt = ZonedDateTime.of
				( Integer.parseInt( args[ 1 ] ), Integer.parseInt( args[ 0 ] ), 1, 0, 0, 0, 0, ZoneId.of( "Europe/Berlin" ) );
		
		WeekFields week = WeekFields.of( Locale.getDefault( ) );
		
		int weekNumber = zdt.get(week.weekOfWeekBasedYear());
		
		LocalDate lastDayOfMonth = LocalDate.of
				( Integer.parseInt( args[ 1 ] ), Integer.parseInt( args[ 0 ] ), 1).with( TemporalAdjusters.lastDayOfMonth( ) );
		
		LocalDate firstDayOfMonth = LocalDate.of
				( Integer.parseInt( args[ 1 ] ), Integer.parseInt( args[ 0 ] ), 1).with( TemporalAdjusters.firstDayOfMonth( ) );
		
		String monat = firstDayOfMonth.getDayOfWeek( ).toString( );
		
		int counter = 0;
		String tabulator = "";

		switch ( monat ) {
		
        case "MONDAY": 
        	
        	tabulator = "\t";
        	break;
                 
        case "TUESDAY":  
        	
        	tabulator = "\t\t";     
        	break;
                 
        case "WEDNESDAY":  
        	
        	tabulator = "\t\t\t";     
        	break;
        	
        case "THURSDAY": 
        	
        	tabulator = "\t\t\t\t";
            break;
            
        case "FRIDAY":
        	
        	tabulator = "\t\t\t\t\t";
            break;
            
        case "SATURDAY":
        	
        	tabulator = "\t\t\t\t\t\t";
            break;
            
        case "SUNDAY":
        	
        	tabulator = "\t\t\t\t\t\t\t";
            break;
            
        default:
        	
        	break;
    	}
		
    	System.out.println( "Kalender für " + zdt.getMonth( ) + " " + zdt.getYear( ) );
		System.out.println( "Wo\tMo\tDi\tMi\tDo\tFr\tSa\tSo" );
		System.out.print( ( weekNumber + counter ) + tabulator );
		
		while( !firstDayOfMonth.equals(lastDayOfMonth ) ) {
			
			System.out.print( firstDayOfMonth.getDayOfMonth( ) + "\t" );
			firstDayOfMonth = firstDayOfMonth.plusDays( 1 );
			
			if ( firstDayOfMonth.getDayOfWeek( ).toString( ).equals( "MONDAY" ) ) {
				System.out.print( System.lineSeparator( ) );		
				System.out.print( weekNumber + ++counter + "\t" );
			}
		}
	}
}
