import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static int M;
	static int[][] adj;

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int result = 0;
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				adj[start][end] = 1;
			}

			for (int k = 1; k <= N; k++) { // 경유학생
				for (int i = 1; i <= N; i++) { // 출발학생
					// 출발학생과 경유학생이 같으면 경유효과 없음!! 따라서 Skip
					//
					if (i == k || adj[i][k] == 0)
						continue;

					for (int j = 1; j <= N; j++) { // 도착학생(i가 키관계를 알고싶은 학생 j)
						if (adj[i][j] == 1)
							continue;
						adj[i][j] = adj[i][k] & adj[k][j];
					}
				}
			}

			for (int n = 1; n <= N; n++) {
				int tall = 0;
				int small = 0;
				for (int i = 1; i <= N; i++) {
					if (n == i) {
						continue;
					} else {
						if (adj[n][i] == 1) { // n행에서 참인 결과 -> 나보다 크다.
							tall++;
						}
						if (adj[i][n] == 1) { // n열에서 참인 결과 -> 나보다 작다.
							small++;
						}
					}
				}

				if (tall + small == N - 1) { // 나보다 큰 사람 + 나보다 작은 사람 = N-1 인 경우 자신의 키가 몇번째 인지 아는 경우
					result++;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}
