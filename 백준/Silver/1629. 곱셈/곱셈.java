import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int value;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int num3 = Integer.parseInt(st.nextToken());
		
		System.out.println(recursive(num1,num2,num3));
	}
	
	private static long recursive(int num1, int num2, int num3) {
		if(num2 == 0) {
			return 1;
		}
		if(num2 == 1) {
			return num1 % num3;
			
		}
		long half = recursive(num1, num2/2, num3);
		
		if(num2 % 2 == 0) {
			return ( half * half ) % num3;
		}else {
			return ((half * half % num3) * ( num1 % num3 )) % num3;
		}
	}
		
}
