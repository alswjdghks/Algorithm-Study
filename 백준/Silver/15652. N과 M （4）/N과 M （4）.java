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
		
		V = new boolean[N]; // 방문 여부
		S = new int[M]; // 순서 출력을 위한 배열
		backTracking(0,0);
	}
	
	private static void backTracking(int length, int start) {
		if(length == M ) {
			for(int i = 0 ; i < M ; i++) {
				System.out.print(S[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start ; i < N ; i++) {
			V[i] = true;
			S[length] = i+1;
			backTracking(length + 1, i);
			V[i] = false;
		}
	}

}