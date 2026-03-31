package oopsPillars;
//interface
interface Taxable{
	public double calculateTax();
	public String getTaxDetails();
}

//abstract class
abstract class Product{
	//attributes
	private int productId;
	private String name;
	private double price;
	
	//abstract method
	public abstract double calculateDiscount();
	
	//getters
	public int getProductId() {
		return productId;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	//setter
	public void  setDetails(int productId,String name,double price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}
	
	
}

//electronics sub class
class Electronics extends Product implements Taxable{
	public double calculateDiscount() {
		return getPrice()*0.2;
	}
	
	public String getTaxDetails() {
		return "Electronics 12% tax";
	}
	
	public double calculateTax() {
		return getPrice()*0.12;
	}

}

//cllothing sub class
class Clothing extends Product implements Taxable{
	
	public double calculateDiscount() {
		return getPrice()*0.15;
	}
	public String getTaxDetails() {
		return "Clothing 10% tax";
	}
	
	public double calculateTax() {
		return getPrice()*0.1;
	}
}

//groceries sub class
class Groceries extends Product{
	public double calculateDiscount() {
		return getPrice()*0.05;
	}
}


public class ECommercePaltform {
	
	public static void calculateTax(Product[] products) {
		for(Product product : products) {
			double discount = product.calculateDiscount();
			double tax=0;
			if(product instanceof Taxable) {
				tax = ((Taxable) product).calculateTax();
			}
			System.out.println("Total price : " + (product.getPrice() + tax - discount));
		}
	}

	public static void main(String[] args) {
		Product product1 = new Electronics();
		Product product2 = new Clothing();
		Product product3 = new Groceries();
		
		product1.setDetails(101,"Laptop", 80000);
		product2.setDetails(201, "shirt", 750);
		product3.setDetails(301, "Sugar", 55);
		
		
		Product[] products = {product1, product2, product3};
		
		calculateTax(products);
	}
}