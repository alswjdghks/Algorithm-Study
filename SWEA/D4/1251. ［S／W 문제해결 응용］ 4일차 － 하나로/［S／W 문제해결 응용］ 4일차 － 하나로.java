import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static double E;
	static int[] parents;
	static ArrayList<Edge> edgeList;
	static Node[] selected;

	static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = -1;
		}
	}

	static int findSet(int a) {
		if (parents[a] < 0) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);

		if (rootA == rootB)
			return false;

		if (parents[rootA] <= parents[rootB]) { // rootA의 높이가 rootB의 높이보다 높다.
			parents[rootA] += parents[rootB];
			parents[rootB] = rootA;
		} else {
			parents[rootB] += parents[rootA];
			parents[rootA] = rootB;
		}
		return true;
	}

	static class Node {
		long x, y;
		int number;

		public Node(long x, long y, int number) {
			super();
			this.x = x;
			this.y = y;
			this.number = number;
		}
	}

	static class Edge {
		Node start;
		Node end;
		double weight;

		public Edge(Node start, Node end) {
			super();
			this.start = start;
			this.end = end;
			double value = Math.sqrt((start.x - end.x) * (start.x - end.x) + (start.y - end.y) * (start.y - end.y));
			this.weight = value * value * E;
		}
	}

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine()); // 2

			long[] X = new long[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}

			long[] Y = new long[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine());

			Node[] nodeArray = makeNode(X, Y);
			selected = new Node[2];
			edgeList = new ArrayList<>();
			makeEdge(0, 0, nodeArray);

			Collections.sort(edgeList, new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {
					return Double.compare(o1.weight, o2.weight);
				}

			});

			makeSet();

			int count = 0;
			double value = 0;
			for (Edge edge : edgeList) {
				if (union(edge.start.number, edge.end.number)) {
					count++;
					value += edge.weight;
					if (count == N - 1) {
						break;
					}
				}
			}

			sb.append(Math.round(value)).append("\n");
		}
		System.out.println(sb.toString());
	}

	static Node[] makeNode(long[] X, long[] Y) {
		Node[] nodeArray = new Node[N];
		for (int i = 0; i < N; i++) {
			nodeArray[i] = new Node(X[i], Y[i], i);
		}
		return nodeArray;
	}

	static void makeEdge(int index, int start, Node[] nodeArray) {

		if (index == 2) {
			edgeList.add(new Edge(selected[0], selected[1]));
			return;
		}

		for (int i = start; i < N; i++) {
			selected[index] = nodeArray[i];
			makeEdge(index + 1, i + 1, nodeArray);
		}
		return;
	}

}
