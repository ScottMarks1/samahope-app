package samahope.caringproject;

import java.lang.String;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Character;
public class ParseTexts {

    /* Creates a new table and fills the first row with the correct headers. */
    public static ArrayList<String[]> createTable() {
        String[] header = {"Date", "Name of Health Worker", "Name of Client", "Age", "Sex", "Village",
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
            try {
                String[] row = createRowFromString(s);
                table.add(row);
            }
            catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }

    /* Takes file path and table as input, and creates the csv file. */
    public static void createCsvFromTable(String filePath, ArrayList<String[]> listOfRows) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
            }
            else {
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

    /* Given a char, returns the appropriate type of family planning. */
    private static String typeOfFamilyPlanning(char c) {
        String s = null;
        c = Character.toLowerCase(c);
        if (c == 'a') s = "Pills";
        else if (c == 'b') s = "Injectable";
        else if (c == 'c') s = "Condoms";
        else if (c == 'd') s = "Moon beads";
        else if (c == 'e') s = "Natural method";
        else if (c == 'f') s = "Emergency contraception";
        else if (c == 'g') s = "Norplant";
        else if (c == 'h') s = "IUD";
        else if (c == 'i') s = "BTL";
        else if (c == 'j') s = "Vasectomy";
        return s;
    }

    /* Given a string that contains patient data, returns an array properly
     * organizing the data. The array represents a row in the spreadsheet,
     * and the ith element in the array represents the data to be stored in
     * the ith column of the spreadsheet, in the given row. */
    private static String[] createRowFromString(String s) {
        // remove CHWS tag
        s = (s.charAt(4) == ' ') ? s.substring(5) : s.substring(4);
        // create array (row) to fill
        String[] row = new String[13];
        // parse string
        for (int i = 1; i < 14; i++) {
            int j = s.indexOf((i+"."));
            if (j > 0 && s.charAt(j-1) == '1') j = -1;
            if (j != -1) {
                boolean foundNextInt = false;
                int ctr = i + 1;
                while (!foundNextInt) {
                    int k = s.indexOf(ctr+".");
                    int a = (i > 9) ? 3 : 2;
                    if (s.charAt(j+a) == ' ') a++;
                    if (j != -1 && k != -1) {
                        if (i == 8) {
                            String s8 = typeOfFamilyPlanning(s.charAt(j+a));
                            if (s8 != null) row[i-1] = s8;
                            else row[i-1] = s.substring(j+a, k);
                        }
                        else row[i-1] = s.substring(j+a, k);
                        foundNextInt = true;
                    }
                    else if (ctr < 14) {
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