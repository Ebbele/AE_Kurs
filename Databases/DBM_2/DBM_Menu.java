import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DBM_Menu {
	private final String[] menu = {
			"1 - Datenbank ausgeben",
			"2 - Datensatz eintragen",
			"3 - Datensatz entfernen",
			"4 - Datensatz aendern", 
			"5 - Datensatz suchen",
			"6 - Programm beenden..."
	};

	private Scanner in = null;
	int maxMenuLen = 0;
	String trenner = "";
	String asterix = "*";

	public DBM_Menu() {
		int len = 0;
		for (String s : menu) {
			len = s.length();
			if (len > maxMenuLen)
				maxMenuLen = len;
		}
		trenner = new String(new char[maxMenuLen + 4]).replace("\0", asterix);
		in = new Scanner(System.in);
	}

	public void showMenu() {
		System.out.println(trenner);
		for (int c = 0; c < menu.length; c++) {
			System.out.print(asterix + " ");
			System.out.print(menu[c]);
			System.out.format("%" + (maxMenuLen - menu[c].length() + 1) + "s", " ");
			System.out.println(asterix);
		}
		System.out.println(trenner);
	}

	public int getCommand() {
		int cmd = 0;
		try {
			showMenu();
			System.out.println("Bitte Menuepunkt auswählen: ");
			String input = in.nextLine();
			cmd = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			getCommand();
		}

		return cmd;
	}

	private static String[] getValues(Scanner in) {
		String values[] = {
				"",
				"",
				"",
				""
		};
		// Scanner getNewEntry = new Scanner(System.in);
		System.out.print("Vorname : ");
		values[0] = /* getNewEntry */in.nextLine();
		System.out.print("Nachname: ");
		values[1] = /* getNewEntry */in.nextLine();
		System.out.print("Strasse : ");
		values[2] = /* getNewEntry */in.nextLine();
		System.out.print("Stadt   : ");
		values[3] = /* getNewEntry */in.nextLine();
		// getNewEntry.close();
		return values;
	}

	public void runCmd(int which, Connection connection) {
		switch (which) {
		case 1: // Datenbank ausgeben
			try {
				DBM_1.showQuery(DBM_1.dbQuery(connection, "SELECT * FROM customer"));
			} catch (SQLException except) {
				// TODO Auto-generated catch block
				except.printStackTrace();
			}
			break;
		case 2: // Eintrag einfuegen
			System.out.println("Daten fuer neuen Eintrag eingeben:");

			if (DBM_4.insertElement(connection, getValues(in)) == 1) {
				System.out.println("Eintrag erfolgreich");
			} ;
			break;
		case 3:
			System.out.print("Loesche Element mit ID: ");

			int id = -1;
			try {
				id = in.nextInt();
				in.nextLine();
				if (DBM_4.deleteElement(connection, id) == 1) {
					System.out.println("Loeschen erfolgreich...");
				}
			} catch (InputMismatchException e) {
				System.out.println("ID nicht vorhanden");
			}
			break;
		case 4:
			System.out.println("Aktualisiere ID: ");
			try {

				int idUpdate = -1;
				idUpdate = in.nextInt();
				in.nextLine();
				System.out.println("Alter Datensatz:");
				try {
					DBM_1.showQuery(DBM_1.dbQuery(connection, "SELECT * FROM customer WHERE id = " + idUpdate));
					System.out.println("Neue Daten:");
					if (DBM_4.updateDatabase(connection, idUpdate, getValues(in)) == 1) {
						System.out.println("Aenderung erfolgreich...");
					}
				} catch (SQLException except) {
					except.printStackTrace();
				}

			} catch (InputMismatchException e) {
				System.out.println("ID nicht vorhanden");
				in.nextLine();
			}
			break;
		case 5:
			System.out.println("Suche nach ID: ");
			try {

				int idUpdate = -1;
				idUpdate = in.nextInt();
				in.nextLine();
				try {
					DBM_1.showQuery(DBM_1.dbQuery(connection, "SELECT * FROM customer WHERE id = " + idUpdate));
				} catch (SQLException except) {
					except.printStackTrace();
				}

			} catch (InputMismatchException e) {
				System.out.println("ID nicht vorhanden");
				in.nextLine();
			}
			break;
		}

	}
}
