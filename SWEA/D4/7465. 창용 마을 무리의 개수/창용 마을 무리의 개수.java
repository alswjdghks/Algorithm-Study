import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] parents;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException{
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= TC ; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			makeSet(N);
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			Set<Integer> set = new HashSet<>();
			for(int i = 1 ; i <= N ; i++) {
				set.add(findSet(i));
			}

			sb.append(set.size()).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void makeSet(int n) {
		for(int i = 1; i <= n ;i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = findSet(parents[a]);
	}
	
	private static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA == rootB) return;
		
		if(rootA > rootB) {
			parents[rootB] = rootA;
		}else {
			parents[rootA] = rootB;
		}
	}
}
