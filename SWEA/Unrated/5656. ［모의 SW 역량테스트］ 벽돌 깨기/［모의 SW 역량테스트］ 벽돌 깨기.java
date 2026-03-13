import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N; // 벽돌 개수
	static int W; // 가로
	static int H; // 세로

	static int min;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			drop(0,map);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void copy(int[][] src, int[][] dest) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}

	static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0)
					count++;
			}
		}
		return count;
	}

	static boolean drop(int count, int[][] map) { // 구슬 떨어뜨리기 : 중복순열
		int remainCnt = getRemain(map);
		if (remainCnt == 0) {
			min = 0;
			return true; // 이 문제에서 나올 수 있는 가장 짱인 최적해가 등장
		}
		if (count == N) { // 모든 구슬을 다 던졌다면... 남은 벽돌 개수 최솟값 갱신

			min = Math.min(remainCnt, min);
			return false;
		}

		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; c++) {
			// c열에 구슬 낙하 했을 경우 부서지게 되는 첫 벽돌 찾기
			int r = 0;
			while (r < H && map[r][c] == 0) {
				++r;
			}
			// 그런 벽돌이 없다면 부서지는 벽돌이 없으므로 다음 열로 시도.
			if (r == H)
				continue;
			// 그런 벽돌이 있다면 벽돌 부수기
			copy(map, newMap);
			int brick = map[r][c];
			// 연쇄 폭발
			boom(newMap, r, c);
			// 벽돌 내리기
			if (brick > 1)
				down(newMap);
			// 다음구슬 떨어뜨리기
			if (drop(count + 1, newMap))
				return true;
		}
		return false;
	}

	static void boom(int[][] map, int r, int c) { // 벽돌 연쇄 폭발, BFS
		Queue<Point> queue = new ArrayDeque<>();
		if (map[r][c] > 1)
			queue.offer(new Point(r, c, map[r][c]));
		map[r][c] = 0; // 벽돌 깨기
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur.r;
				int nc = cur.c;
				for (int k = 0; k < cur.no - 1; k++) {
					nr += dr[d];
					nc += dc[d];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						if (map[nr][nc] > 1)
							queue.offer(new Point(nr, nc, map[nr][nc]));
						map[nr][nc] = 0; // 벽돌 깨기
					}
				}
			}
		}
	}

	static void down(int[][] map) { // 별돌 내리기
		// 모든 열에 대해 처리 (열 고정 후 처리)
		for (int c = 0; c < W; c++) {
			int er = H - 1;
			while (er >= 0 && map[er][c] != 0)
				--er;
			if (er < 0)
				continue;
			for (int r = er - 1; r >= 0; r--) {
				if (map[r][c] != 0) {
					map[er][c] = map[r][c];
					map[r][c] = 0;
					--er;
				}
			}
		}
	}

	static class Point {
		int r, c, no;

		public Point(int r, int c, int no) {
			super();
			this.r = r;
			this.c = c;
			this.no = no;
		}
	}
}
