package linkedList;

class Node{
	int rollNumber;
	String name;
	int age;
	char grade;
	Node next;
	
	public Node(int rollNumber,String name,int age,char grade) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
}

//student linked list
class Student{
	//head pointer
	Node head;
	
	//insertion at end
	public void insertAtLast(int rollNumber,String name,int age,char grade) {
		Node newNode = new Node(rollNumber,name,age,grade);
		if(head==null) {
			head = newNode;
			return;
		}
		
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}
	
	//insertion at beginning
	public void insertAtBeginning(int rollNumber,String name,int age,char grade) {
		Node newNode = new Node(rollNumber,name,age,grade);
		
		newNode.next = head;
		head = newNode;
	}
	
	//insertion at specific position (1 based index)
	public void insertAtPosition(int rollNumber,String name,int age,char grade,int position) {
		if(position == 1) {
			insertAtBeginning(rollNumber,name,age,grade);
			return;
		}
		Node newNode = new Node(rollNumber,name,age,grade);
		Node temp = head;
		for(int i=1;i<position-1;i++) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	
	}
	
	//delete student by rollNumber
	public void deleteStudent(int rollNumber) {
		
		if(head ==null) {
			System.out.println("No Student record available.");
		}
		
		if (head.rollNumber == rollNumber) {
	        head = head.next;
	        return;
	    }
		
		Node temp = head;
		while(temp.next != null && temp.next.rollNumber !=rollNumber) {
			temp = temp.next;
		}
		if(temp.next == null) {
			System.out.println("Student not found.");
		}else if(temp.next.rollNumber == rollNumber) {
			temp.next = temp.next.next;
		}
	}
	
	//display all students
	public void displayStudents(){
		if(head == null) {
			System.out.println("No Student record available.");
		}
		Node temp = head;
		while(temp!=null) {
			System.out.println("Roll Number : " + temp.rollNumber);
			System.out.println("Name : " + temp.name);
			System.out.println("Age : " + temp.age);
			System.out.println("Grade : " + temp.grade);
			temp=temp.next;
		}
	}
	
	//searching
	public void searchStudent(int rollNumber) {
		if(head == null) {
			System.out.println("No Student record available.");
		}
		
		Node temp = head;
		while(temp != null && temp.rollNumber !=rollNumber) {
			temp = temp.next;
		}
		if(temp == null) {
			System.out.println("Student not found.");
		}else if(temp.rollNumber == rollNumber) {
			System.out.println("Student found : ");
			System.out.println("Roll Number : " + temp.rollNumber);
			System.out.println("Name : " + temp.name);
			System.out.println("Age : " + temp.age);
			System.out.println("Grade : " + temp.grade);
		}
	}
	
	//update
	public void updateGrade(int rollNumber,char grade) {
		if(head == null) {
			System.out.println("No Student record available.");
		}
		Node temp = head;
		while(temp != null && temp.rollNumber !=rollNumber) {
			temp = temp.next;
		}
		if(temp == null) {
			System.out.println("Student not found.");
		}
		else {
			temp.grade = grade;
			System.out.println("Grade updated successfully.");
		}
		
	}
	
}

public class StudentRecordManagement {

	public static void main(String[] args) {
		Student studentList = new Student();
		studentList.insertAtBeginning(1, "Aditya", 22, 'O');
		studentList.insertAtBeginning(2, "Sumit", 20, 'A');
		studentList.insertAtLast(3, "utkarsh", 21, 'B');
		studentList.insertAtPosition(4, "Avi", 25, 'C', 3);
		studentList.updateGrade(2,'A');
		studentList.deleteStudent(3);
		studentList.searchStudent(1);
		
		studentList.displayStudents();
	}
}
