package exceptions;
import java.io.*;

public class ReadFileExample {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("copy.txt"))){
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch(IOException e) {
			System.out.println("File not found");
		}

	}

}
