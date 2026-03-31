package csvdatahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSV {

	public static void main(String[] args) {
		String filepath = "students.csv";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
			String line;
			System.out.println("Student Details:");
            System.out.println("----------------");
			while((line = reader.readLine())!=null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);
                if(marks>80) {
                    System.out.println("ID    : " + id);
                    System.out.println("Name  : " + name);
                    System.out.println("Age   : " + age);
                    System.out.println("Marks : " + marks);
                    System.out.println("----------------");
                }
			}
		}catch(IOException e) {
			System.out.println("file not found");
		}
		
	}

}
