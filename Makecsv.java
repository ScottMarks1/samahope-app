import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.lang.Integer;

public class Makecsv {

	

	public static void generateCsvFile(String filePath) {
		
		try 
		{
			File file = new File(filePath);
			if (file.createNewFile())
			{
				System.out.println("File is created!");
			}
			else
			{
				System.out.println("File already exists.");
			}
			
			FileWriter writer = new FileWriter(file);
			
			writer.append("Names");
			writer.append(',');
			writer.append("IDs");
			writer.append('\n');

			writer.append("Brad");
			writer.append(',');
			writer.append("42");
			writer.append('\n');
					
			writer.append("Sags");
			writer.append(',');
			writer.append("-1");
			writer.append('\n');
			
			writer.flush();
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			
		}
		
	}
	
	public static void createCsvFromRows(String filePath, String[][] listOfRows) {
		try {
			File file = new File(filePath);
			if (file.createNewFile()) {
				System.out.println("File is created!");
			}
			else {
				System.out.println("File already exists.");
			}
			FileWriter writer = new FileWriter(file);
			for (int i = 0; i < listOfRows.length; i++) {
				String[] row = listOfRows[i];
				for (int j = 0; i < row.length; j++) {
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
	
	public static void createCsvFromColumns(String filePath, String[][] listOfColumns) {
		
	}
	
	public static void main(String[] args) {
		
		generateCsvFile("/Users/Brad/Desktop/myFile.csv");
		
	}

}
