package inheritance;

//interface
interface Worker{
	public void performDuties();
}
//super class
class Person{
	//attribute
	protected String name;
	protected int id;
	
	//constructor
	Person(String name,int id){
		this.name=name;
		this.id=id;
	}
}

//Chef subclass
class Chef extends Person implements Worker{
	//constructor
	Chef(String name,int id){
		super(name,id);
	}
	@Override
	public void performDuties() {
		System.out.println("Duty : Cooking food.");
	}
}


//Waiter subclass
class Waiter extends Person implements Worker{
	//constructor
	Waiter(String name,int id){
		super(name,id);
	}
	@Override
	public void performDuties() {
		System.out.println("Duty : Serving food.");
	}
}


public class RestaurantManagement {

	public static void main(String[] args) {
		Chef chef1 = new Chef("Aman" ,101);
		Waiter waiter1 = new Waiter("Bob",201);
		
		chef1.performDuties();
		waiter1.performDuties();
	}

}
