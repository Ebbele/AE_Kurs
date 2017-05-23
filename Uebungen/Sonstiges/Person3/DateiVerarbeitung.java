package Person3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

@SuppressWarnings("serial")
public class DateiVerarbeitung implements Serializable {
	private final String datenDatei = "daten.dat";
	private HashMap<String, Person> daten;

	public DateiVerarbeitung() {
		if(!openFile()){
			daten = new HashMap<String, Person>();
			saveFile();
		}
	}

	@SuppressWarnings("unchecked")
	private boolean openFile() {
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(datenDatei))) {
			daten = (HashMap<String, Person>) is.readObject();
			return true;
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Daten Datei nicht gefunden ! Neu erstellt");
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
		
	public void saveFile(){
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(datenDatei))){
			os.writeObject(daten);
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public Person getData(String name){
		return daten.get(name);
	}
	
	public void datenInDatei(Person p) {
		daten.put(p.getName(),p);
	}
}
