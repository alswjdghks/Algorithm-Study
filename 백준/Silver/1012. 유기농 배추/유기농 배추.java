import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};
    public static int[][] A;
    public static boolean[][] visited;
    public static int M; // 가로 길이
    public static int N; // 세로 길이
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            st= new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로길이(열의 개수)
            N = Integer.parseInt(st.nextToken()); // 세로길이(행의 개수)
            int K = Integer.parseInt(st.nextToken()); // 배추개수

            A = new int[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                st= new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                A[y][x] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (A[j][k] == 1 && visited[j][k] == false) {
                        BFS(j, k);
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }

    }
    public static void BFS(int i, int j) {
        count++;
        int[] now = {i,j};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(now);
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = curr[0] + dx[k]; // 행 -> 세로 길이
                int y = curr[1] + dy[k]; // 열 -> 가로 길이
                if (x >= 0 && y >=0 && x < N && y < M){
                    if (A[x][y] == 1 && !visited[x][y]){
                        visited[x][y] = true;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
        }
    }
}
