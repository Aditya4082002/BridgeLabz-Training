//create class ProfitLossCalculator to calculate profit or loss based of cost price and sell price
class ProfitLossCalculator{
	public static void main(String[] args){
		//create variables for costPrice and sellPrice
		int costPrice = 129;
		int sellPrice = 191;
		
		//calculate profit and profitPercenntage
		double profit = sellPrice-costPrice;
		double profitPercenntage = (profit/costPrice)*100;
		
		//print the result in multiline
		System.out.println("The Cost Price is INR "+costPrice+" and Selling Price is INR "+sellPrice+
		"\nThe Profit is INR "+profit+"and the Profit Percentage is "+profitPercenntage+"%");
	}
}