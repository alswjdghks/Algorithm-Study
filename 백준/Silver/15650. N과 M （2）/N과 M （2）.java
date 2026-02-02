import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] S;
	static boolean[] V;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		
		S = new int[M]; // 출력순서를 유지한 배열
		V = new boolean[N]; // 방문여부
		backTracking(0,0);
	
	}
	
	private static void backTracking(int start, int len){
		if(len == M) {
			for(int i = 0 ; i < len ; i++) {
				System.out.print((S[i]+1)  + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start ; i < N ; i++) {
			S[len] = i;
			if(!V[i]) {
				V[i] = true;
				backTracking(i, len + 1);
				V[i] = false;
			}
		}
	}
	

}