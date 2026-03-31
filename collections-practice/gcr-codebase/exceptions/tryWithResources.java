package exceptions;
import java.io.*;

public class tryWithResources {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("info.txt"))){
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch(IOException e) {
			System.out.println("Error Reading file");
		}
	}
}