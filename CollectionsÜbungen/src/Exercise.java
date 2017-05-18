import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise {
	
	Book[]booksArray =new Book[6] ;
	ArrayList<Book>booksList=new ArrayList<Book>(Arrays.asList(booksArray));
	
	
	public Exercise(String[] args){
		this.args=args;
		
		Book b1=new Book("Arsch","Geigen","Style" );
		Book b2=new Book("Arsch1","Geigen1","Style1" );
		Book b3=new Book("Arsch2","Geigen2","Style2" );
		Book b4=new Book("Arsch3","Geigen3","Style3" );
		Book b5=new Book("Arsch4","Geigen4","Style4" );
		Book b6=new Book("Arsch5","Geigen5","Style5" );
		
		booksArray[0]=b1;
		booksArray[1]=b2;
		booksArray[2]=b3;
		booksArray[3]=b4;
		booksArray[4]=b5;
		booksArray[5]=b6;
		
		if(args[1].equals("6")){
			part6();
		}
		else if(args[1].equals("7")){
			part7();
		}
		else if(args[1].equals("8")){
			part8();
		}
	}
	
	public static void sortList(Book booksList){
		
		Collections.sort(booksList);
	}

	
	public void part6(){
		
	}
	public void part7(){
		
	}
	public void part8(){
		
	}
	
	public static void main(String[]args)
	{
		
	}
}
