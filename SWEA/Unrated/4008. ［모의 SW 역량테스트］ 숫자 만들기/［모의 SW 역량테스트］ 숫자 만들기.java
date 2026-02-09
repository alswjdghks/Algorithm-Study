import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] numbers;
	static int[] oper;
	static int N;
	static int max;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine()); // 10

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine()); // 5
			numbers = new int[N];
			oper = new int[4];

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			backTracking(0, numbers[0], oper[0], oper[1], oper[2], oper[3]);

			System.out.println("#" + tc + " " + (max - min));
		}
	}

	private static void backTracking(int idx, int prev, int plus, int minus, int multiple, int division) {
		if (idx == N - 1) {
			max = Math.max(max, prev);
			min = Math.min(min, prev);
			return;
		}

		if (plus > 0) {
			backTracking(idx + 1, prev + numbers[idx+1], plus - 1, minus, multiple, division);
		}

		if (minus > 0) {
			backTracking(idx + 1, prev - numbers[idx+1], plus, minus - 1, multiple, division);
		}

		if (multiple > 0) {
			backTracking(idx + 1, prev * numbers[idx+1], plus, minus, multiple - 1, division);
		}

		if (division > 0) {
			backTracking(idx + 1, prev / numbers[idx+1], plus, minus, multiple, division - 1);
		}
	}

}