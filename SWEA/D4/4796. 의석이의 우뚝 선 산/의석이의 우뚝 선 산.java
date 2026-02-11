import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static int N;
	static int[] mountains;
	static int sum;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt(); // 9
			sum = 0;
			mountains = new int[N];
			for (int i = 0; i < N; i++) {
				mountains[i] = sc.nextInt();
			} // 산 등록

			int i = 0;
			while (i < N - 1) {
				int left = 0;
				int right = 0;

				// 1. 올라가면서 left 찾기
				while (i < N - 1 && mountains[i] < mountains[i + 1]) {
					left++;
					i++;
				}

				// 2. 내려가면서 right 찾기
				while (i < N - 1 && mountains[i] > mountains[i + 1]) {
					right++;
					i++;
				}

				// 3. left 와 right가 둘다 존재하면
				if (left > 0 && right > 0) {
					sum += left * right;
				}

				if (i < N - 1 && mountains[i] == mountains[i + 1]) {
					i++;
				}
			}

			System.out.println("#" + tc + " " + sum);
		}
		sc.close();
	}
}