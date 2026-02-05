import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int C;
	static int[][] map;

	static int[] person1_score;
	static int[] person2_score;

	static int max;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 4
			M = Integer.parseInt(st.nextToken()); // 2
			C = Integer.parseInt(st.nextToken()); // 13

			map = new int[N][N];

			max = 0;
			result = 0;

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			person1_score = new int[M];
			person2_score = new int[M];

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < (N - M + 1); k++) {

					// person1
					for (int l = 0; l < M; l++) {
						person1_score[l] = map[j][k + l];
					}

					int person1_max = getMax(person1_score);

					// person2
					for (int jj = 0; jj < N; jj++) {
						for (int kk = 0; kk < (N - M + 1); kk++) {
							if (jj == j && kk < k + M)
								continue;
							for (int ll = 0; ll < M; ll++) {
								person2_score[ll] = map[jj][kk + ll];
							}

							int person2_max = getMax(person2_score);
							result = Math.max(result, person1_max + person2_max);
						}
					}

				}

			}

			System.out.println("#" + i + " " + result);
		}
	}

	private static int getMax(int[] person) {
		max = 0;
		backTracking(0, 0, 0, person);
		return max;
	}

	private static void backTracking(int idx, int total, int sum, int[] arr) {
		if (total > C)
			return;
		max = Math.max(max, sum);
		if (idx == M)
			return;
		backTracking(idx + 1, total + arr[idx], sum + (int) Math.pow(arr[idx], 2), arr); // 현재를 포함
		backTracking(idx + 1, total, sum, arr); // 현재를 포함하지 않았을 때
	}
}