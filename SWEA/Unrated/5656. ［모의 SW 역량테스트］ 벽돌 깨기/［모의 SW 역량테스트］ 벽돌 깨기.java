import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N; // 벽돌 개수
	static int W; // 가로
	static int H; // 세로

	static int[][] map;
	static int min;

	// 시계방향 (상우하좌)
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	// 벽돌 정보를 담는 클래스
	static class Brick {
		int r, c, size;

		public Brick(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine()); // 5
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			int count = 0;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						count++;
				}
			}

			min = count;
			simulation(0, map, count);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void simulation(int index, int[][] map, int count) {
		if (index == N || count == 0) {
			min = Math.min(count, min);
			return;
		}

		for (int i = 0; i < W; i++) {
			int[][] nextMap = clone(map);

			int broken = crash(i, nextMap);
			if (broken == 0) {
				simulation(index + 1, nextMap, count);
			} else {
				simulation(index + 1, nextMap, count - broken);
			}

		}
	}

	private static int crash(int col, int[][] map) {
		int row = 0;
		while (row < H && map[row][col] == 0) {
			row++;
		}
		if (row == H)
			return 0;

		int cnt = chainReaction(row, col, map);

		flush(map);
		return cnt;
	}
	
	private static int chainReaction(int r, int c, int[][] map) {
		Queue<Brick> queue = new ArrayDeque<>();
		
		if(map[r][c] == 1) {
			map[r][c] = 0;
			return 1;
		}
		
		queue.offer(new Brick(r,c,map[r][c]));
		map[r][c] = 0;
		int count = 1;
		
		while(!queue.isEmpty()) {
			Brick curr = queue.poll();
			
			for(int d = 0 ; d< 4 ; d++) {
				int nr = curr.r;
				int nc = curr.c;
				
				for(int s = 1 ; s < curr.size; s++) {
					nr += dy[d];
					nc += dx[d];
					
					if(inRange(nr,nc)) {
						if(map[nr][nc] > 0) {
							if(map[nr][nc] > 1) {
								queue.offer(new Brick(nr,nc,map[nr][nc]));
							}
							map[nr][nc] = 0;
							count++;
						}
					}else {
						break;
					}
				}
			}
		}
		return count;
	}
	
	private static void flush(int[][] map) {
		for (int col = 0; col < W; col++) {
			int row = H - 1; // 가장 아래 행부터 시작
			while (row > 0) {
				if (map[row][col] == 0) {
					int nextRow = row - 1;
					// 위쪽으로 올라가면서 벽돌을 찾음
					while (nextRow > 0 && map[nextRow][col] == 0) {
						nextRow--;
					}
					// 찾은 벽돌을 현재 빈칸으로 내리고, 찾은 칸은 0으로 만듦
					map[row][col] = map[nextRow][col];
					map[nextRow][col] = 0;
				}
				row--; // 위칸으로 이동
			}
		}
	}

	private static boolean inRange(int y, int x) {
		return x >= 0 && x < W && y >= 0 && y < H;
	}

	private static int[][] clone(int[][] map) {
		int[][] temp = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
}
