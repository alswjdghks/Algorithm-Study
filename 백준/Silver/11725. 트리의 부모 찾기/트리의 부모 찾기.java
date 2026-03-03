import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<Integer>[] A;
	static int[] p;
	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 7
		A = new ArrayList[N+1];
		p = new int[N+1];
		
		for(int i = 0 ; i <= N ; i++) {
			A[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			A[start].add(end);
			A[end].add(start);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		p[1] = 1;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int n : A[current]) {
				if(p[n] != 0 ) continue;
				p[n] = current;
				queue.offer(n);
			}
		}
		
		for(int i = 2 ; i <= N ; i++) {
			System.out.println(p[i]);
		}
	}
		
}
