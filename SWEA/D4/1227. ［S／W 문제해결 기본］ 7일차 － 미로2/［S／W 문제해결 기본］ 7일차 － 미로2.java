import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int[] start;
	static int[] end;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static boolean answer;
	
	public static void main(String[] args) throws IOException {
		for (int tc = 1; tc <= 10; tc++) {
			int t_num = Integer.parseInt(br.readLine()); // 1
			sb.append("#").append(t_num).append(" ");
			map = new int[100][100];
			visited = new boolean[100][100];
			answer = false;
			
			for (int i = 0; i < 100; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < 100; j++) {
					map[i][j] = line[j] - '0';
					if (map[i][j] == 2) {
						start = new int[] { i, j };
					}
					if (map[i][j] == 3) {
						end = new int[] { i, j };
					}
				}
			}

			dfs(start[0], start[1]);

			int result = answer ? 1 : 0;
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int y, int x) {
		if (y == end[0] && x == end[1]) {
			answer = true;
			return;
		}
		if (visited[y][x])
			return;
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(inRange(ny,nx) && map[ny][nx] != 1) {
				dfs(ny,nx);
			}
		}
	}

	private static boolean inRange(int y, int x) {
		return x >= 0 && x < 100 && y >= 0 && y < 100;
	}
}
