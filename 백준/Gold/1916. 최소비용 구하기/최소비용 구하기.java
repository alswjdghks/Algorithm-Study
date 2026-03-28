import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge>{
        int to;
        int weight;

        public Edge(int to, int weight){
            super();
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e1){
            return this.weight - e1.weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Edge>[] A;
    static int N;
    static int M;
    static int start;
    static int end;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 5
        M = Integer.parseInt(br.readLine()); // 8

        A = new ArrayList[N+1];
        for(int i = 0 ; i < N+1; i++){
            A[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A[s].add(new Edge(e,w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = dijkstra(start);
        System.out.println(dist[end]);
    }

    private static int[] dijkstra(int start){
        int[] minDist = new int[N+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        minDist[start] = 0;
        pq.offer(new Edge(start,0));

        while (!pq.isEmpty()){
            Edge e = pq.poll();
            int to = e.to;
            int weight = e.weight;

            if (minDist[to] < weight) continue;

            for(Edge next : A[to]){
                if (minDist[next.to] > minDist[to] + next.weight){
                    minDist[next.to] = minDist[to] + next.weight;
                    pq.offer(new Edge(next.to, minDist[next.to]));
                }
            }
        }

        return minDist;
    }
}
