package scenrioBase;

public class MathUtility {
	
	//method to calculate factorial of a number
	public static int factorial(int number) {
		if(number<0) {
			System.out.println("number must be positive");
			return -1;
		}
		int factorial = 1;
		if(number == 0) {
			return 1;
		}
		else {
			for(int i=1;i<=number;i++)
			{
				factorial *= i;
			}
		}
		
		return factorial;
	}

	//method to check prime number
	public static boolean isPrime(int number) {
		if(number<0) {
			System.out.println("number must be positive");
			return false;
		}
		if(number == 1) {
			return false;
		}
		for(int i=2;i<=number/2;i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
	
	//method to find GCD of number
	public static int GCD(int number1,int number2) {
		
		if(number1 == 0) {
			return Math.abs(number2);
		}
		if(number2 == 0 ) {
			return Math.abs(number2);
		}
		
		while(number1!=number2) {
			if(number1>number2) {
				number1 -= number2;
			}else {
				number2 -= number1;
			}
		}
		
		return number1;
	}
	
	//method to find nth fibonacci number
	public static int nthFiboncci(int number) {
		if(number<0) {
			System.out.println("number must be positive");
			return -1;
		}
		if(number==0) {
			return 0;
		}
		if(number == 1) {
			return 1;
		}
		
		int first = 0;
		int second = 1;
		int next = 1;
		for(int i=2;i<=number;i++) {
			next = first + second;
			first = second;
			second = next;
		}
		return next;
	}
	
	public static void main(String[] args) {
		System.out.println("factorial of number 5 : " + factorial(5));
		System.out.println("is 5 prime number : " + isPrime(5));
		System.out.println("GCD of 12 and 18 " + GCD(12,18));
		System.out.println("8th fibonacci : "+nthFiboncci(8));		
	}
}