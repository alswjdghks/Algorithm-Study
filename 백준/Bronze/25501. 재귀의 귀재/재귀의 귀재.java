import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int count;
	
	public static void main(String[] args)throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < T ; i++) {
			count = 0;
			String str = br.readLine();
			System.out.println(isPalindrome(str,0,str.length()-1) + " "  + count);
		}
	}
	
	private static int isPalindrome(String s, int first, int last) {
		count++;
		if(first >= last) {
			return 1;
		}else if(s.charAt(first) != s.charAt(last)) {
			return 0;
		}else {
			return isPalindrome(s,first+1, last-1);
		}
	}
}