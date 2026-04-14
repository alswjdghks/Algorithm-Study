import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int INF = 100_000_000;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 3

			dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
					if (dp[i][j] == 0 && i!= j) {
						dp[i][j] = INF;
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if(dp[i][k] == INF ) continue;
					for (int j = 0; j < N; j++) {
						dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
					}
				}
			}

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += dp[i][j];
				}
				min = Math.min(sum, min);
			}

			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
}
