package streams;

import java.io.*;

public class StudentDataStreamDemo {

    public static void main(String[] args) {

        String fileName = "students.dat";

        //Writing data into binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {

            // Student 1
            dos.writeInt(101);            // roll number
            dos.writeUTF("Alice");        // name
            dos.writeDouble(8.7);         // GPA

            // Student 2
            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(9.1);

            System.out.println("Student data saved into " + fileName);

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        System.out.println();

        //Reading data from binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {

            System.out.println("Reading student data from file:");

            // read until file ends
            while (true) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }

        } catch (EOFException e) {
            System.out.println("End of file reached.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

