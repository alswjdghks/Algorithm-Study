import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int B;
	static int[] H;
	
	static int max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1 ; tc <=TC ; tc++ ) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			
			H = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < N ; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(H);
			
			dfs(0, B);
			
			System.out.println("#" + tc + " " + Math.abs(max));
		}
	}
	
	private static void dfs(int depth, int total) {
		if(depth == N) {
			if(total <= 0) {
				max = Math.max(max, total);	
			}
			return;
		}
		dfs(depth+1, total - H[depth]);
		dfs(depth+1, total);
	}
}