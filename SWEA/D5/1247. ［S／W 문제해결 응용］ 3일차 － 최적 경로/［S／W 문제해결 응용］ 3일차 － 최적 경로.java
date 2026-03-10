import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static Node home;
	static Node company;
	static int N;

	static boolean[] isSelected;
	static Node[] seq;
	static int min;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine()); // 5

			st = new StringTokenizer(br.readLine());

			company = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			Node[] nodeList = new Node[N];
			seq = new Node[N];
			isSelected = new boolean[N];

			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				nodeList[i] = new Node(x, y);
			}

			permutation(0, nodeList);
			sb.append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void permutation(int index, Node[] nodeList) {
		if (index == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += calDistance(seq[i], seq[i + 1]);
			}
			sum += calDistance(company, seq[0]) + calDistance(seq[N - 1], home);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			seq[index] = nodeList[i];
			permutation(index + 1, nodeList);
			isSelected[i] = false;
		}
	}

	public static int calDistance(Node start, Node end) {
		return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
	}

}
