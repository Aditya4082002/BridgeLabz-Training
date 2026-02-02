package csvdatahandling;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {

	public static void main(String[] args) {
		String filepath = "employee.csv";
		
		try(FileWriter writer = new FileWriter(filepath)){
			
			writer.append("ID,Name,dept,salary\n");
			
			writer.append("101,Aditya,IT,50000\n");
			writer.append("102,Aditya,IT,60000\n");
			writer.append("103,Aditya,IT,70000\n");
			writer.append("104,Aditya,IT,80000\n");
			writer.append("105,Aditya,IT,90000\n");
			
			System.out.println("Csv file created and data written successfully.");
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}