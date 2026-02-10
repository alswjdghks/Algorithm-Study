import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static class Atom {
		int x;
		int y;
		int E;
		int dir;
		boolean isDead;

		Atom(int x, int y, int E, int dir) {
			this.x = x;
			this.y = y;
			this.E = E;
			this.dir = dir;
			this.isDead = false;
		}
	}

	static ArrayList<Atom> list;
	static int totalE;
	static int[][] map = new int[4001][4001];
	// 상하좌우
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			list = new ArrayList<>();
			totalE = 0;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int dir = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());

				list.add(new Atom(x, y, E, dir));
			}

			while (list.size() > 1) {
				// 1. 모든 원자 한칸씩 이동하기
				for (Atom a : list) {
					a.x += dx[a.dir];
					a.y += dy[a.dir];
				}

				// 2. 격자 밖에 있는 경우 dead & 안에 있는 경우에는 에너지를 해당 위치에 저장
				for (Atom a : list) {
					if (a.x > 4000 || a.x < 0 || a.y > 4000 || a.y < 0) {
						a.isDead = true;
						continue;
					}

					map[a.y][a.x] += a.E;
				}

				// 3. 저장된 에너지가 원자의 에너지와 다른경우 총 에너지 저장 및 dead
				for (Atom a : list) {
					if (a.isDead)
						continue;

					if (map[a.y][a.x] != a.E) {
						a.isDead = true;
						totalE += a.E;
					}
				}

				// 4. map 원상복구
				for (Atom a : list) {
					if (a.x >= 0 && a.x <= 4000 && a.y >= 0 && a.y <= 4000) {
				        map[a.y][a.x] = 0;
				    }
				}

				// 5. Dead 인거 list 에서 삭제
				list.removeIf((a) -> a.isDead);
			}
			System.out.println("#" + tc + " " + totalE);
		}
	}
}