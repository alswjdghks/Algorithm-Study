import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, adj[][];
	static int cnt;

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			adj = new int[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				adj[a][b] = 1; // a 보다 b가 크다.
			}

			int answer = 0; // 자신의 키순서를 알 수 있는 학생 수
			for (int i = 1; i <= N; i++) {
				cnt = 0;
				boolean[] visited = new boolean[N + 1];
				gtDFS(i, visited);
				ltDFS(i, visited);
				if (cnt == N - 1)
					++answer;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void gtDFS(int cur, boolean[] visited) { // 자신보다 큰 학생따라 탐색
		// 방문 처리
		visited[cur] = true;

		// 현 정점의 인접정점 중 미방문 정점 따라 탐색
		for (int i = 1; i <= N; i++) {
			if (adj[cur][i] == 1 && !visited[i]) {
				++cnt;
				gtDFS(i, visited);
			}
		}
	}

	private static void ltDFS(int cur, boolean[] visited) { // 자신보다 작은 학생따라 탐색
		// 방문 처리
		visited[cur] = true;

		// 현 정점의 인접정점 중 미방문 정점 따라 탐색
		for (int i = 1; i <= N; i++) {
			if (adj[i][cur] == 1 && !visited[i]) {
				++cnt;
				ltDFS(i, visited);
			}
		}
	}
}
