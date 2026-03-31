package streams;

import java.io.*;

public class UserInfoToFile {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = null;

        try {
            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(br.readLine());

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            fw = new FileWriter("user_info.txt");

            fw.write("---- User Information ----\n");
            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + language + "\n");

            System.out.println("\nData saved successfully into user_info.txt");

        } catch (NumberFormatException e) {
            System.out.println("Invalid age! Please enter a valid number.");

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());

        } finally {
            try {
                if (fw != null) fw.close();
            } catch (IOException e) {
                System.out.println("Error closing FileWriter: " + e.getMessage());
            }
        }
    }
}

