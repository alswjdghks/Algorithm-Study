import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] map;
	static int roomCnt;
	static int[] room;
	static int max;
	// 상하좌우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 2
			map = new int[N][N];
			max = -1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = roomInfo(i, j);
					if (cnt > 0 && cnt > max) {
						max = cnt;
						room = new int[] { i, j };
					} else if (cnt == max) {
						if (map[room[0]][room[1]] > map[i][j]) {
							room = new int[] { i, j };
						}
					}
				}
			}

			System.out.println("#" + tc + " " + map[room[0]][room[1]] + " " + max);
		}
	}

	private static int roomInfo(int y, int x) {
		roomCnt = 1;
		BackTracking(y, x);
		return roomCnt;
	}

	private static void BackTracking(int y, int x) {

		for (int i = 0; i < 4; i++) {
			int cy = y + dy[i];
			int cx = x + dx[i];
			if (inRange(cy, cx) && map[cy][cx] - map[y][x] == 1) {
				roomCnt++;
				BackTracking(cy, cx);
			}
		}
	}

	private static boolean inRange(int y, int x) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}