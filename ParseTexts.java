import java.lang.String;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.lang.Integer;
public class ParseTexts {
	
	/* Creates a new table and fills the first row with the correct headers. */
	public static ArrayList<String[]> createTable() {
		String[] header = {"Date", "Name of Client", "Age", "Sex", "Village", 
			"Contact", "Type of family planning", "Side effect", "First Visit", 
			"Re-attend", "Referral reason and outcome", "Other comments"};
		ArrayList<String[]> table = new ArrayList<String[]>();
		table.add(header);
		return table;
	}

	/* Takes a text string and the table as input. If the text is valid data,
	 * adds the data to the table. */
	public static void addDataToTable(String s, ArrayList<String[]> table) {
		if (isData(s)) {
			String[] row = createRowFromString(s);
			table.add(row);
		}
	}

	/* Takes file path and table as input, and creates the csv file. */
	public static void createCsvFromTable(String filePath, ArrayList<String[]> listOfRows) {
		try {
			File file = new File(filePath);
			if (file.createNewFile()) {
				System.out.println("File is created!");
			}
			else {
				System.out.println("File already exists.");
			}
			FileWriter writer = new FileWriter(file);
			for (int i = 0; i < listOfRows.size(); i++) {
				String[] row = listOfRows.get(i);
				for (int j = 0; j < row.length; j++) {
					writer.append(row[j]);
					if (j == row.length - 1) {
						writer.append('\n');
					}
					else {
						writer.append(',');
					}
				}
			}
			writer.flush();
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	/* Given a string (text msg), returns whether it contains patient data,
	 * according to the "CHWS" tag at the beginning of the text. */
	private static boolean isData(String s) {
		if (s.length() < 4) return false;
		String tag = (s.substring(0, 4)).toLowerCase();
		return tag.equals("chws");
	}

	/* Given a string that contains patient data, returns an array properly
	 * organizing the data. The array represents a row in the spreadsheet,
	 * and the ith element in the array represents the data to be stored in
	 * the ith column of the spreadsheet, in the given row. */
	private static String[] createRowFromString(String s) {
		// remove CHWS tag
		s = (s.charAt(4) == ' ') ? s.substring(5) : s.substring(4);
		// create array (row) to fill
		String[] row = new String[12];
		// parse string
		for (int i = 1; i < 13; i++) {
			int j = s.indexOf((i+"."));
			if (j != -1) {
				boolean foundNextInt = false;
				int ctr = i + 1;
				while (!foundNextInt) {
					int k = s.indexOf(ctr+".");
					int a = (i > 9) ? 3 : 2;
					if (s.charAt(j+a) == ' ') a++;
					if (j != -1 && k != -1) {
						row[i-1] = s.substring(j+a, k);
						foundNextInt = true;
					}
					else if (ctr < 13) {
						ctr++;
					}
					else {
						row[i-1] = s.substring(j+a);
						foundNextInt = true;
					}
				}
			}
			else row[i-1] = "";
		}
		return row;
	}

	public static void main(String[] args) {
		
	}
	
}