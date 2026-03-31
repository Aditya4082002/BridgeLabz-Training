package classanobject;

public class ShoppingCart {

	public static void main(String[] args) {
		//create object of cart 
		Cart cart1 = new Cart("Laptop",1999,1);
		
		cart1.addItem(2);
		cart1.removeItem(1);
		cart1.displayCart();
	}
}

//class definition
class Cart{
	//attributes
	private String itemName;
	private int price;
	private int quantity;
	
	//constructor
	public Cart(String name,int price,int quantity) {
		this.itemName = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	//method to add item in cart
	public void addItem(int number) {
		quantity+=number;
		System.out.println("Added " + number + " of " + itemName + " to the cart");
	}
	
	//method to remove items from cart
	public void removeItem(int number) {
		if(quantity>=number) {
			quantity-=number;
			System.out.println("Removed" + number + "  " + itemName + " from the cart");
		}else {
			System.out.println("enough items are not in cart");
		}
	}
	
	//method to display total cost
	public void displayCart() {
		System.out.println("Total cost : " + quantity*price);
	}
}
