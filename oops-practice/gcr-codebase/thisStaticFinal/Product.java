package thisStaticFinal;

public class Product {

	//static variable 
	static int discount = 10;
				
	//instance variables
	private final String productId; //cannot  be changed 
	private String productName;
	private double price;
	private int quantity;
	
	//static methods
	public static void updateDiscount(int newdiscount) {
		discount = newdiscount;
	}
	
	//constructor
	public Product(String productId,String productName, double price, int quantity){
		this.productId = productId;
		this.productName=productName;
		this.price=price;
		this.quantity = quantity;
	}
				
	//method to display details
	public void displayDetails() {
		if(this instanceof Product) {
			System.out.println("ProductId: " + productId);
			System.out.println("ProductName : " + productName);
			System.out.println("Price : " + price);
			System.out.println("Quantity : " + quantity);
			System.out.println("Discount : " + discount);
			
			double discountedPrice = price-(price*discount)/100;
			
			System.out.println("Price after discount : " + discountedPrice);
		}else {
			System.out.println("Invalid Object");
		}
	}

	//main method 
	public static void main(String[] args) {
		Product product1 = new Product("P001","Laptop",1200,5);
		Product product2 = new Product("P002","SmartPhone",800,10);
		product1.displayDetails();
		product2.displayDetails();
	}
}
