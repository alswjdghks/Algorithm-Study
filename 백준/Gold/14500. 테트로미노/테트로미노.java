import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N; // 세로
    static int M; // 가로
    static int[][] map;
    static int max;
    static int[][] selected;

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new int[4][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(0,i,j);
                checkT(i,j);
            }
        }

        System.out.println(max);
    }

    private static void checkT(int row,int col){
        int sum = map[row][col];
        int cnt = 1;
        int min = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            int ny = row + dy[d];
            int nx = col + dx[d];
            if (inRange(ny,nx)){
                sum += map[ny][nx];
                cnt++;
                min = Math.min(min,map[ny][nx]);
            }
        }
        if (cnt >= 4){
            if (cnt > 4){
                sum = sum - min;
            }
        }
        max = Math.max(sum,max);
    }

    private static void dfs(int index, int row, int col) {
        if (index == 4){
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += map[selected[i][0]][selected[i][1]];
            }
            max = Math.max(max,sum);
            return;
        }
        selected[index] = new int[]{row, col};
        for (int i = 0; i < 4; i++) {
            int ny = row + dy[i];
            int nx = col + dx[i];
            if (inRange(ny,nx) && check(index, ny,nx)){
                dfs(index+1, ny,nx);
            }
        }
    }

    private static boolean check(int index, int ny, int nx) {
        for (int i= 0; i < index; i++) {
            if (selected[i][0] == ny && selected[i][1] == nx){
                return false;
            }
        }
        return true;
    }

    private static boolean inRange(int y, int x){
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
