package filehandlingandsearch;

public class StringBufferVsStringBuilder {

	public static void main(String[] args) {
		int number = 1000000;
		
		StringBuffer buffer = new StringBuffer();
		long startBuffer = System.nanoTime();
		
		for(int i=0;i<number;i++) {
			buffer.append("hello");
		}
		
		long endBuffer = System.nanoTime();
		System.out.println("total time in buffer : " + (endBuffer - startBuffer));
		
		
		StringBuilder builder = new StringBuilder();

		long startBuilder = System.nanoTime();
		for(int i=0;i<number;i++) {
			builder.append("hello");
		}
		long endBuilder = System.nanoTime();
		System.out.println("total time in builder :" + (endBuilder - startBuilder));
	}
}