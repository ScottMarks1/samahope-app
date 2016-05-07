import java.util.ArrayList;

public class Tester extends ParseTexts {

	public static void main(String[] args) {
		// CREATES A TEST FILE
		String s = "CHWS 1. apr 42.brad3.berkay4. 20 5. m 6. rye brook 7. sagar 8. x 9. y 10. z 11.12.hi13. bi";
		String s2 = "chws3. brad 4. 20 5. m 6. rye brook 7. sagar 11. no";
		String s3 = "chws1. 5/7/16 2. dr. smith 3. bob 4. 42 5. m 6.  ithaca 7. kelley 8. d 9. 11. yes";
		String s4 = "chws1. 1/1/47 2. dr. smith 3. bob 4. 42 5. m 6.  ithaca 7. kelley 8. d 9. 11. yes";
		String s5 = "this is an invalid string";
		String s6 = "CHWS1.";
		String s7 = "CHWS 2. brad";
		ArrayList<String[]> table = createTable();
		addDataToTable(s, table);
		addDataToTable(s2, table);
		addDataToTable(s3, table);
		addDataToTable(s4, table);
		addDataToTable(s5, table);
		addDataToTable(s6, table);
		addDataToTable(s7, table);
		createCsvFromTable("/Users/Brad/Desktop/sama1.csv", table);
	}

}