package javaConstructors;

public class PersonMain {

	public static void main(String[] args) {
		Person person1 = new Person(165,85);
		Person person2 = new Person(person1);
		
		person1.displayDetails();
		person2.displayDetails();
	}

}
//class definition
class Person{
	//attributes
	private double height ;
	private double weight ;
	
	//parameterized constructor
	public Person(double height, double weight) {
		this.height = height;
		this.weight = weight;
	}
	
	//copy constructor
	public Person(Person person1) {
		this.height = person1.height;
		this.weight = person1.weight;
	}
	
	public void displayDetails() {
		System.out.println("Height : " + height);
		System.out.println("Weight : " + weight);
	}
}