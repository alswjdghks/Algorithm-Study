import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] sem;
    static int[] indeg;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        sem = new int[N+1];
        indeg = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            indeg[end]++;
        }

        for (int i = 1; i <= N; i++) {
            TopologicalSort(i);
        }

        for (int i = 1; i <= N; i++) {
            sb.append(sem[i]).append(" ");
        }
        System.out.println(sb.toString());

    }

    private static void TopologicalSort(int start){
        if (sem[start] != 0){
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        sem[start] = 1;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int num : A[cur]){
                sem[num] = Math.max(sem[num], sem[cur] + 1);
                if (--indeg[num] == 0){
                    queue.add(num);
                }
            }
        }
    }
}
