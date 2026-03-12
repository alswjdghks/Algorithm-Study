import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int M;
	static int K;
	static boolean[] visited;
	static int[] minEdge;
	static ArrayList<Edge>[] A;
	static int[] E;

	static class Edge implements Comparable<Edge> {
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		E = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			E[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			A[start].add(new Edge(end, weight));
			A[end].add(new Edge(start, weight));
		}

		minEdge = new int[N + 1];
		visited = new boolean[N + 1];

		Arrays.fill(minEdge, Integer.MAX_VALUE);

		System.out.println(prim());
	}

	private static int prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int result = 0;
		int cnt = 0;

		for (int i = 0; i < K; i++) {
			minEdge[E[i]] = 0;
			visited[E[i]] = true;
			for (Edge e : A[E[i]]) {
				pq.add(e);
			}
		}

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			int node = curr.to;
			int weight = curr.weight;

			if (visited[node])
				continue;

			visited[node] = true;
			result += weight;
			cnt++;

			if (cnt == N - K)
				break;

			for (Edge next : A[node]) {
				if (!visited[next.to] && minEdge[next.to] > next.weight) {
					pq.add(next);
					minEdge[next.to] = next.weight;
				}
			}
		}

		return result;
	}
}
