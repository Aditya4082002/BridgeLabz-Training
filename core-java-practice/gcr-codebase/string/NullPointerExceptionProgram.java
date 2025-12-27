//program to demonstrate NullPointerException.

class NullPointerExceptionProgram{
	public static void main(String[] args){
		
		handleException();
		
	}
	
	//method to generate exception
	public static void generateException(){
		String nullString = null;
		System.out.println(nullString.length());
	}
	
	//method to handle exception
	public static void handleException(){
		try{
			generateException();
		}
		catch(NullPointerException e){
			System.out.println("Null exception handled");
		}
	}
}