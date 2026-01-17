package filehandlingandsearch;

public class ConcatenateUsingStringBuffer {
	
	public static String concate(String[] array) {
		StringBuffer sb = new StringBuffer();
		for(String str : array) {
			sb.append(str);
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		String[] array = {"Hello","World","this","is","Java"};
		
		String concatinatedString = concate(array);
		
		System.out.println("concatinatedString : " + concatinatedString);
	}
}