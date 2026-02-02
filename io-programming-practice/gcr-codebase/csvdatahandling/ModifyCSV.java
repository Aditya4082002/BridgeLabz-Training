package csvdatahandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class ModifyCSV {

	public static void main(String[] args) {
		String inputFile = "employee.csv";
		String outputFile = "output.csv";
		try(
			BufferedReader reader = new BufferedReader(new FileReader(inputFile)); 
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
		){
			reader.readLine();
			String line;
			while((line=reader.readLine())!=null) {
				String[] data = line.split(",");
				String id = data[0];
				String name = data[1];
				String dept = data[2];
				double salary = Double.parseDouble(data[3]);
				if(dept.equalsIgnoreCase("IT")) {
					salary+=(salary*0.1);//+10%
				}
				writer.write(id+","+name+","+dept+","+salary+"\n");
				
			}
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
