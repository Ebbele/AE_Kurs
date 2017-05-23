package Person3;

import java.util.*;

public class PersonMethoden {
	Person pers = null;
	ArrayList<Person> persList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public DateiVerarbeitung daten;

	public PersonMethoden(DateiVerarbeitung daten) {
		this.daten = daten;
	}

	public void ausgabe() {
		for (Person persObj : persList) {
			System.out.println(persObj);
		}
	}

	public void hinzufuegen() {
		persList.add(pers);
		daten.datenInDatei(pers);
	}

	public String[] eingabe() {
		String[] persDat = new String[3];

		System.out.println("Bitte geben Sie den Nachnamen ein: ");
		persDat[0] = sc.nextLine();
		System.out.println("Bitte geben Sie den Vornamen ein: ");
		persDat[1] = sc.nextLine();
		System.out.println("Bitte geben Sie das Geburtsdatum ein: ");
		persDat[2] = sc.nextLine();

		return persDat;
	}

	public void suche() {
		String suchE = "";
		boolean gefunden = false;

		System.out.println("Bitte geben Sie den Nachnamen der zu suchenden Person ein: ");
		suchE = sc.nextLine();
		/*
		for (int i = 0; i < persList.size(); i++) {
			if (persList.get(i).getName().equals(suchE)) {
				gefunden = true;
				pers = persList.get(i);
			}
		}
		*/
		pers = daten.getData(suchE);
		persList.add(pers);
		if ( null == pers){//!gefunden) {
			System.out.println("Die gesuchte Person konnte nicht gefunden werden!");
		} else {
			System.out.println("Die gesuchte Person konnte gefunden werden!");
		}
	}

	public void loeschen() {
		persList.remove(pers);
	}

	public void aendern() {
		System.out.println("Die folgende Person wurde zur Änderung ausgewählt:\n" + pers + "\n");

		System.out.println("Was möchten Sie ändern? ");
		System.out.println("1. Nachname ");
		System.out.println("2. Vorname ");
		System.out.println("3. Geburtsdatum");

		switch (sc.nextInt()) {
		case 1:
			sc.nextLine();
			System.out.println("Bitte ändern Sie den Nachnamen: ");
			pers.setName(sc.nextLine());
			System.out.println("Name wurde auf " + pers.getName() + " geändert.\n");
			break;
		case 2:
			sc.nextLine();
			System.out.println("Bitte ändern Sie den Vornamen: ");
			pers.setVorName(sc.nextLine());
			System.out.println("Vorname wurde auf " + pers.getVorName() + " geändert.\n");
			break;
		case 3:
			sc.nextLine();
			System.out.println("Bitte ändern Sie das Geburtsdatum: ");
			pers.setGebDat(sc.nextLine());
			System.out.println("Geburtsdatum wurde auf " + pers.getGebDat() + " geändert.\n");
			break;
		default:
			System.out.println("Ihre Eingabe konnte nicht verarbeitet werden!");
		}
	}

	public void menue() {
		System.out.println("***********************************");
		System.out.println("* Bitte wählen Sie aus:           *");
		System.out.println("* 1. Datensatz hinzufügen         *");
		System.out.println("* 2. Datensatz suchen             *");
		System.out.println("* 3. Datensatz bearbeiten         *");
		System.out.println("* 4. Datensatz löschen            *");
		System.out.println("* 5. Anwendung beenden            *");
		System.out.println("***********************************");
	}

	public void menueAusw() {
		int auswahl = 0;
		auswahl = sc.nextInt();

		switch (auswahl) {
		case 1:
			String[] pD = new String[3];

			int eingabe = 0;

			do {
				sc.nextLine(); // Eingabepuffer leeren
				pD = this.eingabe();
				pers = new Person(pD[0], pD[1], pD[2]);

				this.hinzufuegen();
				System.out.println("Möchten Sie weitere Datensätze einlesen (0 für Abbruch)?");
				eingabe = sc.nextInt();
			} while (eingabe != 0);
			break;
		case 2:
			sc.nextLine();
			this.suche();
			break;
		case 3:
			sc.nextLine();
			this.suche();
			this.aendern();
			break;
		case 4:
			sc.nextLine();
			this.suche();
			this.loeschen();
			break;
		case 5:
			this.ausgabe();
			this.beenden();
			break;
		}

		this.ausgabe();
	}

	public void beenden() {
		daten.saveFile();
		System.exit(0);
	}
}