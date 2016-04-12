import java.util.ArrayList;

public class Tester extends ParseTexts {

	public static void main(String[] args) {
		// CREATES A TEST FILE
		String s = "CHWS 1. apr 4 2. brad 3. 20 4. m 5. rye brook 6. sagar 7. x 8. y 9. z 10. no 11. 12. ";
		String s2 = "CHWS2. brad 3. 20 4. m 5. rye brook 6. sagar 10. no";
		ArrayList<String[]> table = createTable();
		addDataToTable(s, table);
		addDataToTable(s2, table);
		createCsvFromTable("/Users/Brad/Desktop/myFile.csv", table);
	}

}