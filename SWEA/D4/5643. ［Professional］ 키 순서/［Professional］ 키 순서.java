import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static int M;
	static ArrayList<Integer>[] A;
	static ArrayList<Integer>[] A_reverse;

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int result = 0;

			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			A = new ArrayList[N + 1];
			A_reverse = new ArrayList[N + 1];

			for (int i = 0; i <= N; i++) {
				A[i] = new ArrayList<>();
				A_reverse[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				A[start].add(end);
				A_reverse[end].add(start);
			}

			for (int i = 1; i <= N; i++) {
				int tall = bfs(i, A);
				int small = bfs(i, A_reverse);
				if (tall + small == N - 1) {
//					System.out.println(tall + " " + small + " " + i);
					result++;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int start, ArrayList<Integer>[] list) {
		int count = 0;
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int next : list[cur]) {
				if (!visited[next]) {
					queue.offer(next);
					visited[next] = true;
					count++;
				}
			}
		}
		return count;
	}
}
