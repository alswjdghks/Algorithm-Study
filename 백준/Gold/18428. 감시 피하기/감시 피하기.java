import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] map;
	static int[][] selected;
	static ArrayList<int[]> students = new ArrayList<>();
	static int N;
	static boolean result;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine()); // 5
		map = new char[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'S') {
					students.add(new int[] {i,j});
				}
			}
		} // map 완성
		
		selected = new int[3][2]; // 장애물 위치 설정
		
		// students 양옆에 T 있으면 바로 return;
		for(int i = 0 ; i < students.size() ; i++) {
			int y = students.get(i)[0];
			int x = students.get(i)[1];
			for(int d = 0 ; d < 4 ; d++) {
				int cy = y + dy[d];
				int cx = x + dx[d];
				if(inRange(cy,cx) && map[cy][cx] == 'T') {
					System.out.println("NO");
					return;
				}
			}
		}
		
		dfs(0);
		System.out.print(result ? "YES" : "NO");
	}
	
	private static void dfs(int index) {
		if(index == 3) {
			if(check()) {
				result = true;
			}
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] != 'X') continue;
				map[i][j] = 'O';
				selected[index] = new int[] {i,j};
				dfs(index + 1);
				map[i][j] = 'X';
			}
		}
	}
	
	private static boolean check() {
		for(int i = 0 ; i < students.size() ; i++) {
			int y = students.get(i)[0];
			int x = students.get(i)[1];
			for(int d = 0 ; d < 4 ; d++) {
				boolean isOk = checkDir(y,x,d);
				if(!isOk) return false;
			}
		}
		return true;
	}
	
	private static boolean checkDir(int y, int x, int d) {
		int ny = y;
		int nx = x;
		while(true) {
			int cy = ny + dy[d];
			int cx = nx + dx[d];
			if(!inRange(cy,cx)) break;
			if(map[cy][cx] == 'T') return false;
			else if(map[cy][cx] == 'O') break;
			else {
				ny = cy;
				nx = cx;
			}
		}
		return true;
	}
	
	private static boolean inRange(int y, int x) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
