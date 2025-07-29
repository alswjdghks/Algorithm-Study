import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> A[];
    static int visited[];
    static int seq = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int start_N = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new int[N+1];
        A = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i],Collections.reverseOrder());
        }

        BFS(start_N);

        for (int i = 1; i < N+1; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void BFS(int start_N) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start_N] = seq++;
        queue.add(start_N);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i : A[cur]){
                if (visited[i] == 0){
                    visited[i] = seq++;
                    queue.add(i);
                }
            }
        }
    }
}
