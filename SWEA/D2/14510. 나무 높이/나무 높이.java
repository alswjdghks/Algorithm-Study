import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] trees;
	static int[] height;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine()); // 2
			trees = new int[N];
			height = new int[N];
			min = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, trees[i]);
			}

			int odd = 0;
			int even = 0;

			// 모든 나무에 대해 필요한 1과 2의 개수 총합하기
			for (int i = 0; i < N; i++) {
				height[i] = max - trees[i];
				even += height[i] / 2;
				odd += height[i] % 2;
			}

			// 2를 1 2개로 쪼개기
			while (even - odd > 1) {
				even--;
				odd += 2;
			}

			if (even > odd) {
				min = 2 * even;
			} else if (odd > even) {
				min = 2 * odd - 1;
			} else {
				min = 2 * even;
			}

			System.out.println("#" + tc + " " + min);

		}
	}
}