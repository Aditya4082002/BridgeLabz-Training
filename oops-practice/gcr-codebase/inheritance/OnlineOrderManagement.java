package inheritance;

//super class
class Order{
	//attributes
	protected int orderId;
	protected String orderDate;
	
	//constructor
	Order(int orderId, String orderDate){
		this.orderId = orderId;
		this.orderDate = orderDate;
	}
	
	public void getOrderStatus() {
		System.out.println("Order Id : " + orderId);
		System.out.println("Order date : " + orderDate);
	}
}

//child class 
class ShippedOrder extends Order{
	//attributes
	protected int trackingNumber;
	
	//constructor
	ShippedOrder(int orderId, String orderDate ,int trackingNumber){
		super(orderId,orderDate);
		this.trackingNumber = trackingNumber;
	}
	
	@Override 
	public void getOrderStatus() {
		super.getOrderStatus();
		System.out.println("Tracking Number : " + trackingNumber);
	}
	
}

//child class from shipped order class
class DeliveredOrder extends ShippedOrder{
	//attributes
	protected String deliveryDate;
	//constructor
	DeliveredOrder(int orderId, String orderDate ,int trackingNumber,String deliveryDate) {
		super(orderId,orderDate ,trackingNumber);
		this.deliveryDate = deliveryDate;
	}
	@Override 
	public void getOrderStatus() {
		super.getOrderStatus();
		System.out.println("delivery date : " + deliveryDate);
	}
}


public class OnlineOrderManagement {

	public static void main(String[] args) {
		DeliveredOrder deliveredOrder1 = new DeliveredOrder(101,"12-12-2025",2556420,"2-1-2026");
		deliveredOrder1.getOrderStatus();
	}

}
