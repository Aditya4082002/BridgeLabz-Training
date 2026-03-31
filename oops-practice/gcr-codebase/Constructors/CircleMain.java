package javaConstructors;


public class CircleMain {

	public static void main(String[] args) {
		//circle object creation
		Circle circle1 = new Circle(5);
		Circle circle2 = new Circle();
		
		circle1.areaOfCircle();
		circle1.circumferenceOfCircle();
		
		circle2.areaOfCircle();
		circle2.circumferenceOfCircle();

	}

}
//class definition
class Circle{
	
	//attributes
	private double radius;
	
	//default constructor
	public Circle() {
		radius = 0;
	}
	
	//parameterized constructor
	public Circle(double radius) {
		this.radius = radius;
	}
	
	//method to calculate area of circle and display it 
	public void areaOfCircle() {
		double area = Math.PI*radius*radius;
		System.out.println("Area of circle : " + area);
	}
	
	//method to calculate circumference of circle and display it
	public void circumferenceOfCircle() {
		double circumference = 2*(Math.PI)*radius;
		System.out.println("Circumference of circle : " + circumference);
	}
}
