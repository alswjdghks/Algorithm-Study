import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int cnt;
	static int max;
	
	static int[][] cheese;
	static boolean[][] ate;
	static boolean[][] cheese_visited;
	static int N;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine()); // 2
		for (int i = 1; i <= TC; i++) {
			sb.append("#").append(i).append(" ");
			N = Integer.parseInt(br.readLine()); // 2

			cheese = new int[N][N];
			ate = new boolean[N][N];
			max = 1;
			
			int maxTaste = 0;
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					cheese[j][k] = Integer.parseInt(st.nextToken());
					maxTaste = Math.max(maxTaste, cheese[j][k]);
				}
			}
			
			for(int j = 1 ; j <= maxTaste ; j++) {
				ateCheese(j);
				cnt = 0;
				initCheeseAte();
				for(int k = 0 ; k < N ; k++) {
					for(int l = 0 ; l < N ; l++) {
						if(!cheese_visited[k][l]) {
							bfs(new int[] {k,l});
							cnt++;
						}
					}
				}
				max = Math.max(max, cnt);
			}
			
			sb.append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int[] start) {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		cheese_visited[start[0]][start[1]] = true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int y = current[0];
			int x = current[1];
			for(int i = 0 ; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(inRange(ny,nx) && !cheese_visited[ny][nx]) {
					queue.offer(new int[] {ny,nx});
					cheese_visited[ny][nx] = true;
				}
			}
		}
	}
	
	private static void ateCheese(int taste) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(cheese[i][j] == taste) {
					ate[i][j] = true;
				}
			}
		}
	}
	
	private static void initCheeseAte() {
		cheese_visited = new boolean[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				cheese_visited[i][j] = ate[i][j];
			}
		}
	}
	
	private static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}