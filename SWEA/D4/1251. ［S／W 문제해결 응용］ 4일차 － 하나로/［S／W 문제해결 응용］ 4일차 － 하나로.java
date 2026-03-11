import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static class Node {
		long x, y;
		int vertex;

		public Node(long x, long y, int vertex) {
			super();
			this.x = x;
			this.y = y;
			this.vertex = vertex;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N; // 정점의 개수
	static double E;

	static boolean[] visited; // 방문 여부
	static Node[] nodeList;
	static double[] minEdge; // 최소거리

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine()); // 2
			long[] X = new long[N];
			long[] Y = new long[N];
			nodeList = new Node[N];
			minEdge = new double[N];
			visited = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				X[i] = Long.parseLong(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Y[i] = Long.parseLong(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				nodeList[i] = new Node(X[i], Y[i], i);
			}

			E = Double.parseDouble(br.readLine());

			Arrays.fill(minEdge, Long.MAX_VALUE);

			int c = 0;
			double result = 0;
			minEdge[0] = 0;

			for (c = 0; c < N; c++) {
				// step 1. 비트리 정점 중 최소 간선 비용의 정점 선택
				double min = Double.MAX_VALUE;
				int minVertex = -1;

				for (int i = 0; i < N; i++) {
					if (!visited[i] && min > minEdge[i]) {
						min = minEdge[i];
						minVertex = i;
					}
				}

				if (minVertex == -1)
					break;
				visited[minVertex] = true;
				result += min;

				// step 2. 트리에 새롭게 추가된 정점(minVertex)과 비트리 인접정점의 간선 비용 비교해서 업데이트
				for (int i = 0; i < N; i++) {
					if (!visited[i] && minEdge[i] > calEdge(minVertex, i)) {
						minEdge[i] = calEdge(minVertex, i);
					}
				}
			}
			sb.append(Math.round(result)).append("\n");
		}
		System.out.println(sb);
	}

	private static double calEdge(int v1, int v2) {
		Node n1 = nodeList[v1];
		Node n2 = nodeList[v2];
		return E * calDistance(n1.x, n2.x, n1.y, n2.y);
	}

	private static double calDistance(long x1, long x2, long y1, long y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}
