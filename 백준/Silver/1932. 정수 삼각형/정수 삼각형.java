import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][];
        dp = new int[N][];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            map[i] = new int[i+1];
            dp[i] = new int[i+1];
            for (int j = 0 ; j < map[i].length ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < N ; i++){
            dp[N-1][i] = map[N-1][i];
        }

        for (int i = N-2 ; i >= 0 ; i--){
            for (int j = 0 ; j < dp[i].length ; j++){
                dp[i][j] = map[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        System.out.println(dp[0][0]);
    }
}
