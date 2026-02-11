import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static int[][] map;
	static int sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			sum = 0;

			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < line.length; j++) {
					map[i][j] = line[j] - '0';
				}
			}

			int center = N / 2;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Math.abs(i - center) + Math.abs(j - center) <= center) {
						sum += map[i][j];
					}
				}
			}

			System.out.println("#" + tc + " " + sum);
		}

	}
}