package oopsPillars;

//interface
interface Department{
	void assignDepartment(String department);
	void getDepartmentDetails();
}

//abstract class
abstract class Employee{
	//attributes
	protected int employeeId;
	protected String name;
	protected double baseSalary;
	
	//abstract method
	public abstract double calculateSalary();
	
	public void setDetails(int employeeId,String name,double baseSalary) {
		this.employeeId = employeeId;
		this.name = name;
		this.baseSalary = baseSalary;
	}
	
	//display method
	public void displayDetails() {
		System.out.println("Emoplyee Id : " + employeeId);
		System.out.println("Name : " + name);
		System.out.println("Base Salary : " + baseSalary);
	}
}

//subclass
class FullTimeEmployee extends Employee implements Department{
	private final int WORK_HOUR= 8;
	private String department;
	
	FullTimeEmployee(int emplouyeeId,String name,double baseSalary){
		setDetails(emplouyeeId, name,baseSalary);
	}
	
	@Override
	public double calculateSalary() {
		double salary = WORK_HOUR*baseSalary;
		return salary;
	}
	
	//setter
	public void assignDepartment(String department) {
		this.department = department;
	}
	
	//getter
	public void getDepartmentDetails() {
		System.out.println("Department : " + department);
	}
}


//subclass
class PartTimeEmployee extends Employee implements Department{
	private final int WORK_HOUR= 4;
	private String department;
	
	//constructor
	PartTimeEmployee(int emplouyeeId,String name,double baseSalary){
		setDetails(emplouyeeId, name,baseSalary);
	}
	
	@Override
	public double calculateSalary() {
		double salary = WORK_HOUR*baseSalary;
		return salary;
	}
	
	//setter
	public void assignDepartment(String department) {
		this.department = department;
	}
	
	//getter
	public void getDepartmentDetails() {
		System.out.println("Department : " + department);
	}
	
	
}

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		Employee employee1 = new FullTimeEmployee(101,"Aditya",500);
		Employee employee2 = new PartTimeEmployee(102,"Utkarsh",100);
		employee1.displayDetails();
		employee2.displayDetails();
		((Department) employee1).assignDepartment("Sales");
		((Department) employee2).assignDepartment("Sales");
		((Department) employee1).getDepartmentDetails();
		((Department) employee1).getDepartmentDetails();
		System.out.println(employee1.calculateSalary());
		System.out.println(employee2.calculateSalary());
	}
}
