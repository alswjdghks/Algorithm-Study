import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Integer[] visited;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new Integer[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 0;
        while (!queue.isEmpty() && visited[M] == null) {
            int now = queue.poll();

            if (now == 0) {
                if (visited[now+1] == null) {
                    queue.add(now + 1);
                    visited[now+1] = visited[now] + 1;
                }
            } else if (now == 100000) {
                if (visited[now-1] == null) {
                    queue.add(now - 1);
                    visited[now - 1] = visited[now] + 1;
                }
            } else {

                if (visited[now-1] == null) {
                    queue.add(now - 1);
                    visited[now - 1] = visited[now] + 1;
                }

                if (visited[now+1] == null) {
                    queue.add(now + 1);
                    visited[now + 1] = visited[now] + 1;
                }

                if (now*2 <= 100000 && visited[now * 2] == null) {
                    queue.add(now * 2);
                    visited[now * 2] = visited[now] + 1;
                }
            }
        }
        System.out.println(visited[M]);
    }
}
