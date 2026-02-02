package csvdatahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchCSV {

	public static void main(String[] args) {
		String filePath = "employee.csv";
		String name = "Aditya";
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			boolean found = false;
			String line;
			while((line = reader.readLine())!=null) {
				String[] data = line.split(",");
				if(data[1].equalsIgnoreCase(name)) {
					System.out.println("Department : "+ data[2]);
					System.out.println("Salary : "+ data[3]);
					found =true;
					break;
				}
			}
			if(!found) {
				System.out.println("No employee found.");
			}
			
		}catch(IOException e) {
			System.out.println("Error reading file");
		}
	}

}
