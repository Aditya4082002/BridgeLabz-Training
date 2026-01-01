package thisStaticFinal;

public class Student {

	//static variable 
	static String universityName = "Global University"; 
	static int totalStudent = 0;
			
	//instance variables
	private String name;
	private char grade;
	private final int rollNumber; //can not be changed
		
	public static void displayTotalStudents() {
		System.out.println("Total Student : "  + totalStudent);
	}
		
	//constructor
	public Student(String name,char grade, int rollNumber){
		this.name = name;
		this.grade=grade;
		this.rollNumber=rollNumber;
		totalStudent++;
	}
	
	public void updateGrade(char grade) {
		this.grade = grade;
		System.out.println("Grade Updated to : " + grade);
	}
			
	//method to display details
	public void displayDetails() {
		if(this instanceof Student) {
			System.out.println("University Name : " + universityName);
			System.out.println("rollNumber : " + rollNumber);
			System.out.println("Name : " + name);
			System.out.println("grade : " + grade);
			
		}else {
			System.out.println("Invalid Object");
		}
	}
			
	//main method 
	public static void main(String[] args) {
		Student  student1 = new Student("Hemashree",'A',101);
		Student  student2 = new Student("Sharmila",'B',102);
		displayTotalStudents();
		student1.displayDetails();
		student2.displayDetails();
		student2.updateGrade('A');
		student2.displayDetails();
	}

}
