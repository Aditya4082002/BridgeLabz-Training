package classanobject;

public class StudentMain {

	public static void main(String[] args) {
		//creating object of student class
		Student student1 = new Student("Thamarai","ECE001",80,70,75);
		Student student2 = new Student("Kannan","CSC002",60,65,50);
		
		student1.calculateGrade();
		student2.calculateGrade();
		
		student1.displayDetails();
		student2.displayDetails();
		
	}

}

//class definition
class Student{
	//attributes
	private String name;
	private String roll;
	private double mark1;
	private double mark2;
	private double mark3;
	private char grade;
	
	
	//constructor
	public Student(String name,String roll,double mark1,double mark2,double mark3) {
		this.name = name;
		this.roll = roll;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
	}
	
	//method to calculateGrade
	public void calculateGrade() {
		double average = (mark1 + mark2 + mark3)/3;
		if(average > 80) {
			grade = 'A';
		}else if(average>70) {
			grade = 'B';
		}else if(average >60) {
			grade ='C';
		}else {
			grade = 'D';
		}
	}
	
	//method to displayDetails
	public void displayDetails() {
		System.out.println("Student Name : " + name);
		System.out.println("Student RollNumber : " + roll);
		System.out.println("Studet Marks : ");
		System.out.println("Mark1 : " + mark1);
		System.out.println("Mark2 : " + mark2);
		System.out.println("Mark3 : " + mark3);
		System.out.println("Grade : " + grade);
		System.out.println("---------------------------");
	}
}