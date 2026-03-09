import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static char[][] map;
	static int[][] countMap;
	static boolean[][] visited;
	static int N;
	static int min;

	// 상하좌우 , 좌상/우상/좌하/우하
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine()); // 3
			map = new char[N][N];
			countMap = new int[N][N];
			visited = new boolean[N][N];

			min = 0;

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int around = 0;
					if(map[i][j] == '*') {
						countMap[i][j] = -1;
						visited[i][j] = true;
						continue;
					}
					for (int d = 0; d < 8; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (inRange(ny, nx) && map[ny][nx] == '*') {
							around++;
						}
					}
					countMap[i][j] = around;
				}
			} // 1. 각 위치에서 주변에 폭탄이 몇개 있는지 설정

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (countMap[i][j] == 0 && !visited[i][j]) {
						bfs(i, j);
						min++;
					}
				}
			}// 2. 1차 탐색 : 숫자가 0인 칸을 먼저 찾는다.
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(!visited[i][j]) {
						min++;
					}
				}
			}

			sb.append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		int[] init = new int[] { y, x };
		visited[y][x] = true;
		queue.offer(init);
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int cy = current[0];
			int cx = current[1];

			for (int d = 0; d < 8; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (inRange(ny, nx) && countMap[ny][nx] >=0 &&!visited[ny][nx]) {
					visited[ny][nx] = true;
					if (countMap[ny][nx] == 0) {
						queue.offer(new int[] { ny, nx });
					}
				}
			}
		}
	}

	private static boolean inRange(int y, int x) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
