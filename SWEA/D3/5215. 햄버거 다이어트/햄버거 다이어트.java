import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int L;
	static int[] score;
	static int[] calories;

	static int max_flavor;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine()); // 1

		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 5
			L = Integer.parseInt(st.nextToken()); // 1000

			score = new int[N];
			calories = new int[N];
			max_flavor = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0, 0);

			System.out.println("#" + (tc+1) + " " + max_flavor);
		}
	}

	private static void dfs(int cnt, int calory, int sum) {
		if (calory > L)
			return;
		max_flavor = Math.max(max_flavor, sum);
		if (cnt >= N)
			return;
		dfs(cnt + 1, calory + calories[cnt], sum + score[cnt]);
		dfs(cnt + 1, calory, sum);
	}
}