import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int count;
    static int[] exercise;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 3
        K = Integer.parseInt(st.nextToken()); // 4

        exercise = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            exercise[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);
        System.out.println(count);
    }

    private static void dfs(int day, int cal){
        if (cal < 500) return;
        if (day == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(day+1, cal - K + exercise[i]);
            visited[i] = false;
        }
    }
}
