package csvdatahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CountCSVRows {

	public static void main(String[] args) {
		String filepath = "employee.csv";
		int count=0;
		
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
			//exclude header
			reader.readLine();
			
			//count number of rows
			while(reader.readLine()!=null) {
				count++;
			}
			System.out.println("Count : " + count);
			
		}catch(IOException e) {
			System.out.println("Error reading the file");
		}
	}
}