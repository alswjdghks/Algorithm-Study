import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer> A[];
    public static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드 개수
        int M = Integer.parseInt(br.readLine()); // 간선 개수

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        DFS(1);
        int count = 0;
        for (int i = 2; i < N+1; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static void DFS(int start){
        if (visited[start]) return;
        visited[start] = true;
        for(int i : A[start]){
            if (!visited[i]) DFS(i);
        }
    }
}
