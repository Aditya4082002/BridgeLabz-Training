//create a clss FeeCalculator to calculate the discount and final fee to pay
class FeeCalculator{
	public static void main(String[] args){
		//create variables to indicate fee and discountPercent
		int fee = 12500;
		int discountPercent = 10;
		
		//calculate discount and final fee to pay
		int discount = (fee/100)*discountPercent;
		int feeToPay = fee-discount;
		
		//display the results
		System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+feeToPay);
	}
}