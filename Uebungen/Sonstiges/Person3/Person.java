package Person3;

import java.io.Serializable;

import Books.Book;

public class Person implements Serializable
{
	private String name;	
	private String vorName;
	private String gebDat;	
	
	public Person()
	{
		this("Maier", "Klaus", "01.01.1999");		
	}
	
	public Person(String name, String vorname, String gebDat)
	{
		this.setName(name);
		this.setVorName(vorname);
		this.setGebDat(gebDat);
	}		
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getVorName() 
	{
		return vorName;
	}
	
	public void setVorName(String vorName) 
	{
		this.vorName = vorName;
	}
	
	public String getGebDat() 
	{
		return gebDat;
	}
	
	public void setGebDat(String gebDat) 
	{
		this.gebDat = gebDat;
	}	
	
	
	public int hashCode(){
		int hash = getName().hashCode() + getVorName().hashCode() + getGebDat().hashCode();
		return hash;
	}
	
	public boolean equals(Object obj){
		if( null == obj || obj.getClass() != getClass()){
			return false;
		}else{
			Person p = (Person)obj;
			if( p.getName().equals(getName()) && p.getVorName().equals(getVorName()) && p.getGebDat().equals(getGebDat()))
				return true;
		}
		return false;
	}
	
	public String toString()
	{
		return getClass().getSimpleName() + ":\n"
				+ "Name: " + getName() 
				+ "\nVorname: "	+ getVorName() 
				+ "\nGeburtsdatum: " + getGebDat() + "\n";
	}
}