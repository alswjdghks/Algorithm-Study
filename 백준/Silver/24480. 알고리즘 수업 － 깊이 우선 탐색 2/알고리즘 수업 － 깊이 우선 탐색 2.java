import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> A[];
    static int visited[];
    static int seq = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int start_N = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new int[N+1];
        A = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; i++){
            A[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        for(int i = 1 ; i <= N ; i++){
            Collections.sort(A[i],Collections.reverseOrder());
        }

        DFS(start_N);

        for(int i = 1 ; i<=N ; i++){
            System.out.println(visited[i]);
        }
    }
    private static void DFS(int start){
        if(visited[start] != 0) return;
        visited[start] = seq++;
        for(int i : A[start]){
            if(visited[i] == 0) DFS(i);
        }

    }
}
