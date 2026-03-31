//import Scanner class to take input from user
import java.util.Scanner;

//create a class VoteAgeCheck to check whether the student can vote or not depending on his/her age using array
class VoteAgeCheck{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//create array for age of 10 students
		int[] age = new int[10];
		
		//take input for students age
		System.out.println("Enter age of 10 student: ");
		for(int index=0;index<10;index++){
			age[index] = input.nextInt();
		}
		
		//checking the age  of all students and showing they can vote or not
		for(int index=0;index<age.length;index++){
			if(age[index]<18){
				System.out.println("The student with the age "+age[index]+" cannot vote");
			}
			else{
				System.out.println("The student with the age "+age[index]+" can vote");
			}
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}