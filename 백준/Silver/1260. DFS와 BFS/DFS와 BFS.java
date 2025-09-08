import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer> A_BFS[];
    public static boolean visited_BFS[];

    public static ArrayList<Integer> A_DFS[];
    public static boolean visited_DFS[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int start_Node = Integer.parseInt(st.nextToken()); // 시작 정점

        A_BFS = new ArrayList[N+1];
        A_DFS = new ArrayList[N+1];
        visited_BFS = new boolean[N+1];
        visited_DFS = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            A_BFS[i] = new ArrayList<>();
            A_DFS[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A_BFS[start].add(end);
            A_BFS[end].add(start);
            A_DFS[start].add(end);
            A_DFS[end].add(start);
        }

        for (int i =1 ; i < N+1 ; i++){
            Collections.sort(A_DFS[i]);
            Collections.sort(A_BFS[i]);
        }

        DFS(start_Node);
        System.out.println();
        BFS(start_Node);
    }
    public static void DFS(int start){
        if (visited_DFS[start]) return;
        visited_DFS[start] = true;
        System.out.print(start+ " ");
        for (int i : A_DFS[start]) {
            if(!visited_DFS[i]) DFS(i);
        }

    }
    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited_BFS[start] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur+ " ");
            for (int i : A_BFS[cur]) {
                if (!visited_BFS[i]){
                    visited_BFS[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
