package classanobject;

public class ItemMain {

	public static void main(String[] args) {
		
		//create object of item class
		Item item1 = new Item("01AA",500,"Water bottle");
		Item item2 = new Item("01BB",700,"Rice");
		Item item3 = new Item("02AA",400,"blackboard");
		
		item1.displayDetails();
		item2.displayDetails();
		item3.displayDetails();

	}

}

//class definition
class Item {
	//attributes
	private String itemCode;
	private double itemPrice;
	private String itemName;
	
	//constructor
	public Item(String code,double price,String name) {
		this.itemCode = code;
		this.itemPrice = price;
		this.itemName = name;
 	}
	
	//method to displayDetails
	public void displayDetails(){
		System.out.println("itemCode : " + itemCode);
		System.out.println("itemPrice : " + itemPrice);
		System.out.println("itemName : " + itemName);
		System.out.println("---------------------------");
	}
	
}