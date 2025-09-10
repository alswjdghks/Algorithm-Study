import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 횟수
        int[][] S = new int[3][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            S[0][i] = Math.min(S[1][i-1], S[2][i-1]) + Integer.parseInt(st.nextToken());
            S[1][i] = Math.min(S[0][i-1], S[2][i-1]) + Integer.parseInt(st.nextToken());
            S[2][i] = Math.min(S[0][i-1], S[1][i-1]) + Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.min(S[0][N], Math.min(S[1][N], S[2][N])));
    }
}
