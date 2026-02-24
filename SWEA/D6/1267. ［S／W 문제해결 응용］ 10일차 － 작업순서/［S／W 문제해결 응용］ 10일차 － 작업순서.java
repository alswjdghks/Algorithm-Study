import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static ArrayList<Integer>[] A; // 그래프
	static boolean[] visited;  // 방문 여부
	static int[] def; // 연결되어있는 개수
	static int[] seq; // 순서
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	
	static class Work{
		int index;
		int seq;
		
		Work(int index, int seq){
			this.index = index;
			this.seq =seq;
		}
	}
	
	static ArrayList<Work> answer;
	
	public static void main(String[] args) throws IOException{
		for(int tc= 1 ; tc <= 10 ; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 9
			M = Integer.parseInt(st.nextToken()); // 9
			
			visited = new boolean[N+1];
			def = new int[N+1];
			seq = new int[N+1];
			answer = new ArrayList<>();
			
			A = new ArrayList[N+1];
			for(int i = 0; i < N+1 ; i++) {
				A[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				A[start].add(end);
				def[end]+=1;
			}
			
			for(int i = 1 ; i <= N ; i++) {
				TopologySort(i);
			}
			
//			System.out.print("def -> ");
//			for(int i = 1 ; i <= N ; i++) {
//				System.out.print(def[i] + " ");
//			}
//			System.out.println();
//			System.out.print("seq -> " );
//			for(int i = 1 ; i <= N ; i++) {
//				System.out.print(seq[i] + " ");
//			}
			
			for(int i = 1; i <= N ; i++) {
				answer.add(new Work(i,seq[i]));
			}
			
			Collections.sort(answer, new Comparator<Work>() {
				@Override
				public int compare(Work o1, Work o2) {
					return o1.seq - o2.seq;
				}
			});
			
//			System.out.println();
			for(Work w : answer) {
				sb.append(w.index).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void TopologySort(int start) {
		if(def[start] > 0) {
			return;
		}
		if(seq[start] > 0) {
			return;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		seq[start] = 1;
		queue.offer(start);
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for(int work : A[curr]) {
				seq[work] = Math.max(seq[curr]+1,seq[work]);
				if(--def[work] == 0) {
					queue.offer(work);
				}
			}
		}
	}

}
