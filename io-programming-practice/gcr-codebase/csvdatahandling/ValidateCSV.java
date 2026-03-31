package csvdatahandling;

import java.io.*;
class InvalidRowException extends Exception{
	InvalidRowException(String message){
		super(message);
	}
}

public class ValidateCSV {
	
	public static void validateRow(String line) throws InvalidRowException{
		String[] data = line.split(",");

        String name = data[0];
        String mail = data[1];
        String phone = data[2];
        String mailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.[a-z]{2,}$";
        String phoneRegex = "[1-9][0-9]{9}";
        if(!mail.matches(mailRegex)) {
        	throw new InvalidRowException("Invalid Email");
        }
        if(!phone.matches(phoneRegex)) {
        	throw new InvalidRowException("Invalid Phone");
        }
        System.out.println(line);
	}

	public static void main(String[] args){
		
		String filepath = "data.csv";
		try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
			String line;
			while((line = reader.readLine())!=null) {
				try {
					validateRow(line);
				}catch(InvalidRowException e) {
					System.out.println(e.getMessage());
				}
			}
		}catch(IOException e) {
			System.out.println("file not found");
		}
	}

}
