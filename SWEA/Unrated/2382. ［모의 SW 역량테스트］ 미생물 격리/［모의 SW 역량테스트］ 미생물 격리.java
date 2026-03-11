import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Micro {
		int r, c, cnt, dir, total; // cnt : 현시간의 군집의 원래 크기, total : 합쳐지는 군집의 크기

		public Micro(int r, int c, int cnt, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.total = this.cnt = cnt;
			this.dir = dir;
		}
	}

	static int N, M, K;
	static int dr[] = { 0, -1, 1, 0, 0 }; // 상:1, 하:2, 좌:3, 우:4
	static int dc[] = { 0, 0, 0, -1, 1 };
	static Micro[] list; // 미생물 굱비 리스트
	static Micro[][] map; // 미생물의 이동을 기록(병합관리 위해) -> map[nr][nc] = list[i]; 형태로 저장

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			list = new Micro[K]; // 미생물 군집리스트
			map = new Micro[N][N]; // 미생물의 시간에 따른 이동을 기록

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				list[i] = new Micro(Integer.parseInt(st.nextToken()), // r
						Integer.parseInt(st.nextToken()), // c
						Integer.parseInt(st.nextToken()), // cnt
						Integer.parseInt(st.nextToken()) // dir
				); // 미생물 리스트 입력 끝
			}

			sb.append(solve()).append("\n");
		}
		System.out.println(sb);
	}

	private static int solve() { // M시간 격리 후 살아 있는 미생물 수의 총합 리턴

		int time = M, nr, nc, remainCnt = 0;
		// M 시간동안 처리
		while (--time >= 0) {
			for (Micro cur : list) {
				if (cur.cnt == 0)
					continue; // 소멸된 군집이면 처리할 것이 없으므로 다음으로...

				// 군집 다음 좌표로 좌표 update
				nr = cur.r += dr[cur.dir];
				nc = cur.c += dc[cur.dir];
				// 가장 자리 셀인 경우는 크기 1/2 & 방향 반대로
				if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
					cur.total = cur.cnt = cur.cnt / 2;
					if (cur.cnt == 0)
						continue; // 군집 소멸되었으면 아래 처리 skip하고 다음 군집으로...
					if (cur.dir % 2 == 1)
						cur.dir++;
					else
						cur.dir--;
				}
				// 업데이트 된 좌표로 이동하며 병합
				if (map[nr][nc] == null) { // 이동하는 위치에 자신이 처음 도착한거면
					map[nr][nc] = cur;
				} else { // 이동하는 위치에 먼저 도착한 군집이 있다면 군집의 크기를 비교해서 병합
					if (map[nr][nc].cnt > cur.cnt) {
						map[nr][nc].total += cur.cnt;
						cur.cnt = 0; // 현재 군집은 흡수 되었으므로 미생물 수는 0으로 소멸
					} else { // 먼저 도착한 군집보다 현재 군집의 크기가 더 크다면 자신이 흡수함
						cur.total += map[nr][nc].total;
						map[nr][nc].cnt = 0; // 군집소멸
						map[nr][nc] = cur; // 새로운 군집으로 교체
					}
				}
			} // end for micro list

			remainCnt = reset();
		} // end while time

		return remainCnt;
	}

	static int reset() {
		int result = 0;
		for (Micro cur : list) {
			if (cur.cnt == 0)
				continue;
			if (map[cur.r][cur.c] == cur) {
				cur.cnt = cur.total;
				map[cur.r][cur.c] = null;
			}
			result += cur.cnt;
		}
		return result;
	}
}
