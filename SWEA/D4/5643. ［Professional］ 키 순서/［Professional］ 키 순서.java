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
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int result = 0;
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			map = new boolean[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				map[start][end] = true;
			}

			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						map[i][j] = (map[i][k] && map[k][j]) || map[i][j];
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
						if (map[n][i]) { // n행에서 참인 결과 -> 나보다 크다.
							tall++;
						}
						if (map[i][n]) { // n열에서 참인 결과 -> 나보다 작다.
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
