package classanobject;

public class EmployeeDetails {

	public static void main(String[] args) {
		//creating object of employee class
		Employee employee1 = new Employee("Rohan",1,200000);
		Employee employee2 = new Employee("Avi",2,500000);
		
		//displayDetails method call
		employee1.displayDetails();
		employee2.displayDetails();
	}

}

//employee class
class Employee{
	//attributes
	private String name;
	private int id;
	private int salary;
	
	//constructor
	public Employee(String name, int id, int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	} 
	
	//method to display Employee details
	public void displayDetails() {
		System.out.println("Employee Name :" + name);
		System.out.println("Employee Id : " + id);
		System.out.println("Employee Salary : " + salary);
	} 
}