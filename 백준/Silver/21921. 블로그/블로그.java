import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 5
		int X = Integer.parseInt(st.nextToken()); // 2
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i = 0 ; i < X ; i++) {
			sum += arr[i];
		}

		int max = sum;
		int max_count = 1;
		
		for(int i = 1; i < N-X +1 ; i++) {
			sum = sum - arr[i-1] + arr[i+X-1];
			if(max == sum) {
				max_count++;
			}else if(max < sum) {
				max = sum;
				max_count = 1;
			}
		}
		
		if(max == 0) {
			System.out.println("SAD");
		}else {
			System.out.println(max);
			System.out.println(max_count);
		}
	}
}