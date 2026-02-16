import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] start;

    static int[] dy ={-1,1,0,0};
    static int[] dx ={0,0,-1,1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start = new int[]{i, j};
                }
            }
        }
        bfs(start);
        printMap(map);
    }

    static void bfs(int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        map[start[0]][start[1]] = 0;
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if (inRange(cy,cx) && map[cy][cx] == 1 && !visited[cy][cx]) {
                    map[cy][cx] = map[y][x] + 1;
                    queue.offer(new int[]{cy,cx});
                    visited[cy][cx] = true;
                }
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    private static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    System.out.print(-1 + " ");
                }else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
