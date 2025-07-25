import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1,0,-1,0}; // 행
    static int[] dy = {0,1,0,-1}; // 열
    static boolean[][] visited;
    static int[][] A;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            for(int k = 0; k < 4; k++) {
                int x = data[0] + dx[k];
                int y = data[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M){
                    if(visited[x][y] == false && A[x][y] != 0){
                        A[x][y] = A[data[0]][data[1]]+1;
                        visited[x][y] = true;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
        }
    }
}
